package com.nowocode.doit.model.repository;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * @author Nowocode
 *         17.09.2017.
 */

public class TimeConverter {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
