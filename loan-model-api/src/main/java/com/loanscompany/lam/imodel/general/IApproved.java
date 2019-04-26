package com.loanscompany.lam.imodel.general;

/**
 * IApproved interface for checking the record state.
 *
 *@author percym
 */
public interface IApproved extends IAuditingEntity, ITimeActiveRecordEntity {

    /**
     * Returns if this record is approved.
     *
     * @return if this record is approved.
     */
    Boolean getApproved();

    /**
     * Sets if this record is approved.
     *
     * @param approved if this record is approved.
     */
    void setApproved(Boolean approved);

}