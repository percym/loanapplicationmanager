package com.loanscompany.lam.model.location;

/**
 * @author Percy Mugadza
 *
 */

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.loanscompany.lam.imodel.address.IAddress;
import com.loanscompany.lam.imodel.address.IContactDetails;
import com.loanscompany.lam.imodel.client.IClient;
import com.loanscompany.lam.imodel.location.ILocation;
import com.loanscompany.lam.model.address.Address;
import com.loanscompany.lam.model.address.ContactDetails;
import com.loanscompany.lam.model.client.Client;
import com.loanscompany.lam.model.general.Active;
import com.loanscompany.lam.utility.enums.ClientType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "location")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "location_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "location_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "location_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "location_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "location_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "location_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "location_updated_on")),
        @AttributeOverride(name = "active", column = @Column(name = "location_is_active"))
})
public class Location extends Active implements ILocation {

    private static final long serialVersionUID = -5749829234349753159L;

    @NotNull
    @Size(max = 50)
    @Column(name = "location_name", length = 50)
    private String name;

    @Valid
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "client_type", length = 15)
    private ClientType locationType;

    @Valid
    @JsonDeserialize(as = Address.class)
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Address.class, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private IAddress address;

    @Valid
    @JsonDeserialize(as = ContactDetails.class)
    @OneToOne(fetch = FetchType.EAGER, targetEntity = ContactDetails.class,  cascade = {CascadeType.ALL}, orphanRemoval = true)
    private IContactDetails contactDetails;

    @Valid
    @NotNull
    @JsonDeserialize(as = Client.class)
    @OneToOne(targetEntity = Client.class,  cascade = {CascadeType.DETACH}, orphanRemoval = true)
    private IClient client;

}
