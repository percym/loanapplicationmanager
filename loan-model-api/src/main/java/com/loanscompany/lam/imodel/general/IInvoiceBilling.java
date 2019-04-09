package com.loanscompany.lam.imodel.general;


import java.math.BigDecimal;

/**
 * Interface for invoice billing
 *
 * @author percym
 */
public interface IInvoiceBilling  extends IAuditingEntity , ITimeActiveRecordEntity{
    /**
     * Returns the total amount for the invoice
     *
     * @return the total amount for the invoice
     */
    BigDecimal getTotalItemsCost();

    /**
     * Sets the total amount for the invoice
     *
     * @param totalItemsCost the total amount for the invoice
     */
    void setTotalItemsCost(BigDecimal totalItemsCost);

}
