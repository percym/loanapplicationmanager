package com.loanscompany.lam.model.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.loanscompany.lam.imodel.address.IContactDetails;
import com.loanscompany.lam.imodel.client.IClient;
import com.loanscompany.lam.imodel.client.ILogo;
import com.loanscompany.lam.model.address.ContactDetails;
import com.loanscompany.lam.model.general.Active;
import com.loanscompany.lam.utility.enums.IndicatorISOCountryCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author percym
 * <p>
 * Implementation for the {@link com.loanscompany.lam.imodel.client.IClient }Iclient class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "client", uniqueConstraints = {
        @UniqueConstraint(columnNames = "client_reg_number", name = "un_data_client_reg_number")})
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "client_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "client_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "client_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "client_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "client_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "client_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "client_updated_on")),
        @AttributeOverride(name = "active", column = @Column(name = "client_is_active"))
})
public class Client extends Active implements IClient {

    private static final long serialVersionUID = 2503680799383460164L;

    @NotNull
    @Size(max = 50)
    @Column(name = "client_name", length = 20)
    private String name;

    @NotNull
    @Size(max = 20)
    @Column(name = "client_reg_number", length = 20)
    private String regNumber;

    @Size(max = 20)
    @Column(name = "client_bp_number", length = 20)
    private String bpNumber;


    @Valid
    @JsonDeserialize(as = ContactDetails.class)
    @OneToOne(fetch = FetchType.EAGER, targetEntity = ContactDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_contact_serial", referencedColumnName = "contact_serial",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_data_client_contact"))
    private IContactDetails contactDetails;

    @NotNull
    @Column(name = "client_country_code", length = 2, nullable = false)
    private IndicatorISOCountryCode countryCode;

    @JsonIgnore
    @NotNull
    @Size(max = 20)
    @Column(name = "client_time_zone", length = 20)
    private String timeZone;

    @Valid
    @JsonDeserialize(as = Logo.class)
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL, targetEntity = Logo.class)
    ILogo logo;

    public void setCountryCode(IndicatorISOCountryCode countryCode) {
        this.countryCode = countryCode;
        this.timeZone = countryCode.getTimezone();
    }
}
