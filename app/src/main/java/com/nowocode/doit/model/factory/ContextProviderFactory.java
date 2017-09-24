package com.nowocode.doit.model.factory;

import com.nowocode.doit.model.ContextProvider;
import com.nowocode.doit.view.BaseView;

/**
 * @author Nowocode
 *         24.09.2017.
 */

public class ContextProviderFactory {

    public static ContextProvider build(BaseView view) {
        return new ContextProvider(view.getContext());
    }
}
