package com.loanscompany.lam.model.user;

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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author percym
 * <p>
 * Implementation for the IUser class
 */
@Entity
@Data
@Audited
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "system_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_email"}, name = "un_data_system_user")})
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
//@SequenceGenerator(name = "default_seq", schema = "data", sequenceName = "system_user_serial_seq", allocationSize = 1)
public class SystemUser extends Active implements ISystemUser<Role> {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Size(max = 80)
    @Column(name = "user_username", length = 50, unique = true, nullable = false, updatable = false)
    private String userName;


    @Size(max = 150)
    @Column(name = "user_password", length = 150)
    private String password;

    @Column(name = "user_email", unique = true)
    private String email;

    @Size(max = 20)
    @Column(name = "user_phone", length = 20)
    private String phone;

    @Valid
    @JsonDeserialize(as = Location.class)
    @OneToOne(cascade = CascadeType.PERSIST ,orphanRemoval = true, targetEntity = Location.class)
    private ILocation location;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_serial"),
            inverseJoinColumns = @JoinColumn(name = "role_serial"))
    private Set<Role> roles = new HashSet<>();
}
