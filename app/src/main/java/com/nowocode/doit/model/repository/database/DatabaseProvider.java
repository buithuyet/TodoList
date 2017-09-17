package com.nowocode.doit.model.repository.database;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.nowocode.TodoApp;

/**
 * @author Nowocode
 *         17.09.2017.
 */

public class DatabaseProvider {
    private AppDatabase database;
    private Context context;
    private boolean isInitialized;
    private static DatabaseProvider instance;

    public DatabaseProvider(TodoApp app) {
        context = app.getApplicationContext();
        database = Room.databaseBuilder(context, AppDatabase.class, "task-database").build();
        instance = this;
    }

    public static DatabaseProvider getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        if (database == null)
            database = Room.databaseBuilder(context, AppDatabase.class, "task-database").build();
        return database;
    }

}
