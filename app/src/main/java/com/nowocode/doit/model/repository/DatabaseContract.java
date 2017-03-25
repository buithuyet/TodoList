package com.nowocode.doit.model.repository;

import java.util.HashMap;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public class DatabaseContract {
    private String[] tableList = {"task","statistic","calendar"};

    private String[] taskCols = {"name","description","priority","time"};
    private String[] statisticCols = {"what","when","msg"};
    private String[] calendarCols = {"time"};

    private HashMap<String, String[]> tableColumnMap;
    public DatabaseContract(){
        tableColumnMap = new HashMap<>();
        tableColumnMap.put(tableList[0],taskCols);
        tableColumnMap.put(tableList[1],statisticCols);
        tableColumnMap.put(tableList[2],calendarCols);
    }

    public String[] getTableColumns(String tableName){
        return tableColumnMap.get(tableName);
    }

    public String[] getTableNames(){
        return tableList;
    }

}
