package com.nowocode.doit.view.create;

import com.nowocode.doit.presenter.create.CreateTaskPresenter;
import com.nowocode.doit.view.BaseView;

/**
 * @author Nowocode
 *         18.09.2017.
 */

public interface CreateTaskView extends BaseView<CreateTaskPresenter> {
    void nextPage();
    void prevPage();
    void createTask();
}
