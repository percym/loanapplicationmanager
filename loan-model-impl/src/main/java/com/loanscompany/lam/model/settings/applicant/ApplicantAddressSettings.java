package com.loanscompany.lam.model.settings.applicant;

import com.loanscompany.lam.imodel.settings.applicant.IApplicantAddressSettings;
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
 * Implementation for the {@link IApplicantAddressSettings} class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "applicant_address _settings")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "applicant_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "applicant_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "applicant_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "applicant_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "applicant_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "applicant_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "applicant_updated_on"))
})
public class ApplicantAddressSettings extends TimeActiveRecord implements IApplicantAddressSettings {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Column(name = "applicant_home_address")
    private Boolean requireCurrentHomeAddress;

    @NotNull
    @Column(name = "applicant_previous_address")
    private Boolean requirePreviousHomeAddress;

    @NotNull
    @Column(name = "applicant_postal_address")
    private Boolean requirePostalAddress;

    @NotNull
    @Column(name = "applicant_time_at_address")
    private Boolean requireTimeAtCurrentAddress;

    @NotNull
    @Column(name = "applicant_time_at_previous_address")
    private Boolean requireTimeAtPreviousAddress;

}
