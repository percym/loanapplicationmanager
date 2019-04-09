package com.loanscompany.lam.utility.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum IndicatorISOLanguage {

    /**
     * Afrikaans
     */
    AFR("afr", "af", "Afrikaans"),

    /**
     * Arabic (Ø§Ù„Ø¹Ø±Ø¨ÙŠØ©)
     */
    ARA("ara", "ar", "Ø§Ù„Ø¹Ø±Ø¨ÙŠØ©"),

    /**
     * English
     */
    ENG("eng", "en", "English"),

    /**
     * French (franÃ§ais)
     */
    FRA("fra", "fr", "French (franÃ§ais)"),

    /**
     * Portuguese (portuguÃªs)
     */
    POR("por", "pt", "Portuguese (portuguÃªs)"),

    /**
     * Southern Sotho (Sesotho)
     */
    SOT("sot", "st", "Southern Sotho (Sesotho)"),

    /**
     * Swati (SiSwati)
     */
    SSW("ssw", "ss", "Swati (SiSwati)"),

    /**
     * Swahili (Kiswahili)
     */
    SWA("swa", "sw", "Swahili (Kiswahili)"),

    /**
     * Tswana (Setswana)
     */
    TSN("tsn", "tn", "Tswana (Setswana)");

    private static final String ERROR_MSG = "Unknown Language code for conversion: ";

    private static final Map<String, IndicatorISOLanguage> CODE3_LOOKUP = new HashMap<>();
    private static final Map<String, IndicatorISOLanguage> CODE1_LOOKUP = new HashMap<>();

    static {
        for (final IndicatorISOLanguage values : IndicatorISOLanguage.values()) {
            CODE3_LOOKUP.put(values.iso3Code, values);
            CODE1_LOOKUP.put(values.iso1Code, values);
        }
    }

    private String iso3Code;
    private String iso1Code;
    private String displayName;

    /**
     * Creates a new instance of {@code IndicatorISOLanguage}.
     *
     * @param iso3Code    The ISO 639-3 code
     * @param iso1Code    The ISO 639-1 code
     * @param displayName The language display name
     */
    private IndicatorISOLanguage(final String iso3Code, final String iso1Code, final String displayName) {

        this.iso3Code = iso3Code;
        this.iso1Code = iso1Code;
        this.displayName = displayName;
    }

    /**
     * Create a new instance by matching the supplied ISO 639-3 code to the known values. A new instance will be
     * returned if a match is found.
     *
     * @param iso3Code The code to match against
     * @return A new instance
     */
    public static IndicatorISOLanguage fromISO3Code(final String iso3Code) {

        if (iso3Code != null) {
            final String lowerCaseCode = iso3Code.toLowerCase();
            if (CODE3_LOOKUP.containsKey(lowerCaseCode)) {
                return CODE3_LOOKUP.get(lowerCaseCode);
            }
            throw new IllegalArgumentException(ERROR_MSG + iso3Code);
        }
        return null;

    }

    /**
     * Create a new instance by matching the supplied ISO 639-1 code to the known values. A new instance will be
     * returned if a match is found.
     *
     * @param iso1Code The code to match against
     * @return A new instance
     */
    public static IndicatorISOLanguage fromISO1Code(final String iso1Code) {

        if (iso1Code != null) {
            final String lowerCaseAbbr = iso1Code.toLowerCase();
            if (CODE1_LOOKUP.containsKey(lowerCaseAbbr)) {
                return CODE1_LOOKUP.get(lowerCaseAbbr);
            }
            throw new IllegalArgumentException(ERROR_MSG + iso1Code);
        }
        return null;

    }

    /**
     * Returns the ISO 639-3 code
     *
     * @return the ISO 639-3 code
     */
    public String getISO3Code() {

        return iso3Code;
    }

    /**
     * Returns the ISO 639-1 code
     *
     * @return the ISO 639-1 code
     */
    public String getISO1Code() {

        return iso1Code;
    }

    /**
     * Returns the language display name
     *
     * @return the language display name
     */
    public String getDisplayName() {

        return displayName;
    }

    /**
     * Returns the locale value for this language
     *
     * @return the locale value for this language
     */
    public Locale getLocale() {

        final Locale locale;
        if (iso1Code != null) {
            locale = new Locale(iso1Code);
        } else {
            locale = new Locale(iso3Code);
        }

        return locale;
    }

    /**
     * A JPA 2.1 type converter to convert the {@link IndicatorISOLanguage} enumeration into the value to be
     * stored in the database and vice versa.
     *
     * @author Munyaradzi Takayindisa
     */
    @Converter(autoApply = true)
    public static class IndicatorISOLanguageConverter
            implements AttributeConverter<IndicatorISOLanguage, String> {

        /**
         * {@inheritDoc}
         *
         * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(Object)
         */
        @Override
        public String convertToDatabaseColumn(final IndicatorISOLanguage attribute) {

            return attribute != null ? attribute.getISO3Code() : null;
        }

        /**
         * {@inheritDoc}
         *
         * @see javax.persistence.AttributeConverter#convertToEntityAttribute(Object)
         */
        @Override
        public IndicatorISOLanguage convertToEntityAttribute(final String dbData) {

            return dbData != null ? IndicatorISOLanguage.fromISO3Code(dbData) : null;
        }

    }
}

