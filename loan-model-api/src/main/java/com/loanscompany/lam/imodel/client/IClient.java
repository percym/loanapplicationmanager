package com.loanscompany.lam.imodel.client;

/*
 *
 * @author
 */
import com.loanscompany.lam.imodel.address.IContactDetails;
import com.loanscompany.lam.imodel.general.IActive;
import com.loanscompany.lam.utility.enums.IndicatorISOCountryCode;

/**
 * IClient interface for Client class
 *
 * @author percym
 */
public interface IClient extends IActive {

    /**
     * Returns the name for this client.
     *
     * @return the name for this client.
     */
    String getName();

    /**
     * Sets the name for this client.
     *
     * @param name the name for this client.
     */
    void setName(String name);

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
     * Returns the registration number for this client.
     *
     * @return the the registration number for this client.
     */
    String getRegNumber();

    /**
     * Sets the registration number for this client.
     *
     * @param regNumber the registration number for this client.
     */
    void setRegNumber(String regNumber);
    /**
     * Returns the business practise number for this client.
     *
     * @return the the business practise  number for this client.
     */
    String getBpNumber();

    /**
     * Sets the registration number for this client.
     *
     * @param bpNumber the business practise number for this client.
     */
    void setBpNumber(String bpNumber);

    /**
     * Returns the {@link IndicatorISOCountryCode IndicatorISOCountryCode} for this client.
     *
     * @return the {@link IndicatorISOCountryCode IndicatorISOCountryCode} for this client.
     */
    IndicatorISOCountryCode getCountryCode();

    /**
     * Sets the {@link IndicatorISOCountryCode IndicatorISOCountryCode} for this client.
     *
     * @param countryCode {@link IndicatorISOCountryCode IndicatorISOCountryCode} for this client.
     */
    void setCountryCode(IndicatorISOCountryCode countryCode);

    /**
     * Returns the time zone for this client.
     *
     * @return the time zone for this client.
     */
    String getTimeZone();

    /**
     * Sets the time zone for this client.
     *
     * @param timeZone the time zone for this client.
     */
    void setTimeZone(String timeZone);

    /**
     * Returns the logo for this client.
     *
     * @return the logo for this client.
     */
    ILogo getLogo();

    /**
     * Sets the logo for this client.
     *
     * @param logo  for this client.
     */
    void setLogo(ILogo logo);

}
