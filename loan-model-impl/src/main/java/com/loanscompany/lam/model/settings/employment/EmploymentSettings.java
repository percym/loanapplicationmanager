package com.loanscompany.lam.model.settings.employment;

import com.loanscompany.lam.imodel.member.IMember;
import com.loanscompany.lam.imodel.settings.applicant.IApplicantAddressSettings;
import com.loanscompany.lam.imodel.settings.employment.IEmploymentSettings;
import com.loanscompany.lam.model.general.Active;
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
 * Implementation for the {@link IEmploymentSettings} class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "applicant_employment_settings")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "applicant_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "applicant_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "applicant_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "applicant_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "applicant_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "applicant_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "applicant_updated_on")),
})
public class EmploymentSettings extends TimeActiveRecord implements IEmploymentSettings {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Column(name = "applicant_education")
    private Boolean requireEducationalQualification;

    @NotNull
    @Column(name = "applicant_income")
    private Boolean requireOtherMonthlyIncome;

    @NotNull
    @Column(name = "applicant_employment")
    private Boolean requireEmploymentStatus;

    @NotNull
    @Column(name = "applicant_current_employer")
    private Boolean requireCurrentEmployer;

    @NotNull
    @Column(name = "applicant_employer_address")
    private Boolean requireCurrentEmployerAddress;

}
