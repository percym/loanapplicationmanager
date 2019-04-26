package com.loanscompany.lam.iservice.settings.loan;

import com.loanscompany.lam.model.settings.loan.LoanSettings;

import java.util.List;

/**
 *
 * @author percym
 */
public interface ILoanSettingsService {

    List<LoanSettings> findAllByActive(Boolean active);

    LoanSettings save(LoanSettings member);

    void delete(Long memberId);

    LoanSettings findOne(Long memberId);

    List<LoanSettings> findAll();
}
