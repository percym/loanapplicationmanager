package com.loanscompany.lam.model.member;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.loanscompany.lam.imodel.client.ILogo;
import com.loanscompany.lam.imodel.location.ILocation;
import com.loanscompany.lam.imodel.member.IMember;
import com.loanscompany.lam.imodel.user.ISystemUser;
import com.loanscompany.lam.model.client.Logo;
import com.loanscompany.lam.model.general.Active;
import com.loanscompany.lam.model.location.Location;
import com.loanscompany.lam.model.user.Role;
import com.loanscompany.lam.model.user.SystemUserDTO;
import com.loanscompany.lam.utility.enums.GenderStatus;
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
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author percym
 * <p>
 * Implementation for the {@link IMember} class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "member")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "member_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "member_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "member_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "member_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "member_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "member_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "member_updated_on")),
        @AttributeOverride(name = "active", column = @Column(name = "member_is_active"))
})
public class Member extends Active implements IMember {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Size(max = 50)
    @Column(name = "member_title", length = 50)
    private String title;

    @NotNull
    @Size(max = 50)
    @Column(name = "member_first_name", length = 50)
    private String firstName;

    @Size(max = 5)
    @Column(name = "member_initial", length =5)
    private String initials;


    @NotNull
    @Column(name = "member_surname", length = 20)
    private String surname;

    @Size(min = 11, max = 20)
    @Column(name = "member_id_number", length = 20, nullable =true)
    private String idNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "member_gender", length = 15, updatable = false, nullable = false)
    private GenderStatus genderStatus;


    @NotNull
    @Column(name = "member_dob")
    private LocalDate dateOfBirth;

    @Valid
    @JsonDeserialize(as = SystemUserDTO.class)
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true, targetEntity = SystemUserDTO.class)
    private ISystemUser systemUser;


    @Valid
    @JsonDeserialize(as = Logo.class)
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL, targetEntity = Logo.class)
    ILogo mugShot;

}
