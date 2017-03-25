package com.nowocode.doit.model.repository.database;

import android.content.Context;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public class DatabaseBuilder {
    private static Database dbInstance;

    public DatabaseBuilder createDatabase(Context context){
        dbInstance =  new DatabaseImpl(context);
        return this;
    }

    public Database build(){
        return dbInstance;
    }
}
