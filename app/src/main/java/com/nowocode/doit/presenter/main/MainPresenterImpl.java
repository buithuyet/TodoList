package com.nowocode.doit.presenter.main;

import android.content.Context;

import com.nowocode.doit.model.Action;
import com.nowocode.doit.model.Task;
import com.nowocode.doit.model.repository.database.Database;
import com.nowocode.doit.model.repository.database.DatabaseBuilder;
import com.nowocode.doit.model.util.Timestamp;
import com.nowocode.doit.view.main.MainView;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private Database database;

    public MainPresenterImpl(MainView view){
        this.view = view;
        DatabaseBuilder builder = new DatabaseBuilder();
        database = builder.createDatabase(getViewContext()).build();
    }

    @Override
    public void loadTasks() {

    }

    @Override
    public void insertTask(String name, String description, int priority) {
        Task task = new Task(name,description,priority, Timestamp.stamp());
        database.insertTask(task);
    }

    @Override
    public void insertAction(String what, String msg) {
        Action action = new Action(what,msg,Timestamp.stamp());
        database.insertStatistic(action);
    }

    @Override
    public void showCreateTaskDialog() {

    }

    @Override
    public Context getViewContext() {
        return getViewContext();
    }
}
