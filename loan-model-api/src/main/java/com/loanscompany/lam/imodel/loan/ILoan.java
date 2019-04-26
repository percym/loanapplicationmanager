package com.loanscompany.lam.imodel.loan;

import com.loanscompany.lam.imodel.general.IApproved;
import com.loanscompany.lam.imodel.member.IMember;
import com.loanscompany.lam.imodel.user.ISystemUser;

import java.lang.reflect.Member;
import java.math.BigDecimal;

/**
 * The interface for all loans created
 *
 * @author percym
 */
public interface ILoan extends IApproved{

    /**
     * Returns the member for this location.
     *
     * @return member for this location.
     */
    IMember getMember();

    /**
     * Returns the member for this location.
     *
     * @param  member for this location.
     */
    void setMember(Member member);
    /**
     * Returns the member for this location.
     *
     * @return member for this location.
     */
    IMember getMember();

    /**
     * Returns the member for this location.
     *
     * @param  member for this location.
     */
    void setMember(Member member);



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

    /**
     * Returns the purpose for this location.
     *
     * @return loanPurpose for this location.
     */
    String getLoanPurpose();

    /**
     * sets the purpose for this location.
     *
     * @param  loanPurpose for this location.
     */

    void setLoanPurpose(String loanPurpose);

    /**
     * Returns the settings template for this loan.
     *
     * @return loanSettingsId for this loan.
     */
    Long getLoanSettingsId();

    /**
     * Sets the settings template used for  this loan.
     *
     * @param  loanSettingsId for this loan.
     */

    void setLoanSettingsId(String loanSettingsId);
    /**
     * Gets the {@link ISystemUser user} of the member.
     *
     * @return { {@link ISystemUser user} of the member.
     */
    ISystemUser getSystemUser();

    /**
     * Sets the {@link ISystemUser user} of the member.
     *
     * @param user of  the area user was created member.
     */
    void setSystemUser(ISystemUser user);



}
