package com.nowocode.doit.model.repository.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.nowocode.doit.model.repository.TimeConverter;
import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.model.repository.database.task.TaskDao;
import com.nowocode.doit.model.repository.database.user.UserDao;

/**
 * @author Nowocode
 *         17.09.2017.
 */

@Database(entities = Task.class, version = 1)
@TypeConverters(TimeConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();

    public abstract UserDao userDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
