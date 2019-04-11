package com.loanscompany.lam.imodel.settings.applicant;

import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;

/**
 * interface for the required fields of an applicant's details
 *
 * @author percym
 */
public interface IApplicantPersonalDetailsSettings extends ITimeActiveRecordEntity {
    /**
     * Gets whether  the number of dependents is required for loans applied for this client.
     *
     * @return requireNumberOfDependants is required
     * */

    Boolean getRequireNumberOfDependants();
    /**
     * Sets whether the number of dependents is required for loans applied for this client.
     *
     * @param  requireNumberOfDependants is required
     * */

    void setRequireNumberOfDependants(Boolean requireNumberOfDependants);

    /**
     * Gets whether  the number of children is required for loans applied for this client.
     *
     * @return requireNumberOfChildren is required
     * */

    Boolean getRequireNumberOfChildren();
    /**
     * Sets whether the number of children is required for loans applied for this client.
     *
     * @param  requireNumberOfChildren is required
     * */

    void setRequireNumberOfChildren(Boolean requireNumberOfChildren);

    /**
     * Gets whether  the country of birth is required for loans applied for this client.
     *
     * @return requireNumberOfChildren is required
     * */

    Boolean getRequireCountryOfBirth();
    /**
     * Sets whether the number of children is required for loans applied for this client.
     *
     * @param  requireCountryOfBirth is required
     * */

    void setRequireCountryOfBirth(Boolean requireCountryOfBirth);

    /**
     * Gets whether  the country of birth is required for loans applied for this client.
     *
     * @return requireNumberOfChildren is required
     * */

    Boolean getRequirePlaceOfBirth();
    /**
     * Sets whether the number of children is required for loans applied for this client.
     *
     * @param  requirePlaceOfBirth is required
     * */

    void setRequirePlaceOfBirth(Boolean requirePlaceOfBirth);

    /**
     * Gets whether  the nationality is required for loans applied for this client.
     *
     * @return requireNumberOfChildren is required
     * */

    Boolean getRequireNationality();
    /**
     * Sets whether nationality is required for loans applied for this client.
     *
     * @param  requireNationality is required
     * */

    void setRequireNationality(Boolean requireNationality);

    /**
     * Gets whether  the citizenship is required for loans applied for this client.
     *
     * @return requireNumberOfChildren is required
     * */

    Boolean getRequireCitizenShip();
    /**
     * Sets whether the citizenship is required for loans applied for this client.
     *
     * @param  requireCitizenShip is required
     * */

    void setRequireCitizenShip(Boolean requireCitizenShip);

    /**
     * Gets whether  the race is required for loans applied for this client.
     *
     * @return requireNumberOfChildren is required
     * */

    Boolean getRequireRace();
    /**
     * Sets whether the race is required for loans applied for this client.
     *
     * @param  requireRace is required
     * */

    void setRequireRace(Boolean requireRace);

    /**
     * Gets whether  the email is required for loans applied for this client.
     *
     * @return requireNumberOfChildren is required
     * */

    Boolean getRequireEmail();
    /**
     * Sets whether the email is required for loans applied for this client.
     *
     * @param  requireEmail is required
     * */

    void setRequireEmail(Boolean requireEmail);


}
