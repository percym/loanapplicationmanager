package com.loanscompany.lam.imodel.settings.loan;

import com.loanscompany.lam.imodel.client.IClient;
import com.loanscompany.lam.imodel.general.IActive;
import com.loanscompany.lam.imodel.settings.applicant.IApplicantAddressSettings;
import com.loanscompany.lam.imodel.settings.applicant.IApplicantPersonalDetailsSettings;
import com.loanscompany.lam.imodel.settings.employment.IEmploymentSettings;
import com.loanscompany.lam.imodel.settings.guarantor.IGuarantorSettings;
import com.loanscompany.lam.imodel.settings.kyc.IKycSettings;
import com.loanscompany.lam.imodel.settings.nextofkin.INextOfKinSettings;
import com.loanscompany.lam.imodel.settings.nonres.INonResidentSettings;
import com.loanscompany.lam.imodel.settings.property.IPropertySettings;

import java.math.BigDecimal;

/**
 * The interface for Loans created in the system
 *
 * @author percym
 */
public interface ILoanSettings extends IActive{
    /**
     * Returns the name for this setting.
     *
     * @return the name for this setting.
     */
    String getName();

    /**
     * Returns the name for this setting.
     *
     * @param  name for this setting.
     */
    void setName(String name);
    /**
     * Returns  applicant personal details settings for this loan.
     *
     * @return applicant settings for this loan.
     */

    IApplicantPersonalDetailsSettings getApplicantPersonalDetailsSettings();

    /**
     * Sets  applicant personal details settings for this loan.
     *
     * @param  applicantPersonalDetailsSettings settings for this loan.
     */
    void setApplicantPersonalDetailsSettings(IApplicantPersonalDetailsSettings applicantPersonalDetailsSettings);

    /**
     * Returns  applicant settings for this loan.
     *
     * @return applicant settings for this loan.
     */

    IApplicantAddressSettings getApplicantAddressSettings();

    /**
     * Sets  applicant settings for this loan.
     *
     * @param  applicantAddressSettings settings for this loan.
     */
    void setApplicantAddressSettings(IApplicantAddressSettings applicantAddressSettings);

    /**
     * Returns  applicant settings for this loan.
     *
     * @return applicant settings for this loan.
     */

    IEmploymentSettings getEmploymentSettings();

    /**
     * Sets  employment settings for this loan.
     *
     * @param  employmentSettings settings for this loan.
     */
    void setEmploymentSettings(IEmploymentSettings employmentSettings);


    /**
     * Returns  applicant settings for this loan.
     *
     * @return applicant settings for this loan.
     */
    IGuarantorSettings getGuarantorSettings();

    /**
     * Sets  Guarantor settings for this loan.
     *
     * @param  guarantorSettings settings for this loan.
     */
    void setGuarantorSettings(IGuarantorSettings guarantorSettings);

    /**
     * Returns  kyc settings for this loan.
     *
     * @return kyc settings for this loan.
     */
    IKycSettings getKycSettings();

    /**
     * Sets  kyc settings for this loan.
     *
     * @param  kycSettings settings for this loan.
     */
    void setKycSettings(IKycSettings kycSettings);

    /**
     * Returns  nok settings for this loan.
     *
     * @return nok  settings for this loan.
     */
    INextOfKinSettings getNextOfKinSettings();

    /**
     * Sets  kyc settings for this loan.
     *
     * @param  nextOfKinSettings settings for this loan.
     */
    void setNextOfKinSettings(INextOfKinSettings nextOfKinSettings);

    /**
     * Returns the {@link IClient <T> client} for this loan.
     *
     * @return the {@link IClient <T> client} for this loan.
     */

    IClient getClient();

    /**
     * Sets the {@link IClient <T> client} for this loan.
     *
     * @param client the  {@link IClient <T> client} for this loan.
     */
    void setClient(IClient client);

    /**
     * Return the interest rate for this loan.
     *
     * @return  interestRate  for this loan.
     */

    Long getInterestRate();

    /**
     * Sets the interest rate for this loan.
     *
     * @param interestRate  for this loan.
     */
    void setInterestRate(Long interestRate);

    /**
     * Return the insurance rate for this loan.
     *
     * @return  insuranceRate  for this loan.
     */

    Long getInsuranceRate();

    /**
     * Sets the insurance rate for this loan.
     *
     * @param insuranceRate  for this loan.
     */
    void setInsuranceRate(Long insuranceRate);

    /**
     * Return the other fees for this loan.
     *
     * @return  otherFees  for this loan.
     */

    BigDecimal getOtherFees();

    /**
     * Sets the other fees for this loan.
     *
     * @param otherFees  for this loan.
     */
    void setOtherFees(BigDecimal otherFees);

}
