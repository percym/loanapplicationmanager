package com.loanscompany.lam.model.settings.nonres;

import com.loanscompany.lam.imodel.settings.nextofkin.INextOfKinSettings;
import com.loanscompany.lam.imodel.settings.nonres.INonResidentSettings;
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
 * Implementation for the {@link INonResidentSettings} class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "nonres_settings")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "nonres_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "nonres_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "nonres_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "nonres_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "nonres_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "nonres_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "nonres_updated_on")),
})
public class NonResidentSettings extends TimeActiveRecord implements INonResidentSettings {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Column(name = "nonres")
    private Boolean requireNonResident;


}
