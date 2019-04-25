package com.loanscompany.lam.imodel.member;

import com.loanscompany.lam.imodel.client.ILogo;
import com.loanscompany.lam.imodel.user.ISystemUser;
import com.loanscompany.lam.utility.enums.GenderStatus;

import java.time.LocalDate;

/**Interface which defines the membership
 *
 * @author percym
 */
public interface IMember {


    /**
     * Returns the title for this member.
     *
     * @return the title for this member.
     */
    String getTitle();

    /**
     * Sets the title for this member.
     *
     * @param title the title for this member.
     */
    void setTitle(String title);

    /**
     * Returns the initials for this member.
     *
     * @return the initials for this member.
     */
    String getInitials();

    /**
     * Sets the initials for this member.
     *
     * @param initials the initials for this member.
     */
    void setInitials(String initials);

    /**
     * Returns the firstName for this member.
     *
     * @return the firstName for this member.
     */
    String getFirstName();

    /**
     * Sets the firstName for this member.
     *
     * @param firstName the firstName for this member.
     */
    void setFirstName(String firstName);

    /**
     * Returns the surname for this member.
     *
     * @return the surname for this member.
     */
    String getSurname();

    /**
     * Sets the surname for this member.
     *
     * @param surname the surname for this member.
     */
    void setSurname(String surname);

    /**
     * Returns the idNumber for this member.
     *
     * @return the idNumber for this member.
     */
    String getIdNumber();

    /**
     * Sets the idNumber for this member.
     *
     * @param idNumber the idNumber for this member.
     */
    void setIdNumber(String idNumber);

    /**
     * Returns the {@link GenderStatus genderStatus} for this member.
     *
     * @return the {@link GenderStatus genderStatus} for this member.
     */
    GenderStatus getGenderStatus();

    /**
     * Sets the {@link GenderStatus genderStatus} for this member.
     *
     * @param genderStatus the {@link GenderStatus genderStatus} for this member.
     */
    void setGenderStatus(GenderStatus genderStatus);

    /**
     * Returns the date of birth for this member.
     *
     * @return the date of birth for this member.
     */
    LocalDate getDateOfBirth();

    /**
     * Sets the date of birth for this member.
     *
     * @param dateOfBirth the date of birth for this patient.
     */
    void setDateOfBirth(LocalDate dateOfBirth);

    /**
     * Returns the mugShot for this member.
     *
     * @return the mugShot for this member.
     */
    ILogo getMugShot();

    /**
     * Sets the mugShot for this member.
     *
     * @param mugShot  for this member.
     */
    void setMugShot(ILogo mugShot);

    /**
     * Gets the {@link ISystemUser user} of the member.
     *
     * @return { {@link ISystemUser user} of the member.
     */
    ISystemUser getSystemUser();

    /**
     * Sets the {@link ISystemUser user} of the member.
     *
     * @param user of  the area user was created member.
     */
    void setSystemUser(ISystemUser user);
}
