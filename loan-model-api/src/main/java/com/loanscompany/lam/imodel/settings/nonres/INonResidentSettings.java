package com.loanscompany.lam.imodel.settings.nonres;

import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;

/**
 * The interface for NonResident Settings on loan applications
 *
 * @author percym
 */
public interface INonResidentSettings extends ITimeActiveRecordEntity{

    /**
     * Gets whether  non residents can apply  for this client.
     *
     * @return requireNonResident is required
     * */

    Boolean getRequireNonResident();
    /**
     * Sets whether  non residents can apply  for this client.
     *
     * @param  requireNonResident is required
     * */

    void setRequireNonResident(Boolean requireNonResident);

}
