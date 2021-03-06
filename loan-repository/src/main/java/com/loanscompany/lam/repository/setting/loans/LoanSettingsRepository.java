package com.loanscompany.lam.repository.setting.loans;

import com.loanscompany.lam.model.settings.loan.LoanSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository for the {@link LoanSettings} entity
 * @author percym
 */
@Repository
public interface LoanSettingsRepository extends JpaRepository<LoanSettings, Long>, JpaSpecificationExecutor<LoanSettings> {
    List<LoanSettings> findAllByActive(Boolean active);
    List<LoanSettings> findAllByClient_Id(Long clientId);
 }

