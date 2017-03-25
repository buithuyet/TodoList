package com.nowocode.doit.model.repository.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.nowocode.doit.model.Action;
import com.nowocode.doit.model.Task;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public class DatabaseImpl implements Database {
    SQLiteDatabase database;
    private final String TAG = getClass().getName();
    private Context context;
    private DatabaseContract dbContract;

    protected DatabaseImpl(Context context){
        this.context = context;
        dbContract = new DatabaseContract();
        initDatabase();
        initTables();
    }


    @Override
    public void initDatabase() {
        database = context.openOrCreateDatabase("todo_db",Context.MODE_PRIVATE,null);
    }

    @Override
    public void initTables() {
        String[] tables = dbContract.getTableNames();
        for(String table : tables)
            initTable(table);
    }

    private void initTable(String tableName){
        String[] columns = dbContract.getTableColumns(tableName);
        String query = makeCreateTableQueryString(tableName,columns);
        database.execSQL(query);
        Log.d(TAG,"Executed Query: " + query);
    }

    private String makeCreateTableQueryString(String tableName, String[] columns){
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("create table " + tableName + " if not exists(");

        for(String c : columns){
            queryBuilder.append(c+" varchar,");
        }
        int lastComma = queryBuilder.lastIndexOf(",");
        queryBuilder.replace(lastComma,lastComma,");");

        return queryBuilder.toString();
    }

    @Override
    public void insertTask(Task task) {
        String name = task.getName();
        String descr = task.getDescription();
        String id = task.getId();
        String priority = String.valueOf(task.getPriority());
        String date = String.valueOf(task.getDate());
        String[] args = {name,descr,id,priority,date};
        //this is ugly.. need another aproach!!
        String query = makeInsertIntoQueryString("task",args);
        database.execSQL(query);
    }

    @Override
    public void insertStatistic(Action action) {
        String what = action.getWhat();
        String msg = action.getMsg();
        String who = String.valueOf(action.getWhen());
        String[] args = {what,msg,who};
        //this is ugly.. need another aproach!!
        String query = makeInsertIntoQueryString("statistic",args);
        database.execSQL(query);
    }

    private String makeInsertIntoQueryString(String tableName, String[] args){
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("insert into " + tableName + "(");

        for(String a : args){
            queryBuilder.append("'" + a +"',");
        }
        int lastComma = queryBuilder.lastIndexOf(",");
        queryBuilder.replace(lastComma,lastComma,");");

        return queryBuilder.toString();
    }

    @Override
    public void removeTask(Task task) {

    }

    @Override
    public void updateTask(Task task) {

    }
}
