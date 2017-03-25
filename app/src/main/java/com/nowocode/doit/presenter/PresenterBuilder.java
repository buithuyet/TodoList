package com.nowocode.doit.presenter;

import com.nowocode.doit.view.BaseView;
import com.nowocode.doit.view.main.MainView;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public class PresenterBuilder {
    private BasePresenter presenter;
    private static PresenterBuilder instance;

    private PresenterBuilder(){};

    public static PresenterBuilder createWith(BaseView view){
        if(instance == null)
            instance = new PresenterBuilder();
        if(view instanceof MainView)
            instance.presenter = new MainPresenterImpl((MainView) view);
        return instance;
    }

    public BasePresenter build(){
        return presenter;
    }
}
