package com.loanscompany.lam.imodel.settings.property;

import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;

/**
 * Interface for whether property details are needed
 *
 * @author percym
 */
public interface IPropertySettings extends ITimeActiveRecordEntity {

    /**
     * Gets whether  the number of dependents is required for loans applied for this client.
     *
     * @return requireNumberOfDependants is required
     * */

    Boolean getRequiredProperty();
    /**
     * Sets whether the number of dependents is required for loans applied for this client.
     *
     * @param  requiredProperty is required
     * */

    void setRequiredProperty(Boolean requiredProperty);


}
