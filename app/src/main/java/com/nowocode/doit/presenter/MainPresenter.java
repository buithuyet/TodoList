package com.nowocode.doit.presenter;


import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.view.main.MainView;

import io.reactivex.Observable;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public interface MainPresenter extends BasePresenter<MainView> {
    void loadTasks();

    Observable<Task> getDailyTasks();

    Observable<Task> getWeeklyTasks();

    Observable<Task> getYearlyTasks();

    void insertTask(String name, String description, String category, int type);

    void deleteTask(long id);

    void showCreateTaskDialog();

    void createUser(String userId);
}
