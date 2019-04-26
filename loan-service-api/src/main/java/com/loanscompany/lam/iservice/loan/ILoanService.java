package com.loanscompany.lam.iservice.loan;

import com.loanscompany.lam.model.loan.Loan;

import java.util.List;

/**
 * @author percym
 */
public interface ILoanService {

    List<Loan> findAllByApproved(Boolean approved);

    Loan save(Loan loan);

    void delete(Long loanId);

    Loan findOne(Long loanId);

    List<Loan> findAll();
}
