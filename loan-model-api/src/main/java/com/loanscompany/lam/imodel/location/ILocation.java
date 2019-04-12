package com.loanscompany.lam.imodel.location;

/**
 * Copyright © 2018 NewHealth263 (Pty) Ltd. All rights reserved.
 *
 * @author Percy Mugadza
 *
 */


import com.loanscompany.lam.imodel.address.IAddress;
import com.loanscompany.lam.imodel.address.IContactDetails;
import com.loanscompany.lam.imodel.client.IClient;
import com.loanscompany.lam.imodel.general.IActive;
import com.loanscompany.lam.utility.enums.ClientType;

import java.util.Collection;

/**
 * IClient interface for Location Class
 *
 * @author Percy Mugadza
 */
public interface ILocation extends IActive {

    /**
     * Returns the name for this location.
     *
     * @return the name for this location.
     */
    String getName();

    /**
     * Sets the name for this location.
     *
     * @param name the name for this location.
     */
    void setName(String name);


    /**
     * Returns the {@link ClientType clientType} for this practice.
     *
     * @return the {@link ClientType clientType} for this practice.
     */
    ClientType getLocationType();

    /**
     * Sets the {@link ClientType clientType} for this practice.
     *
     * @param locationType the {@link ClientType clientType} for this practice.
     */
    void setLocationType(ClientType locationType);

    /**
     * Gets the {@link IAddress address} for this client.
     *
     * @returns address the {@link IAddress address} for this client.
     */
    IAddress getAddress();

    /**
     * Sets the {@link IAddress address} for this client.
     *
     * @param address the {@link IAddress address} for this client.
     */
    void setAddress(IAddress address);

    /**
     * Returns the {@link IContactDetails contactDetails} for this client.
     *
     * @return the {@link IContactDetails contactDetails} for this client.
     */
    IContactDetails getContactDetails();

    /**
     * Sets the {@link IContactDetails contactDetails} for this client.
     *
     * @param contactDetails the {@link IContactDetails contactDetails} for this client.
     */
    void setContactDetails(IContactDetails contactDetails);

    /**
     * Returns the {@link IClient <T> client} for this location.
     *
     * @return the {@link IClient <T> client} for this location.
     */

   IClient getClient();

    /**
     * Sets the {@link IClient <T> client} for this location.
     *
     * @param client the  {@link IClient <T> client} for this location.
     */
    void setClient(IClient client);

}
