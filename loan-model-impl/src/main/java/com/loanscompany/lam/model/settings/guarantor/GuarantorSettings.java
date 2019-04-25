package com.loanscompany.lam.model.settings.guarantor;

import com.loanscompany.lam.imodel.member.IMember;
import com.loanscompany.lam.imodel.settings.employment.IEmploymentSettings;
import com.loanscompany.lam.imodel.settings.guarantor.IGuarantorSettings;
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
 * Implementation for the {@link IGuarantorSettings} class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "applicant_guarantor_settings")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "applicant_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "applicant_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "applicant_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "applicant_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "applicant_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "applicant_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "applicant_updated_on")),
})
public class GuarantorSettings extends TimeActiveRecord implements IGuarantorSettings {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Column(name = "guarantor_education")
    private Boolean requireOccupation;

    @NotNull
    @Column(name = "guarantor_employer")
    private Boolean requireEmployerName;

    @NotNull
    @Column(name = "guarantor_employer_address")
    private Boolean requireEmployerAddress;

    @NotNull
    @Column(name = "guarantor_employer_phone")
    private Boolean requireBusinessTelephoneNumber;

    @NotNull
    @Column(name = "guarantor_home_phone")
    private Boolean requireHomeTelephoneNumber;

    @NotNull
    @Column(name = "guarantor_bank_phone")
    private Boolean requireBankDetails;



}
