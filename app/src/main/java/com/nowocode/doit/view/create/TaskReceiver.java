package com.nowocode.doit.view.create;

/**
 * @author Nowocode
 *         23.09.2017.
 */

public interface TaskReceiver {
    public static final int CATEGORY = 1;
    public static final int DESCRIPTION = 2;
    public static final int TITLE = 3;
    public static final int TYPE = 4;

    void setData(int type, String content);
}
