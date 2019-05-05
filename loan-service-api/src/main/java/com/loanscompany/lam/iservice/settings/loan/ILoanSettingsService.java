package com.loanscompany.lam.iservice.settings.loan;

import com.loanscompany.lam.model.settings.loan.LoanSettings;

import java.util.List;

/**
 *
 * @author percym
 */
public interface ILoanSettingsService {

    List<LoanSettings> findAllByActive(Boolean active);

    LoanSettings save(LoanSettings loanSettings);

    void delete(Long memberId);

    LoanSettings findOne(Long memberId);

    List<LoanSettings> findAll();

    List<LoanSettings> findAllByClient_Id(Long clientId);
}
