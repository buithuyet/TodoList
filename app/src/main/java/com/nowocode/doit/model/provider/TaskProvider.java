package com.nowocode.doit.model.provider;

import com.nowocode.doit.model.repository.database.task.Task;

import java.util.Date;

import io.reactivex.Observable;


/**
 * @author Nowocode
 *         17.09.2017.
 */

public interface TaskProvider {
    Observable<Task> getAllTasks();

    Observable<Task> getAllTasksByCategory(String category);

    Observable<Task> getAllTasksByDate(Date date);

    Observable<Task> getAllTasksByType(int type);


    Observable<Boolean> insert(Task t);

    Observable<Boolean> delete(long id);
}
