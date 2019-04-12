package com.loanscompany.lam.model.user;

import com.loanscompany.lam.imodel.user.IRole;
import com.loanscompany.lam.model.general.TimeActiveRecord;
import com.loanscompany.lam.utility.enums.RoleName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;
import javax.persistence.*;

@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "role", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"role_name"}, name = "un_data_role_name")})
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "role_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "role_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "role_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "role_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "role_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "role_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "role_updated_on")),
})
public class Role extends TimeActiveRecord implements IRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name ="role_name",length = 60)
    private RoleName roleName;


}