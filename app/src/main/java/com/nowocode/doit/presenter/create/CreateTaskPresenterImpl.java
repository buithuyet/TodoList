package com.nowocode.doit.presenter.create;

import android.content.Context;
import android.util.Log;

import com.nowocode.doit.model.Constants;
import com.nowocode.doit.model.factory.ContextProviderFactory;
import com.nowocode.doit.model.factory.TaskFactory;
import com.nowocode.doit.model.provider.TaskProvider;
import com.nowocode.doit.model.provider.impl.TaskProviderImpl;
import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.view.create.CreateTaskView;

/**
 * @author Nowocode
 *         23.09.2017.
 */

public class CreateTaskPresenterImpl implements CreateTaskPresenter {
    private static final String TAG = "CreateTaskPresenterImpl";
    private CreateTaskView view;
    private String taskTitle, taskDescription, taskCategory;
    private int taskType;
    private TaskProvider taskProvider;

    public CreateTaskPresenterImpl(CreateTaskView view) {
        this.view = view;
        taskProvider = new TaskProviderImpl(ContextProviderFactory.build(view));
    }

    @Override
    public Context getViewContext() {
        return null;
    }

    @Override
    public void createTask() {
        if (taskTitle != null && taskDescription != null && taskCategory != null) {
            Task t = TaskFactory.create(taskTitle, taskDescription, taskCategory, taskType);
            taskProvider.insert(t);

        } else
            view.showToast("Bitte fülle alle Daten aus!");
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public void setCategory(String category) {
        Log.d(TAG, "setCategory: " + category);
        this.taskCategory = category;
    }

    @Override
    public void setType(String type) {
        int taskType;
        switch (type) {

            case Constants.type_daily:
                taskType = Task.DAILY;
                break;
            case Constants.type_weekly:
                taskType = Task.WEEKLY;
                break;
            case Constants.type_monthly:
                taskType = Task.MONTHLY;
                break;
            case Constants.type_yearly:
                taskType = Task.YEARLY;
                break;
            default:
                taskType = Task.DAILY;
                break;
        }
        this.taskType = taskType;
    }
}
