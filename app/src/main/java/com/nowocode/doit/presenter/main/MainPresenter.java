package com.nowocode.doit.presenter.main;

import com.nowocode.doit.presenter.BasePresenter;
import com.nowocode.doit.view.main.MainView;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public interface MainPresenter extends BasePresenter<MainView> {
    void loadTasks();
    void insertTask(String name, String description, int priority);
    void insertAction(String what, String msg);
    void showCreateTaskDialog();
}
