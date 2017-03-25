package com.nowocode.doit.view.main;

import com.nowocode.doit.presenter.main.MainPresenter;
import com.nowocode.doit.view.BaseView;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public interface MainView extends BaseView<MainPresenter> {
    void drawUi();
    void onTaskRemove();
    void onTaskClicked();
}
