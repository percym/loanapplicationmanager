package com.loanscompany.lam.model.loan;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.loanscompany.lam.imodel.client.ILogo;
import com.loanscompany.lam.imodel.loan.ILoan;
import com.loanscompany.lam.imodel.member.IMember;
import com.loanscompany.lam.imodel.member.INextOfKin;
import com.loanscompany.lam.imodel.user.ISystemUser;
import com.loanscompany.lam.model.client.Logo;
import com.loanscompany.lam.model.general.Active;
import com.loanscompany.lam.model.general.Approved;
import com.loanscompany.lam.model.member.Member;
import com.loanscompany.lam.model.member.NextOfKin;
import com.loanscompany.lam.model.user.SystemUserDTO;
import com.loanscompany.lam.utility.enums.GenderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author percym
 * <p>
 * Implementation for the {@link ILoan} interface
 * */
@Entity
@Data
@Audited
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "data", name = "loan")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "loan_serial")),
        @AttributeOverride(name = "startDate", column = @Column(name = "loan_start_date")),
        @AttributeOverride(name = "endDate", column = @Column(name = "loan_end_date")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "loan_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "loan_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "loan_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "loan_updated_on")),
        @AttributeOverride(name = "approved", column = @Column(name = "loan_approved"))
})
public class Loan extends Approved implements ILoan {

    private static final long serialVersionUID = -5803233040844849239L;

    @NotNull
    @Valid
    @JsonDeserialize(as = Member.class)
    @OneToOne(cascade = CascadeType.PERSIST , targetEntity = Member.class)
    private IMember member;

    @Valid
    @JsonDeserialize(as = NextOfKin.class)
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true, targetEntity = NextOfKin.class)
    private INextOfKin nextOfKin;

    @Valid
    @JsonDeserialize(as = NextOfKin.class)
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true, targetEntity = NextOfKin.class)
    private INextOfKin guarantor;

    @Valid
    @JsonDeserialize(as = Logo.class)
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true, targetEntity = Logo.class)
    private ILogo nationalId;

    @Valid
    @JsonDeserialize(as = Logo.class)
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true, targetEntity = Logo.class)
    private ILogo paySlip;

    @Valid
    @JsonDeserialize(as = Logo.class)
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true, targetEntity = Logo.class)
    private ILogo loanApplicationSideOne;

    @Valid
    @JsonDeserialize(as = Logo.class)
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true, targetEntity = Logo.class)
    private ILogo loanApplicationSideTwo;

    @Valid
    @JsonDeserialize(as = Logo.class)
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true, targetEntity = Logo.class)
    private ILogo proofOfResidence;

    @NotNull
    @Column(name = "loan_tenure")
    private Long tenure;

    @DecimalMin("0.00")
    @Column(name = "loan_amount", columnDefinition = "numeric(24,2) default '0.00'")
    BigDecimal loanAmount;

    @DecimalMin("0.00")
    @Column(name = "loan_installment", columnDefinition = "numeric(24,2) default '0.00'")
    BigDecimal installment;

    @Column(name = "loan_purpose")
    private String loanPurpose;

    @Column(name = "loan_settings_id")
    private Long loanSettingsId;

    @Valid
    @JsonDeserialize(as = SystemUserDTO.class)
    @OneToOne(cascade = CascadeType.ALL ,orphanRemoval = true, targetEntity = SystemUserDTO.class)
    private ISystemUser systemUser;

}
