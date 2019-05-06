package com.loanscompany.lam.endpoint.controller.loan;

import com.codahale.metrics.annotation.Timed;
import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.response.ResponseMessage;
import com.loanscompany.lam.iservice.loan.ILoanService;
import com.loanscompany.lam.model.loan.Loan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The controller for loans
 *
 * @author percym
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoanController {

    private final ILoanService loanService;

    public LoanController(ILoanService loanService) {
        this.loanService = loanService;
    }

    /**
     * GET  /loan: get all the loans .
     *
     * @return the ResponseEntity with status 200 (OK) and the list of loans in body
     */
    @GetMapping("/loan")
    @Timed
    public ResponseEntity<List<Loan>> getAllLoans() {
        log.debug("REST request to get all ILoan");
        List<Loan> loans = loanService.findAll();
        return new ResponseEntity<>(loans, null, HttpStatus.OK);
    }

    /**
     * POST  /loan: save loan .
     *
     * @return the ResponseEntity with status 200 (OK) and the list of loans in body
     */
    @PostMapping("/loan")
    @Timed
    public ResponseEntity<?> saveLoan(@Valid @RequestBody Loan loan) {
        log.debug("POST request to save ILoan");
        if (loan.getId() != null){
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid loan  id!"),
                    HttpStatus.BAD_REQUEST);
        }
        Loan savedLoan = loanService.save(loan);
        return new ResponseEntity<>(savedLoan, null, HttpStatus.OK);
    }


    /**
     * PUT /loan: update loan.
     *
     * @return the ResponseEntity with status 200 (OK) and the saved loan in body
     */
    @PutMapping("/loan")
    @Timed
    public ResponseEntity<?> updateLoan(@Valid @RequestBody Loan loan) {
        log.debug("POST request to save ILoan");
        if (loan.getId() == null){
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid loan  id!"),
                    HttpStatus.BAD_REQUEST);
        }
        if (loan.getId() == 0){
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid loan  id!"),
                    HttpStatus.BAD_REQUEST);
        }
        Loan savedLoan = loanService.save(loan);
        return new ResponseEntity<>(savedLoan, null, HttpStatus.OK);
    }


    /**
     * GET /loan/client/{clientId}: get all loans by client id
     *
     * @return the ResponseEntity with status 200 (OK) and the  loans by client id in body
     */
    @GetMapping("/loan/client/{clientId}")
    @Timed
    public ResponseEntity<?> getLoanByClientId(@PathVariable Long clientId ) {
        log.debug("GET request to get  ILoan by IClientId");
        List<Loan> savedLoan = loanService.findAllBySystemUser_Location_Client_Id(clientId);
        return new ResponseEntity<>(savedLoan, null, HttpStatus.OK);
    }


    /**
     * GET /loan/client/{idNumber}: get all loans by member id
     *
     * @return the ResponseEntity with status 200 (OK) and the  loans by member id in body
     */
    @GetMapping("/loan/member/{idNumber}")
    @Timed
    public ResponseEntity<?> getLoanByClientId(@PathVariable String idNumber ) {
        log.debug("GET request to get  ILoan by IMemberId");
        List<Loan> savedLoan = loanService.findAllByMember_IdNumber(idNumber);
        return new ResponseEntity<>(savedLoan, null, HttpStatus.OK);
    }



}