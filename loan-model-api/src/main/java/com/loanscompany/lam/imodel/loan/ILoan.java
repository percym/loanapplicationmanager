package com.loanscompany.lam.imodel.loan;

import com.loanscompany.lam.imodel.client.ILogo;
import com.loanscompany.lam.imodel.general.IApproved;
import com.loanscompany.lam.imodel.member.IMember;
import com.loanscompany.lam.imodel.member.INextOfKin;
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
     * Returns the member for this loan.
     *
     * @return member for this loan.
     */
    IMember getMember();

    /**
     * Returns the member for this loan.
     *
     * @param  member for this loan.
     */
    void setMember(IMember member);
    
    /**
     * Returns the next of kin  for this loan.
     *
     * @return next of kin for this loan.
     */
    INextOfKin getNextOfKin();

    /**
     * Returns the nextOfKin for this loan.
     *
     * @param  nextOfKin for this loan.
     */
    void setNextOfKin(INextOfKin nextOfKin);

    /**
     * Returns the guarantor  for this loan.
     *
     * @return guarantor for this loan.
     */
    INextOfKin getGuarantor();

    /**
     * Returns the guarantor for this loan.
     *
     * @param  guarantor for this loan.
     */
    void setGuarantor(INextOfKin guarantor);

    /**
     * Returns the national id image for this client.
     *
     * @return the national id image for this client.
     */
    ILogo getNationalId();

    /**
     * Sets the national id image for this client.
     *
     * @param nationalId  national id image for this client.
     */
    void setNationalId(ILogo nationalId);

    /**
     * Returns the paySlip image for this client.
     *
     * @return the paySlip image for this client.
     */
    ILogo getPaySlip();

    /**
     * Sets the paySlip image for this client.
     *
     * @param paySlip  national id image for this client.
     */
    void setPaySlip(ILogo paySlip);

    /**
     * Returns the loanApplicationSideOne image for this client.
     *
     * @return the loanApplicationSideOne image for this client.
     */
    ILogo getLoanApplicationSideOne();

    /**
     * Sets the loanApplicationSideOne image for this client.
     *
     * @param loanApplicationSideOne  national id image for this client.
     */
    void setLoanApplicationSideOne(ILogo loanApplicationSideOne);

    /**
     * Returns the loanApplicationSideTwo image for this client.
     *
     * @return the loanApplicationSideTwo image for this client.
     */
    ILogo getLoanApplicationSideTwo();

    /**
     * Sets the loanApplicationSideTwo image for this client.
     *
     * @param loanApplicationSideTwo  national id image for this client.
     */
    void setLoanApplicationSideTwo(ILogo loanApplicationSideTwo);

    /**
     * Returns the proofOfResidence image for this client.
     *
     * @return the proofOfResidence image for this client.
     */
    ILogo getProofOfResidence();

    /**
     * Sets the proofOfResidence image for this client.
     *
     * @param proofOfResidence  national id image for this client.
     */
    void setProofOfResidence(ILogo proofOfResidence);

    /**
     * Returns the tenure for this loan.
     *
     * @return tenure for this loan.
     */
    Long getTenure();

    /**
     * Returns the tenure for this loan.
     *
     * @param  tenure for this loan.
     */
    void setTenure(Long tenure);

    /**
     * Returns the loan amount for this loan.
     *
     * @return loan amount  for this loan.
     */

    BigDecimal getLoanAmount();

    /**
     * Sets the loan amount for this loan.
     *
     * @param loanAmount  for this loan.
     */
    void setLoanAmount(BigDecimal loanAmount);

    /**
     * Returns the loan instalment  for this loan.
     *
     * @return loan amount  for this loan.
     */

    BigDecimal getInstallment();

    /**
     * Sets the loan amount for this loan.
     *
     * @param installment  for this loan.
     */
    void setInstallment(BigDecimal installment);

    /**
     * Returns the purpose for this loan.
     *
     * @return loanPurpose for this loan.
     */
    String getLoanPurpose();

    /**
     * sets the purpose for this loan.
     *
     * @param  loanPurpose for this loan.
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

    void setLoanSettingsId(Long loanSettingsId);
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
