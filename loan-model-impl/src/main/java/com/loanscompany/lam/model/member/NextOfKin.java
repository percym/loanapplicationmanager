package com.loanscompany.lam.model.member;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.loanscompany.lam.imodel.address.IAddress;
import com.loanscompany.lam.imodel.address.IContactDetails;
import com.loanscompany.lam.imodel.member.INextOfKin;
import com.loanscompany.lam.model.address.Address;
import com.loanscompany.lam.model.address.ContactDetails;
import com.loanscompany.lam.model.general.TimeActiveRecord;
import com.loanscompany.lam.utility.enums.RelationshipType;
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
 * @author Munyaradzi Takayindisa
 * <p>
 * Implementation for the INextOfKin class
 */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "static", name = "next_of_kin")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "nok_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "nok_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "nok_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "nok_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "nok_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "nok_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "nok_updated_on"))
})
@SequenceGenerator(name = "default_seq", schema = "static", sequenceName = "nok_serial_seq", allocationSize = 1)
public class NextOfKin extends TimeActiveRecord implements INextOfKin {

    private static final long serialVersionUID = -2141587471835765479L;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "nok_first_name", length = 50, nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "nok_surname", length = 50, nullable = false)
    private String surname;

    @Valid
    @JsonDeserialize(as = Address.class)
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Address.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "nok_add_serial", nullable = false, referencedColumnName = "add_serial",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_data_nok_add"))
    private IAddress homeAddress;

    @Valid
    @JsonDeserialize(as = ContactDetails.class)
    @OneToOne(fetch = FetchType.EAGER, targetEntity = ContactDetails.class , cascade = {CascadeType.ALL})
    @JoinColumn(name = "nok_contact_serial", nullable = false, referencedColumnName = "contact_serial",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_data_nok_contact"))
    private IContactDetails contactDetails;

    @Enumerated(EnumType.STRING)
    @Column(name = "nok_rel_type", length = 15)
    private RelationshipType relationship;

    @Column(name = "nok_employer_name")
    private String employerName;

    @Valid
    @JsonDeserialize(as = Address.class)
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Address.class, cascade = {CascadeType.ALL})
    private IAddress employerAddress;
}