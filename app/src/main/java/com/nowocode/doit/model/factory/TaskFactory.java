package com.nowocode.doit.model.factory;

import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.model.repository.database.user.User;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Nowocode
 *         17.09.2017.
 */

public class TaskFactory {
    private static User user;

    public static void initForUser(User usr) {
        user = usr;
    }

    public static Task create(String title, String description, String category, int type) {
        Task t = new Task();
        t.setTitle(title);
        t.setCategory(category);
        t.setCreated(getCurrentDate());
        t.setUser(user.getId());
        t.setDescription(description);
        t.setType(type);
        return t;
    }

    private static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
}
