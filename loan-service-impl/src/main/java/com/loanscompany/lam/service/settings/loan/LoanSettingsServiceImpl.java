package com.loanscompany.lam.service.settings.loan;

import com.loanscompany.lam.iservice.settings.loan.ILoanSettingsService;
import com.loanscompany.lam.model.settings.loan.LoanSettings;
import com.loanscompany.lam.repository.loan.LoanRepository;
import com.loanscompany.lam.repository.setting.loans.LoanSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * The implementation of the {@link ILoanSettingsService}
 *
 * @author percym
 */
public class LoanSettingsServiceImpl implements ILoanSettingsService {
    @Autowired
    private LoanSettingsRepository loanSettingsRepository;


    @Override
    public List<LoanSettings> findAllByActive(Boolean active) {
        return loanSettingsRepository.findAllByActive(active);
    }

    @Override
    public LoanSettings save(LoanSettings loanSettings) {
        return loanSettingsRepository.save(loanSettings);
    }

    @Override
    public void delete(Long loanId) {
        loanSettingsRepository.deleteById(loanId);

    }

    @Override
    public LoanSettings findOne(Long loanId) {
        return loanSettingsRepository.getOne(loanId);
    }

    @Override
    public List<LoanSettings> findAll() {
        return loanSettingsRepository.findAll();
    }

    @Override
    public List<LoanSettings> findAllByClient_Id(Long clientId) {
        return loanSettingsRepository.findAllByClient_Id(clientId);
    }
}
