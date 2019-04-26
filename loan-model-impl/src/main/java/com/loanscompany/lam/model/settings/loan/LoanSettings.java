package com.loanscompany.lam.model.settings.loan;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.loanscompany.lam.imodel.client.IClient;
import com.loanscompany.lam.imodel.settings.applicant.IApplicantAddressSettings;
import com.loanscompany.lam.imodel.settings.applicant.IApplicantPersonalDetailsSettings;
import com.loanscompany.lam.imodel.settings.employment.IEmploymentSettings;
import com.loanscompany.lam.imodel.settings.guarantor.IGuarantorSettings;
import com.loanscompany.lam.imodel.settings.kyc.IKycSettings;
import com.loanscompany.lam.imodel.settings.loan.ILoanSettings;
import com.loanscompany.lam.imodel.settings.nextofkin.INextOfKinSettings;
import com.loanscompany.lam.imodel.settings.nonres.INonResidentSettings;
import com.loanscompany.lam.imodel.settings.property.IPropertySettings;
import com.loanscompany.lam.model.client.Client;
import com.loanscompany.lam.model.general.Active;
import com.loanscompany.lam.model.general.TimeActiveRecord;
import com.loanscompany.lam.model.settings.applicant.ApplicantAddressSettings;
import com.loanscompany.lam.model.settings.applicant.ApplicantPersonalDetailsSettings;
import com.loanscompany.lam.model.settings.employment.EmploymentSettings;
import com.loanscompany.lam.model.settings.guarantor.GuarantorSettings;
import com.loanscompany.lam.model.settings.kyc.KYCSettings;
import com.loanscompany.lam.model.settings.nextofkin.NextOfKinSettings;
import com.loanscompany.lam.model.settings.nonres.NonResidentSettings;
import com.loanscompany.lam.model.settings.property.PropertySettings;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author percym
 * <p>
 * Implementation for the {@link ILoanSettings} class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "loan_settings")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "loan_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "loan_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "loan_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "loan_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "loan_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "loan_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "loan_updated_on")),
        @AttributeOverride(name = "active", column = @Column(name = "loan_is_active"))
})
public class LoanSettings extends Active implements ILoanSettings {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Column(name = "loan_name")
    private String name;

    @Valid
    @JsonDeserialize(as = ApplicantPersonalDetailsSettings.class)
    @OneToOne(targetEntity = ApplicantPersonalDetailsSettings.class,  cascade = {CascadeType.ALL}, orphanRemoval = true)
    private IApplicantPersonalDetailsSettings applicantPersonalDetailsSettings;

    @Valid
    @JsonDeserialize(as = ApplicantAddressSettings.class)
    @OneToOne(targetEntity = ApplicantAddressSettings.class,  cascade = {CascadeType.ALL}, orphanRemoval = true)
    private IApplicantAddressSettings applicantAddressSettings;

    @Valid
    @JsonDeserialize(as = EmploymentSettings.class)
    @OneToOne(targetEntity = GuarantorSettings.class,  cascade = {CascadeType.ALL}, orphanRemoval = true)
    private IEmploymentSettings employmentSettings;

    @Valid
    @JsonDeserialize(as = GuarantorSettings.class)
    @OneToOne(targetEntity = GuarantorSettings.class,  cascade = {CascadeType.ALL}, orphanRemoval = true)
    private IGuarantorSettings guarantorSettings;

    @Valid
    @JsonDeserialize(as = KYCSettings.class)
    @OneToOne(targetEntity = KYCSettings.class,  cascade = {CascadeType.ALL}, orphanRemoval = true)
    private IKycSettings kycSettings;

    @Valid
    @JsonDeserialize(as = NextOfKinSettings.class)
    @OneToOne(targetEntity = NextOfKinSettings.class,  cascade = {CascadeType.ALL}, orphanRemoval = true)
    INextOfKinSettings nextOfKinSettings;

    @Valid
    @NotNull
    @JsonDeserialize(as = Client.class)
    @OneToOne(targetEntity = Client.class,  cascade = {CascadeType.DETACH}, orphanRemoval = true)
    private IClient client;

    @NotNull
    @Column(name = "loan_insurance_rate")
    Long insuranceRate;


    @NotNull
    @Column(name = "loan_interest_rate")
    Long interestRate;

    @NotNull
    @DecimalMin("0.00")
    @Column(name = "loan_other_fees", columnDefinition = "numeric(24,2) default '0.00'")
    BigDecimal otherFees;

}
