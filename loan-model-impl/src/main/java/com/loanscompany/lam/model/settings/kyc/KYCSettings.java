package com.loanscompany.lam.model.settings.kyc;

import com.loanscompany.lam.imodel.settings.guarantor.IGuarantorSettings;
import com.loanscompany.lam.imodel.settings.kyc.IKycSettings;
import com.loanscompany.lam.model.general.TimeActiveRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author percym
 * <p>
 * Implementation for the {@link IKycSettings} class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "kyc_settings")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "kyc_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "kyc_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "kyc_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "kyc_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "kyc_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "kyc_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "kyc_updated_on")),
})
public class KYCSettings extends TimeActiveRecord implements IKycSettings {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Column(name = "kyc_national_id")
    private Boolean requireNationalId;

    @NotNull
    @Column(name = "kyc_pay_slip")
    private Boolean requirePaySlip;

    @NotNull
    @Column(name = "kyc_proof_residence")
    private Boolean requireProofOfResidence;

    @NotNull
    @Column(name = "kyc_loan_application")
    private Boolean requireLoanApplication;

    @NotNull
    @Column(name = "kyc_loan_side_one")
    private Boolean requireLoanFormSideOne;

    @NotNull
    @Column(name = "kyc_loan_side_two")
    private Boolean requireLoanFormSideTwo;

    @NotNull
    @Column(name = "kyc_mug_shot")
    private Boolean requireMugShot;
}
