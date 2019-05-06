package com.loanscompany.lam.service.loan;

import com.loanscompany.lam.iservice.loan.ILoanService;
import com.loanscompany.lam.model.loan.Loan;
import com.loanscompany.lam.repository.loan.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The implementation of the {@link ILoanService}
 *
 * @author percym
 */
@Service
@Transactional
public class LoanServiceImpl implements ILoanService{

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> findAllByApproved(Boolean approved) {
        return loanRepository.findAllByApproved(approved);
    }

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public void delete(Long loanId) {
        loanRepository.deleteById(loanId);

    }

    @Override
    public Loan findOne(Long loanId) {
        return loanRepository.getOne(loanId);
    }

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> findAllBySystemUser_Location_Client_Id(Long clientId) {
        return loanRepository.findAllBySystemUser_Location_Client_Id(clientId);
    }

    @Override
    public List<Loan> findAllByMember_IdNumber(String idNumber) {
        return loanRepository.findAllByMember_IdNumber(idNumber);
    }
}
