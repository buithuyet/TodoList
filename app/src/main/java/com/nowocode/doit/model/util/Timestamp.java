package com.nowocode.doit.model.util;

import java.util.Calendar;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public class Timestamp {
    public static long stamp(){
        return Calendar.getInstance().getTimeInMillis();
    }
}
