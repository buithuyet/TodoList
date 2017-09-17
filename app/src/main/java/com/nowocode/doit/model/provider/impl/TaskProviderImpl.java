package com.nowocode.doit.model.provider.impl;

import com.nowocode.doit.model.ContextProvider;
import com.nowocode.doit.model.provider.DatabaseProvider;
import com.nowocode.doit.model.provider.TaskProvider;
import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.model.repository.database.task.TaskDao;

import java.util.Date;

import io.reactivex.Observable;

/**
 * @author Nowocode
 *         17.09.2017.
 */

public class TaskProviderImpl implements TaskProvider {
    private ContextProvider contextProvider;
    private TaskDao dao;

    public TaskProviderImpl(ContextProvider provider) {
        this.contextProvider = provider;
        dao = DatabaseProvider.getDatabase().taskDao();
    }

    @Override
    public Observable<Task> getAllTasks() {
        return Observable.fromIterable(dao.getAll());
    }

    @Override
    public Observable<Task> getAllTasksByCategory(String category) {
        return Observable.fromIterable(dao.getAllFromCategory(category));
    }

    @Override
    public Observable<Task> getAllTasksByDate(Date date) {
        return Observable.fromIterable(dao.getAllOrderedByTime());
    }

    @Override
    public Observable<Task> getAllTasksByType(int type) {
        return Observable.fromIterable(dao.getAllByType(type));
    }


    @Override
    public Observable<Boolean> insert(Task t) {
        dao.insert(t);
        return Observable.just(dao.getById(t.getId()) == null);
    }

    @Override
    public Observable<Boolean> delete(long id) {
        Task task = dao.getById(id);
        dao.delete(task);

        return Observable.just(dao.getById(id) == null);
    }
}
