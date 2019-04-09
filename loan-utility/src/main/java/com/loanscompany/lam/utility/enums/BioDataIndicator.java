package com.loanscompany.lam.utility.enums;

/*
 * Copyright © 2018 NewHealth263 (Pty) Ltd. All rights reserved.
 *
 * @author Munyaradzi Takayindisa
 *
 */

public enum BioDataIndicator {

    /**
     * Right thumb.
     */
    RT,

    /**
     * Right index finger.
     */
    RI,

    /**
     * Right middle finger.
     */
    RM,

    /**
     * Right ring finger.
     */
    RR,

    /**
     * Right little finger.
     */
    RP,

    /**
     * Left thumb.
     */
    LT,

    /**
     * Left index finger.
     */
    LI,

    /**
     * Left middle finger.
     */
    LM,

    /**
     * Left ring finger.
     */
    LR,

    /**
     * Left little finger.
     */
    LP,

    /**
     * Unknown finger.
     */
    UK;

    public String value() {
        return name();
    }

    public static BioDataIndicator fromValue(String v) {
        return valueOf(v);
    }

}
