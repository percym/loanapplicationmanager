package com.loanscompany.lam.imodel.settings;

import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;

/**
 * Interface for Settings to be uses across a client
 *
 * @author percym
 */
public interface ISettings extends ITimeActiveRecordEntity {

    /**
     * Gets whether a national id is required for loans applied for this client.
     *
     * @return requireNationalId is required
     * */

    Boolean getRequireNationalId();
    /**
     * Sets whether a national id is required for loans applied for this client.
     *
     * @param  requireNationalId is required
     * */

    void setRequireNationalId(Boolean requireNationalId);
    /**
     * Gets whether a mugshot is required  for loans applied for this client.
     *
     * @return requireMugShot is required
     * */

    Boolean getRequirePaySlip();
    /**
     * Sets whether a payslip is required  for this loans applied for this client.
     *
     * @param  requirePaySlip is required
     * */

    void setRequirePaySlip(Boolean requirePaySlip);

    /**
     * Gets whether a proof of residence is required  for loans applied for this client.
     *
     * @return requireProofOfResidence is required
     * */

    Boolean getRequireProofOfResidence();
    /**
     * Sets whether a proof of residence is required for loans applied for this client.
     *
     * @param  requireProofOfResidence is required
     * */

    void setRequireProofOfResidence(Boolean requireProofOfResidence);

    /**
     * Gets whether a loan application form is required for loans applied for this client.
     *
     * @return requireProofOfResidence is required
     * */

    Boolean getRequireLoanApplication();
    /**
     * Sets whether a loan application form is required for loans applied for this client.
     *
     * @param  requireLoanApplication is required
     * */

    void setRequireLoanApplication(Boolean requireLoanApplication);

    /**
     * Gets whether a loan form side one is required for loans applied for this client.
     *
     * @return requireProofOfResidence is required
     * */

    Boolean getRequireLoanFormSideOne();
    /**
     * Sets whether  loan form side one is required for loans applied for this client.
     *
     * @param  requireLoanFormSideOne is required
     * */

    void setRequireLoanFormSideOne(Boolean requireLoanFormSideOne);

    /**
     * Gets whether a loan form side two is required for loans applied for this client.
     *
     * @return requireProofOfResidence is required
     * */

    Boolean getRequireLoanFormSideTwo();
    /**
     * Sets whether  loan form side two is required for loans applied for this client.
     *
     * @param  requireLoanFormSideTwo is required
     * */

    void setRequireLoanFormSideTwo(Boolean requireLoanFormSideTwo);

    /**
     * Gets whether a mugshot is required  for loans applied for this client.
     *
     * @return requireMugShot is required
     * */

    Boolean getRequireMugShot();
    /**
     * Sets whether a mugshot is required for loans applied for this client.
     *
     * @param  requireMugShot is required
     * */

    void setRequireMugShot(Boolean requireMugShot);

}
