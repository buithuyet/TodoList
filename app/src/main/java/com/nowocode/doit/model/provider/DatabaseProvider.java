package com.nowocode.doit.model.provider;

import com.nowocode.doit.model.repository.database.AppDatabase;

/**
 * @author Nowocode
 *         17.09.2017.
 */

public class DatabaseProvider {
    private static AppDatabase database;

    public DatabaseProvider(AppDatabase database) {
        this.database = database;
    }

    public static AppDatabase getDatabase() {
        return database;
    }
}
