package com.loanscompany.lam.imodel.settings.employment;

import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;

/**
 * @author percym
 */
public interface IEmploymentSettings extends ITimeActiveRecordEntity {

    /**
     * Gets whether  an educational qualification is required loans applied for this client.
     *
     * @return requireEducationalQualification is required
     * */

    Boolean getRequireEducationalQualification();
    /**
     * Sets whether an educational qualification is required is required loans applied for this client.
     *
     * @param  requireEducationalQualification is required
     * */

    void setRequireEducationalQualification(Boolean requireEducationalQualification);

    /**
     * Gets whether  a next of kin  home telephone number is required loans applied for this client.
     *
     * @return requireEmployerAddress is required
     * */

    Boolean getRequireOtherMonthlyIncome();
    /**
     * Sets whether a next of kin  home telephone number is required loans applied for this client.
     *
     * @param  requireOtherMonthlyIncome is required
     * */

    void setRequireOtherMonthlyIncome(Boolean requireOtherMonthlyIncome);

    /**
     * Gets whether   an employment status is required is required loans applied for this client.
     *
     * @return requireEmployerAddress is required
     * */

    Boolean getRequireEmploymentStatus();
    /**
     * Sets whether an employment status is required loans applied for this client.
     *
     * @param  requireEmploymentStatus is required
     * */

    void setRequireEmploymentStatus(Boolean requireEmploymentStatus);
    /**
     * Gets whether a  current employer is required loans applied for this client.
     *
     * @return requireEmployerName is required
     * */

    Boolean getRequireCurrentEmployer();
    /**
     * Sets whether a current  employer is required loans applied for this client.
     *
     * @param  requireCurrentEmployer is required
     * */
    void setRequireCurrentEmployer(Boolean requireCurrentEmployer);

    /**
     * Gets whether a  current employer address is required loans applied for this client.
     *
     * @return requireEmployerName is required
     * */

    Boolean getRequireCurrentEmployerAddress();
    /**
     * Sets whether a current  employer address is required loans applied for this client.
     *
     * @param  requireCurrentEmployerAddress is required
     * */
    void setRequireCurrentEmployerAddress(Boolean requireCurrentEmployerAddress);

}
