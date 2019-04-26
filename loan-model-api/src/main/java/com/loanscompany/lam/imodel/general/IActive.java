package com.loanscompany.lam.imodel.general;

/**
 * IActive interface for checking the record state.
 *
 * @author percym
 */
public interface IActive extends IAuditingEntity, ITimeActiveRecordEntity {

    /**
     * Returns if this record is active.
     *
     * @return if this record is active.
     */
    Boolean getActive();

    /**
     * Sets if this record is active.
     *
     * @param active if this record is active.
     */
    void setActive(Boolean active);

}