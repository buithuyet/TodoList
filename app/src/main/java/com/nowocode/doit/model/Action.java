package com.nowocode.doit.model;

/**
 * @author Nowocode
 *         25.03.2017.
 */

public class Action {
    private String what,msg;
    private long when;

    public Action(String what, String msg, long when) {
        this.what = what;
        this.msg = msg;
        this.when = when;
    }

    public String getWhat() {
        return what;
    }

    public String getMsg() {
        return msg;
    }


    public long getWhen() {
        return when;
    }

}
