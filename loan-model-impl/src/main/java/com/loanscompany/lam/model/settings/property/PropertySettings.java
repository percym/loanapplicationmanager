package com.loanscompany.lam.model.settings.property;

import com.loanscompany.lam.imodel.settings.nextofkin.INextOfKinSettings;
import com.loanscompany.lam.imodel.settings.property.IPropertySettings;
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
 * Implementation for the {@link IPropertySettings} class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "property_settings")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "property_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "property_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "property_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "property_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "property_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "property_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "property_updated_on")),
})
public class PropertySettings extends TimeActiveRecord implements IPropertySettings {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Column(name = "property_required")
    private Boolean requiredProperty;


}
