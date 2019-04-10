package com.loanscompany.lam.imodel.settings.nextofkin;

import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;

/**
 * The Interface for next of kin settings
 *
 * @author percym
 */
public interface INextOfKinSettings extends ITimeActiveRecordEntity {
    /**
     * Gets whether a employer name is required loans applied for this client.
     *
     * @return requireEmployerName is required
     * */

    Boolean getRequireEmployerName();
    /**
     * Sets whether a  employer name is required loans applied for this client.
     *
     * @param  requireEmployerName is required
     * */

    void setRequireEmployerName(Boolean requireEmployerName);
    /**
     * Gets whether a employer address is required loans applied for this client.
     *
     * @return requireEmployerAddress is required
     * */

    Boolean getRequireEmployerAddress();
    /**
     * Sets whether a  employer address is required loans applied for this client.
     *
     * @param  requireEmployerAddress is required
     * */

    void setRequireEmployerAddress(Boolean requireEmployerAddress);
    /**
     * Gets whether a home address is required loans applied for this client.
     *
     * @return requireEmployerAddress is required
     * */

    Boolean getRequireHomeAddress();
    /**
     * Sets whether a  home address is required loans applied for this client.
     *
     * @param  requireHomeAddress is required
     * */

    void setRequireHomeAddress(Boolean requireHomeAddress);

    /**
     * Gets whether  a next of kin  business telephone number is required loans applied for this client.
     *
     * @return requireEmployerAddress is required
     * */

    Boolean getRequireBusinessTelephoneNumber();
    /**
     * Sets whether a next of kin  business telephone number is required loans applied for this client.
     *
     * @param  requireBusinessTelephoneNumber is required
     * */

    void setRequireBusinessTelephoneNumber(Boolean requireBusinessTelephoneNumber);

    /**
     * Gets whether  a next of kin  home telephone number is required loans applied for this client.
     *
     * @return requireEmployerAddress is required
     * */

    Boolean getRequireHomeTelephoneNumber();
    /**
     * Sets whether a next of kin  home telephone number is required loans applied for this client.
     *
     * @param  requireHomeTelephoneNumber is required
     * */

    void setRequireHomeTelephoneNumber(Boolean requireHomeTelephoneNumber);
}
