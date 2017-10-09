package com.nowocode.doit.model.provider.impl;

import com.nowocode.doit.model.ContextProvider;
import com.nowocode.doit.model.provider.TaskProvider;
import com.nowocode.doit.model.repository.database.DatabaseProvider;
import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.model.repository.database.task.TaskDao;

import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Nowocode
 *         17.09.2017.
 */

public class TaskProviderImpl implements TaskProvider {
    private ContextProvider contextProvider;
    private TaskDao dao;

    public TaskProviderImpl(ContextProvider provider) {
        this.contextProvider = provider;
        dao = DatabaseProvider.getInstance().getDatabase().taskDao();
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
    public Observable<Task> getAllTasksByType(final int type) {
        return Observable.create(new ObservableOnSubscribe<Task>() {
            @Override
            public void subscribe(ObservableEmitter<Task> e) throws Exception {
                List<Task> tasks = dao.getAllByType(type);
                for (Task t : tasks) {
                    e.onNext(t);
                }
                e.onComplete();
            }
        });
    }


    @Override
    public Observable<Boolean> insert(final Task t) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                dao.insert(t);
                e.onNext(dao.getById(t.getId()) != null);
            }
        });

    }

    @Override
    public Observable<Boolean> delete(long id) {
        Task task = dao.getById(id);
        dao.delete(task);

        return Observable.just(dao.getById(id) == null);
    }
}
