package com.nowocode.doit.presenter;

import android.content.Context;

import com.nowocode.doit.model.Action;
import com.nowocode.doit.model.factory.TaskFactory;
import com.nowocode.doit.model.factory.UserFactory;
import com.nowocode.doit.model.provider.TaskProvider;
import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.model.util.Timestamp;
import com.nowocode.doit.view.main.MainView;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Nowocode
 *         25.03.2017.
 */

class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private TaskProvider taskProvider;

    MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void loadTasks() {
        taskProvider.getAllTasks().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Task>() {
                    @Override
                    public void accept(Task task) throws Exception {

                    }
                });
    }

    @Override
    public void insertTask(String name, String description, String category, int type) {
        Task t = TaskFactory.create(name, description, category, type);
        taskProvider.insert(t).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {
                    //task successfully created
                    taskProvider.incrementTaskTotalCount();
                }
                //task creation failed
            }
        });
    }

    @Override
    public void deleteTask(long id) {
        taskProvider.delete(id);
        taskProvider.incrementTaskCanceledCount();
    }

    @Override
    public void showCreateTaskDialog() {

    }

    @Override
    public void createUser(String userId) {
        UserFactory.create(userId);
    }

    @Override
    public Context getViewContext() {
        return getViewContext();
    }
}
