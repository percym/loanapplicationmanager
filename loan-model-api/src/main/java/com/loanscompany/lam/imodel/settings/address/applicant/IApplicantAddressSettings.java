package com.loanscompany.lam.imodel.settings.address.applicant;

import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;

/**
 * Interface which controls the required address fields
 *
 * @author percym
 */
public interface IApplicantAddressSettings extends ITimeActiveRecordEntity{

    /**
     * Gets whether a current home address  is required for loans applied for this client.
     *
     * @return requireHomeAddress is required
     * */

    Boolean getRequireCurrentHomeAddress();
    /**
     * Sets whether a current home address is required for loans applied for this client.
     *
     * @param  requireCurrentHomeAddress is required
     * */

    void setRequireCurrentHomeAddress(Boolean requireCurrentHomeAddress);

    /**
     * Gets whether a previous home address  is required for loans applied for this client.
     *
     * @return requireHomeAddress is required
     * */

    Boolean getRequirePreviousHomeAddress();
    /**
     * Sets whether a previous home address is required for loans applied for this client.
     *
     * @param  requirePreviousHomeAddress is required
     * */

    void setRequirePreviousHomeAddress(Boolean requirePreviousHomeAddress);

    /**
     * Gets whether a postal address  is required for loans applied for this client.
     *
     * @return requirePostalAddress is required
     * */

    Boolean getRequirePostalAddress();
    /**
     * Sets whether a postal address is required for loans applied for this client.
     *
     * @param  requirePostalAddress is required
     * */

    void setRequirePostalAddress(Boolean requirePostalAddress);

    /**
     * Gets whether a the period stayed at current  address  is required for loans applied for this client.
     *
     * @return requireTimeAtCurrentAddress is required
     * */

    Boolean getRequireTimeAtCurrentAddress();
    /**
     * Sets whether a period stayed at current address is required for loans applied for this client.
     *
     * @param  requireTimeAtCurrentAddress is required
     * */

    void setRequireTimeAtCurrentAddress(Boolean requireTimeAtCurrentAddress);

    /**
     * Gets whether a the period stayed at current  address  is required for loans applied for this client.
     *
     * @return requireTimeAtPreviousAddress is required
     * */

    Boolean getRequireTimeAtPreviousAddress();
    /**
     * Sets whether a period stayed at current address is required for loans applied for this client.
     *
     * @param  requireTimeAtPreviousAddress is required
     * */

    void setRequireTimeAtPreviousAddress(Boolean requireTimeAtPreviousAddress);


}
