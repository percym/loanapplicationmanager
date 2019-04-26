package com.loanscompany.lam.iservice.loan;

import com.loanscompany.lam.model.loan.Loan;

import java.util.List;

/**
 * @author percym
 */
public interface ILoanService {

    List<Loan> findAllByApproved(Boolean approved);

    Loan save(Loan member);

    void delete(Long memberId);

    Loan findOne(Long memberId);

    List<Loan> findAll();
}
