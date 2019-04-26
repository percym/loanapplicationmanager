package com.loanscompany.lam.imodel.member;


import com.loanscompany.lam.imodel.address.IAddress;
import com.loanscompany.lam.imodel.address.IContactDetails;
import com.loanscompany.lam.imodel.general.IAuditingEntity;
import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;
import com.loanscompany.lam.utility.enums.RelationshipType;

/**
 * INextOfKin interface for defining the details for the next of kin.
 *
 * @author percym
 */
public interface INextOfKin extends IAuditingEntity, ITimeActiveRecordEntity {

    /**
     * Returns the firstName for this loan.
     *
     * @return the firstName for this loan.
     */
    String getFirstName();

    /**
     * Sets the firstName for this loan.
     *
     * @param firstName the firstName for this loan.
     */
    void setFirstName(String firstName);

    /**
     * Returns the surname for this loan.
     *
     * @return the surname for this loan.
     */
    String getSurname();

    /**
     * Sets the surname for this loan.
     *
     * @param surname the surname for this loan.
     */
    void setSurname(String surname);

    /**
     * Returns the {@link IAddress address} for this loan.
     *
     * @return the {@link IAddress address} for this loan.
     */
    IAddress getHomeAddress();

    /**
     * Sets the {@link IAddress address} for this loan.
     *
     * @param address the {@link IAddress address} for this loan.
     */
    void setHomeAddress(IAddress address);

    /**
     * Returns the {@link IContactDetails contactDetails} for this loan.
     *
     * @return the {@link IContactDetails contactDetails} for this loan.
     */
    IContactDetails getContactDetails();

    /**
     * Sets the {@link IContactDetails contactDetails} for this loan.
     *
     * @param contactDetails the {@link IContactDetails contactDetails} for this loan.
     */
    void setContactDetails(IContactDetails contactDetails);

    /**
     * Returns the relationship with this loan.
     *
     * @return the relationship with this loan.
     */
    RelationshipType getRelationship();

    /**
     * Sets the relationship with this loan.
     *
     * @param relationship the relationship with this loan.
     */
    void setRelationship(RelationshipType relationship);

    /**
     * Returns the EmployerName for this loan.
     *
     * @return the EmployerName for this loan.
     */
    String getEmployerName();

    /**
     * Sets the employerName for this loan.
     *
     * @param employerName the firstName for this loan.
     */
    void setEmployerName(String employerName);

    /**
     * Returns the Employer address for this loan.
     *
     * @return the Employer address for this loan.
     */
    IAddress getEmployerAddress();

    /**
     * Returns the Employer address for this loan.
     *
     * @param  employerAddress Employer address for this loan.
     */
    void setEmployerAddress(IAddress employerAddress);

}
