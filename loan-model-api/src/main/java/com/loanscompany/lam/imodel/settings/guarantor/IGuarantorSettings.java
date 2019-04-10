package com.loanscompany.lam.imodel.settings.guarantor;

import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;

/**
 * The interface for guarantor settings
 *
 * @author percym
 */
public interface IGuarantorSettings extends ITimeActiveRecordEntity {

    /**
     * Gets whether a guarantor occupation  is required for loans applied for this client.
     *
     * @return requireOccupation is required
     */

    Boolean getRequireOccupation();

    /**
     * Sets whether a guarantor occupation  is required for loans applied for this client.
     *
     * @param requireOccupation is required
     */

    void setRequireOccupation(Boolean requireOccupation);

    /**
     * Gets whether a employer name is required loans applied for this client.
     *
     * @return requireEmployerName is required
     * */

    Boolean getRequireEmployerName();

    /**
     * Sets whether a  employer name is required loans applied for this client.
     *
     * @param requireEmployerName is required
     */

    void setRequireEmployerName(Boolean requireEmployerName);
    /**
     * Gets whether a employer address is required loans applied for this client.
     *
     * @return requireEmployerAddress is required
     * */
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


    /**
     * Gets whether  bank details is required loans applied for this client.
     *
     * @return requireEmployerAddress is required
     * */

    Boolean getRequireBankDetails();
    /**
     * Sets whether a  bank details is required loans applied for this client.
     *
     * @param  requireBankDetails is required
     * */

    void setRequireBankDetails(Boolean requireBankDetails);
}
