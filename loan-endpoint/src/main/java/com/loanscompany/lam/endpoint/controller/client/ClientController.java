package com.loanscompany.lam.endpoint.controller.client;

import com.codahale.metrics.annotation.Timed;
import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.response.ResponseMessage;
import com.loanscompany.lam.iservice.client.IClientService;
import com.loanscompany.lam.iservice.fileUpload.StorageService;
import com.loanscompany.lam.model.client.Client;
import com.loanscompany.lam.model.client.Logo;
import com.loanscompany.lam.service.fileUpload.FileStorageService;
import com.loanscompany.lam.service.storage.StorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/*
 * Rest controller for managing Clients
 *
 * @author Munyaradzi Takayindisa
 *
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("*/api")
public class ClientController {

    private static final String ENTITY_NAME = "client";

    private final IClientService clientService;
    private final StorageService storageService;

    private final ResourceLoader resourceLoader;
    private final StorageProperties storageProperties;
    private final FileStorageService fileStorageService;

    public ClientController(IClientService clientService, StorageService storageService, ResourceLoader resourceLoader, StorageProperties storageProperties, FileStorageService fileStorageService) {
        this.clientService = clientService;
        this.storageService = storageService;
        this.resourceLoader = resourceLoader;
        this.storageProperties = storageProperties;
        this.fileStorageService = fileStorageService;
    }

    /**
     * POST  /client : Create a new client.
     *
     * @param client the client to create
     * @return the ResponseEntity with status 201 (Created) and with body the new client, or with status 400 (Bad Request) if the client has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping(value = "/client")
    @Timed
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client) throws URISyntaxException {
        log.debug("REST request to save IClient : {}", client);
        if (client.getId() != null) {
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid location id!"),
                    HttpStatus.BAD_REQUEST);;
        }
        Client result = clientService.save(client);
        return ResponseEntity.created(new URI("/api/client/" + result.getId()))
                .headers(null)
                .body(result);
    }

    /**
     * PUT  /client : Updates an existing client.
     *
     * @param client the client to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated client,
     * or with status 400 (Bad Request) if the client is not valid,
     * or with status 500 (Internal Server Error) if the client couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/client")
    @Timed
    public ResponseEntity<?> updateClient(@Valid @RequestBody Client client) throws URISyntaxException {
        log.debug("REST request to update IClient : {}", client);
        if (client.getId() == null) {
            return createClient(client);
        }
        Client result = clientService.save(client);
        return ResponseEntity.ok()
                .headers(null)
                .body(result);
    }

    /**
     * GET  /client : get all the clients.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of client in body
     */
    @GetMapping("/client")
    @Timed
    public ResponseEntity<List<Client>> getAllClients() {
        log.debug("REST request to get a page of IClient");
        List<Client> page = clientService.findAll();
        return new ResponseEntity<>(page, null, HttpStatus.OK);
    }

    /**
     * GET  /client/:id : get the "id" client.
     *
     * @param id the id of the client to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the client, or with status 404 (Not Found)
     */
    @GetMapping("/client/{id}")
    @Timed
    public ResponseEntity<?> getClient(@PathVariable Long id) {
        log.debug("REST request to get IClient : {}", id);
        Client client = clientService.findOne(id);
        return new ResponseEntity<>(client ,null ,HttpStatus.OK);
    }

    /**
     * DELETE  /client/:id : delete the "id" client.
     *
     * @param id the id of the client to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/client/{id}")
    @Timed
    public ResponseEntity<?> deleteClients(@PathVariable Long id) {
        log.debug("REST request to delete IClient : {}", id);
        clientService.delete(id);
        return new ResponseEntity<>(new ResponseMessage("Done -> Item deleted!"),
                HttpStatus.OK);
    }


    @PostMapping(value = "/client_logo/{clientId}")
    @Timed
    public ResponseEntity<Client> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                   RedirectAttributes redirectAttributes, @PathVariable("clientId")Long clientId) {
        Client client =clientService.findOne(clientId);
        Logo logo = new Logo();
//        storageService.store(file);
        String fileName = fileStorageService.storeFile(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/dova/api/logos/")
                .path(fileName)
                .toUriString();
        logo.setFileName(fileName);
        logo.setFileDownloadUri(fileDownloadUri);
        logo.setSize(file.getSize());
        logo.setFileType(file.getContentType());
//
//        if (file.getContentType().contentEquals("image/png")||file.getContentType().contentEquals("image/jpeg")){
//            System.out.println(file.getContentType() + "true");
//        }else{
//            System.out.println(file.getContentType() + "false");
//        }
        client.setLogo(logo);
        Client result = clientService.save(client);
        return ResponseEntity.ok()
                .headers(null)
                .body(result);
    }


    @GetMapping(value="/logos/{filename:.+}")
    public @ResponseBody
    void affichimage(@PathVariable String filename
            , HttpServletResponse response, HttpServletRequest request) throws
            IOException,NullPointerException
    {
        //database
        Resource file = storageService.loadAsResource(filename);
        File imageFile = new File(file.getURI());
        response.setContentType("image/jpeg");
        InputStream in=new FileInputStream(imageFile);
        IOUtils.copy(in, response.getOutputStream());
    }

}