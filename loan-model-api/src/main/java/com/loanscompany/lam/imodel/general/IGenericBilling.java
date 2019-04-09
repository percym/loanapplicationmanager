package com.loanscompany.lam.imodel.general;

import java.math.BigDecimal;

/**
 * An interface for Generic Naming and Billing
 * @author percym
 */
public interface IGenericBilling extends IActive {
    /**
     * Returns the genericCode for this generic item.
     *
     * @return the genericCode for this generic item.
     */
    String getGenericCode();

    /**
     * Sets the genericCode for this generic item.
     *
     * @param genericCode the genericCode for this generic item.
     */
    void setGenericCode(String genericCode);

    /**
     * Returns the genericName for this item.
     *
     * @return the genericName for this item.
     */
    String getGenericName();

    /**
     * Sets the genericName for this item.
     *
     * @param genericName the genericName for this item.
     */
    void setGenericName(String genericName);



    /**
     * Returns the amount charged the insurance/medical aid.
     *
     * @return the amount charged the insurance/medical aid.
     */
    BigDecimal getInsuranceBillAmount();

    /**
     * Sets the amount charged the insurance/medical aid.
     *
     * @param insuranceBillAmount the amount charged the insurance/medical aid.
     */
    void setInsuranceBillAmount(BigDecimal insuranceBillAmount);

    /**
     * Returns the amount the patient should pay.
     *
     * @return the amount the patient should pay.
     */
    BigDecimal getPatientPayAmount();

    /**
     * Sets the amount the patient should pay.
     *
     * @param patientPayAmount the amount the patient should pay.
     */
    void setPatientPayAmount(BigDecimal patientPayAmount);

    /**
     * Returns the total amount for the bill i.e insuranceBillAmount + patientPayAmount.
     *
     * @return the total amount for the bill i.e insuranceBillAmount + patientPayAmount.
     */
    BigDecimal getTotalItemCost();

    /**
     * Sets the total amount for the bill i.e insuranceBillAmount + patientPayAmount.
     *
     * @param totalItemCost the total amount for the bill i.e insuranceBillAmount + patientPayAmount.
     */
    void setTotalItemCost(BigDecimal totalItemCost);

}
