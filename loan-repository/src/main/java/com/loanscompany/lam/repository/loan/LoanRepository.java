package com.loanscompany.lam.repository.loan;

import com.loanscompany.lam.model.loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository for the {@link Loan} entity
 *
 * @author percym
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> , JpaSpecificationExecutor<Loan>{
        List<Loan> findAllByApproved(Boolean approved);
}
