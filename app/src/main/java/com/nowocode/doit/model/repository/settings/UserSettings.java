package com.nowocode.doit.model.repository.settings;

import io.reactivex.Observable;

/**
 * @author Nowocode
 *         11.09.2017.
 */

public interface UserSettings {
    Observable setAlarm(long time);
}
