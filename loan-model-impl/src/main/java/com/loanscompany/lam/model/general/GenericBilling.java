package com.loanscompany.lam.model.general;

import com.loanscompany.lam.imodel.general.IGenericBilling;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The GenericBilling mapped superclass
 *
 * @author percym
 */
@MappedSuperclass
@Audited
public abstract class GenericBilling extends Active implements IGenericBilling {

    private static final long serialVersionUID = 6440495638785599959L;


    @Size(max = 10)
    @Column(name = "zz_generic_code", length = 10)
    private String genericCode;

    @Size(max = 250)
    @Column(name = "zz_generic_description",  length = 250)
    private String genericName;

    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("999999999999.00")
    @Column(name = "zz_insurance_bill_amount", columnDefinition = "numeric(12,2) default '0.00'")
    private BigDecimal insuranceBillAmount;

    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("999999999999.00")
    @Column(name = "zz_patient_pay_amount", columnDefinition = "numeric(12,2) default '0.00'")
    private BigDecimal patientPayAmount;

    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("999999999999.00")
    @Column(name = "zz_total_item_cost", columnDefinition = "numeric(12,2) default '0.00'")
    private BigDecimal totalItemCost;

    @Override
    public String getGenericCode() {
        return genericCode;
    }

    @Override
    public void setGenericCode(String genericCode) {
        this.genericCode = genericCode;
    }

    @Override
    public String getGenericName() {
        return genericName;
    }

    @Override
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    @Override
    public BigDecimal getInsuranceBillAmount() {
        return insuranceBillAmount;
    }

    @Override
    public void setInsuranceBillAmount(BigDecimal insuranceBillAmount) {
        this.insuranceBillAmount = insuranceBillAmount;
    }

    @Override
    public BigDecimal getPatientPayAmount() {
        return patientPayAmount;
    }

    @Override
    public void setPatientPayAmount(BigDecimal patientPayAmount) {
        this.patientPayAmount = patientPayAmount;
    }

    @Override
    public BigDecimal getTotalItemCost() {
        return totalItemCost;
    }

    @Override
    public void setTotalItemCost(BigDecimal totalItemCost) {
        this.totalItemCost = totalItemCost;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getGenericCode(), getGenericName(),getInsuranceBillAmount(), getPatientPayAmount(), getTotalItemCost());
    }

    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof IGenericBilling)) {
            return false;
        }
        final IGenericBilling other = (IGenericBilling) obj;
        return Objects.equals(getGenericCode(), other.getGenericCode())
                && Objects.equals(getGenericName(), other.getGenericName())
                &&Objects.equals(getInsuranceBillAmount(), other.getInsuranceBillAmount())
                &&Objects.equals(getTotalItemCost(),other.getTotalItemCost());
    }
}
