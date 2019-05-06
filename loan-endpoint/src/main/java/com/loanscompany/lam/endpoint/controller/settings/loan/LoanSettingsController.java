package com.loanscompany.lam.endpoint.controller.settings.loan;

/**
 * The rest controller for the loan settings
 *
 * @author percym
 */

import com.codahale.metrics.annotation.Timed;
import com.loanscompany.lam.endpoint.appconfig.security.jwt.message.response.ResponseMessage;
import com.loanscompany.lam.iservice.settings.loan.ILoanSettingsService;
import com.loanscompany.lam.model.settings.loan.LoanSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoanSettingsController {

    final ILoanSettingsService loanSettingsService ;

    public LoanSettingsController(ILoanSettingsService loanSettingsService) {
        this.loanSettingsService = loanSettingsService;
    }

    /**
     * GET  /loan_settings: get all the loan settings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of loan settings in body
     */
    @GetMapping("/loan_settings")
    @Timed
    public ResponseEntity<List<LoanSettings>> getAllLoanSettings() {
        log.debug("REST request to get all ILoanSettings");
        List<LoanSettings> loanSettings = loanSettingsService.findAll();
        return new ResponseEntity<>(loanSettings, null, HttpStatus.OK);
    }

    /**
     * POST  /loan_settings: save the loan settings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of loan settings in body
     */
    @PostMapping("/loan_settings")
    @Timed
    public ResponseEntity<?> saveLoanSettings(@Valid @RequestBody LoanSettings loanSettings) {
        log.debug("REST request to get all ILoanSettings");
        if (loanSettings.getId() != null){
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid loan settings id!"),
                        HttpStatus.BAD_REQUEST);
        }
        LoanSettings savedLoanSettings = loanSettingsService.save(loanSettings);
        return new ResponseEntity<>(savedLoanSettings, null, HttpStatus.OK);
    }

    /**
     * PUT  /loan_settings: update the loan settings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of loan settings in body
     */
    @PutMapping("/loan_settings")
    @Timed
    public ResponseEntity<?> updateLoanSettings(@Valid @RequestBody LoanSettings loanSettings) {
        log.debug("REST request to get all ILoanSettings");
        if (loanSettings.getId() != null){
            return   new ResponseEntity<>(new ResponseMessage("Fail ->Enter valid loan settings id!"),
                    HttpStatus.BAD_REQUEST);
        }
        LoanSettings savedLoanSettings = loanSettingsService.save(loanSettings);
        return new ResponseEntity<>(savedLoanSettings, null, HttpStatus.OK);
    }


    /**
     * GET  /loan_settings/client/{clientId}: get all the loan settings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of loan settings in body
     */
    @GetMapping("/loan_settings/client/{clientId}")
    @Timed
    public ResponseEntity<List<LoanSettings>> getAllLoanSettingsByClientId(Long clientId) {
        log.debug("REST request to get all ILoanSettings");
        List<LoanSettings> loanSettings = loanSettingsService.findAllByClient_Id(clientId);
        return new ResponseEntity<>(loanSettings, null, HttpStatus.OK);
    }

}
