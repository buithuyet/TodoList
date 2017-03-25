package com.nowocode.doit.model.repository;

import com.nowocode.doit.model.Action;
import com.nowocode.doit.model.Task;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public interface IDatabase {
    void initDatabase();
    void initTables();
    void insertTask(Task task);
    void insertStatistic(Action action);
    void removeTask(Task task);
    void updateTask(Task task);
}
