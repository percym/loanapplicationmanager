package com.loanscompany.lam.model.settings.applicant;

import com.loanscompany.lam.imodel.member.IMember;
import com.loanscompany.lam.imodel.settings.applicant.IApplicantAddressSettings;
import com.loanscompany.lam.imodel.settings.applicant.IApplicantPersonalDetailsSettings;
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
@Table(schema = "data", name = "applicant_personal_settings")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "applicant_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "applicant_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "applicant_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "applicant_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "applicant_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "applicant_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "applicant_updated_on"))
})
public class ApplicantPersonalDetailsSettings extends TimeActiveRecord implements IApplicantPersonalDetailsSettings {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Column(name = "applicant_depedendants")
    private Boolean requireNumberOfDependants;

    @NotNull
    @Column(name = "applicant_children")
    private Boolean requireNumberOfChildren;

    @NotNull
    @Column(name = "applicant_country")
    private Boolean requireCountryOfBirth;

    @NotNull
    @Column(name = "applicant_place_birth")
    private Boolean requirePlaceOfBirth;

    @NotNull
    @Column(name = "applicant_nationality")
    private Boolean requireNationality;

    @NotNull
    @Column(name = "applicant_citizenship")
    private Boolean requireCitizenShip;

    @NotNull
    @Column(name = "applicant_race")
    private Boolean requireRace;

    @NotNull
    @Column(name = "applicant_email")
    private Boolean requireEmail;

}
