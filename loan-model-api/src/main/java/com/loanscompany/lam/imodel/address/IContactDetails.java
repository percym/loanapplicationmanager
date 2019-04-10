package com.loanscompany.lam.imodel.address;


import com.loanscompany.lam.imodel.general.IAuditingEntity;
import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;

/**
 * The definition for Contact Details.
 *
 * @author percym
 */
public interface IContactDetails extends IAuditingEntity, ITimeActiveRecordEntity {

    /**
     * Returns the work telephone number.
     *
     * @return the work telephone number.
     */
    String getWorkPhone();

    /**
     * Sets the work telephone number.
     *
     * @param workPhone the work telephone number.
     */
    void setWorkPhone(String workPhone);

    /**
     * Returns the home telephone number.
     *
     * @return the home telephone number.
     */
    String getHomePhone();

    /**
     * Sets the home telephone number.
     *
     * @param homePhone the home telephone number.
     */
    void setHomePhone(String homePhone);

    /**
     * Returns the primary mobile telephone number.
     *
     * @return the primary mobile telephone number.
     */
    String getPrimaryMobile();

    /**
     * Sets the primary mobile telephone number.
     *
     * @param primaryMobile the primary mobile telephone number.
     */
    void setPrimaryMobile(String primaryMobile);

    /**
     * Returns the secondary mobile telephone number.
     *
     * @return the secondary mobile telephone number.
     */
    String getSecondaryMobile();

    /**
     * Sets the secondary mobile telephone number.
     *
     * @param secondaryMobile the secondary mobile telephone number.
     */
    void setSecondaryMobile(String secondaryMobile);

    /**
     * Returns the primary email address.
     *
     * @return the primary email address.
     */
    String getEmail();

    /**
     * Sets the primary email address.
     *
     * @param email the primary email address.
     */
    void setEmail(String email);

}
