package com.loanscompany.lam.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.loanscompany.lam.imodel.location.ILocation;
import com.loanscompany.lam.imodel.user.ISystemUser;
import com.loanscompany.lam.model.general.Active;
import com.loanscompany.lam.model.location.Location;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Munyaradzi Takayindisa
 * <p>
 * Implementation for the IUser class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "system_user_enc")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "system_user_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "system_user_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "system_user_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "system_user_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "system_user_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "system_user_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "system_user_updated_on")),
        @AttributeOverride(name = "active", column = @Column(name = "system_user_is_active"))
})
@SequenceGenerator(name = "default_seq", schema = "data", sequenceName = "system_user_enc_serial_seq", allocationSize = 1)
public class SystemUserDTO extends Active implements ISystemUser<Role>{

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Size(max = 80)
    @Column(name = "user_username", length = 50, unique = true, nullable = false, updatable = false)
    private String userName;


    @JsonIgnore
    @Size(max = 1)
    @Column(name = "user_password", length = 1)
    private String password;

    @Column(name = "user_email", unique = true)
    private String email;

    @Size(max = 20)
    @Column(name = "user_phone", length = 20)
    private String phone;

    @Valid
    @JsonDeserialize(as = Location.class)
    @OneToOne(cascade = CascadeType.DETACH ,orphanRemoval = true, targetEntity = Location.class)
    private ILocation location;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();
}
