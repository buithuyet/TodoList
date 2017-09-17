package com.nowocode.doit.model.provider;

import android.content.Context;
import android.content.SharedPreferences;

import com.nowocode.TodoApp;

/**
 * @author Nowocode
 *         17.09.2017.
 */

public class PreferenceProvider {
    private Context context;
    private static PreferenceProvider instance;
    private SharedPreferences preferences;

    public PreferenceProvider(TodoApp app) {
        this.context = app;
        instance = this;
        this.preferences = context.getSharedPreferences("todo_prefs", Context.MODE_PRIVATE);
    }

    public static PreferenceProvider getInstance() {
        return instance;
    }

    public String getCurrentUser() {
        return preferences.getString("currentUser", "default");
    }

    public void setCurrentUser(String userId) {
        preferences.edit().putString("currentUser", userId).apply();
    }
}
