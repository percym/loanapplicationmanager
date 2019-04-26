package com.loanscompany.lam.imodel.loan;

import com.loanscompany.lam.imodel.general.IApproved;

import java.math.BigDecimal;

/**
 * The interface for all loans created
 *
 * @author percym
 */
public interface ILoan extends IApproved{

    /**
     * Returns the tenure for this location.
     *
     * @return tenure for this location.
     */
    Long getTenure();

    /**
     * Returns the tenure for this location.
     *
     * @param  tenure for this location.
     */
    void setTenure(Long tenure);

    /**
     * Returns the purpose for this location.
     *
     * @return loanPurpose for this location.
     */
    String getLoanPurpose();


    /**
     * Returns the purpose for this location.
     *
     * @return loanPurpose for this location.
     */

    void setLoanPurpose(String Loan);
    /**
     * Returns the loan amount for this location.
     *
     * @return loan amount  for this location.
     */

    BigDecimal getLoanAmount();

    /**
     * Sets the loan amount for this location.
     *
     * @param loanAmount  for this location.
     */
    void setLoanAmount(BigDecimal loanAmount);

    /**
     * Returns the loan instalment  for this location.
     *
     * @return loan amount  for this location.
     */

    BigDecimal getInstallment();

    /**
     * Sets the loan amount for this location.
     *
     * @param loanAmount  for this location.
     */
    void setInstallment(BigDecimal loanAmount);

}
