package com.nowocode.doit.presenter;

import android.content.Context;

import com.nowocode.doit.model.ContextProvider;
import com.nowocode.doit.model.factory.TaskFactory;
import com.nowocode.doit.model.factory.UserFactory;
import com.nowocode.doit.model.provider.TaskProvider;
import com.nowocode.doit.model.provider.UserProvider;
import com.nowocode.doit.model.provider.impl.TaskProviderImpl;
import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.model.repository.database.user.User;
import com.nowocode.doit.view.main.MainView;

import io.reactivex.Observable;
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
    private UserProvider userProvider;

    MainPresenterImpl(MainView view) {
        this.view = view;
        taskProvider = new TaskProviderImpl(new ContextProvider(getViewContext()));
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
    public Observable<Task> getDailyTasks() {
        return taskProvider.getAllTasksByType(Task.DAILY).subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Task> getWeeklyTasks() {
        return taskProvider.getAllTasksByType(Task.WEEKLY);
    }

    @Override
    public Observable<Task> getYearlyTasks() {
        return taskProvider.getAllTasksByType(Task.YEARLY);
    }

    @Override
    public void insertTask(String name, String description, String category, int type) {
        Task t = TaskFactory.create(name, description, category, type);
        taskProvider.insert(t).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {
                    //task successfully created

                }
                //task creation failed
            }
        });
    }

    @Override
    public void deleteTask(long id) {
        taskProvider.delete(id);
    }

    @Override
    public void showCreateTaskDialog() {

    }

    @Override
    public void createUser(String userId) {
        User user = UserFactory.create(userId);
        userProvider.createUser(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        //update UI
                    }
                });
    }

    @Override
    public Context getViewContext() {
        return view.getContext();
    }
}
