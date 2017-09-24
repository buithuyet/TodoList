package com.nowocode.doit.presenter;

import com.nowocode.doit.presenter.create.CreateTaskPresenter;
import com.nowocode.doit.presenter.create.CreateTaskPresenterImpl;
import com.nowocode.doit.view.BaseView;
import com.nowocode.doit.view.create.CreateTaskView;
import com.nowocode.doit.view.main.MainView;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public class PresenterBuilder {
    private BasePresenter presenter;
    private static PresenterBuilder instance;
    private MainPresenter mainPresenter;
    private CreateTaskPresenter createTaskPresenter;

    private PresenterBuilder() {
    }


    public static PresenterBuilder createWith(BaseView view) {
        if (instance == null)
            instance = new PresenterBuilder();
        if (view instanceof MainView) {
            if (instance.mainPresenter == null)
                instance.mainPresenter = new MainPresenterImpl((MainView) view);
            instance.presenter = instance.mainPresenter;
        }
        if (view instanceof CreateTaskView) {
            if (instance.createTaskPresenter == null)
                instance.createTaskPresenter = new CreateTaskPresenterImpl((CreateTaskView) view);
            instance.presenter = instance.createTaskPresenter;
        }
        return instance;
    }

    public BasePresenter build() {
        return presenter;
    }
}
