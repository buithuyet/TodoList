package com.nowocode.doit.model.factory;

import com.nowocode.doit.model.repository.database.user.User;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Nowocode
 *         17.09.2017.
 */

public class UserFactory {

    public static User create(String username) {
        User user = new User();
        user.setId(username);
        user.setCreatedOn(getCurrentDate());
        return user;
    }

    private static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
}
