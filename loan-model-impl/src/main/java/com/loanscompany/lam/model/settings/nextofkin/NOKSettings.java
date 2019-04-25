package com.loanscompany.lam.model.settings.nextofkin;

import com.loanscompany.lam.imodel.settings.kyc.IKycSettings;
import com.loanscompany.lam.imodel.settings.nextofkin.INextOfKinSettings;
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
 * Implementation for the {@link INextOfKinSettings} class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "nok_settings")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "nok_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "nok_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "nok_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "nok_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "nok_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "nok_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "nok_updated_on")),
})
public class NOKSettings extends TimeActiveRecord implements INextOfKinSettings {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Column(name = "nok_employer_name")
    private Boolean requireEmployerName;

    @NotNull
    @Column(name = "nok_employer_address")
    private Boolean requireEmployerAddress;

    @NotNull
    @Column(name = "nok_home_address")
    private Boolean requireHomeAddress;

    @NotNull
    @Column(name = "nok_bus_phone")
    private Boolean requireBusinessTelephoneNumber;

    @NotNull
    @Column(name = "nok_home_phone")
    private Boolean requireHomeTelephoneNumber;


}
