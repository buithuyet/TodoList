package com.nowocode.doit.presenter.create;

import com.nowocode.doit.presenter.BasePresenter;
import com.nowocode.doit.view.create.CreateTaskView;

/**
 * @author Nowocode
 *         18.09.2017.
 */

public interface CreateTaskPresenter extends BasePresenter<CreateTaskView> {
    void createTask();

    void setTitle(String title);

    void setDescription(String description);

    void setCategory(String category);

    void setType(String type);
}
