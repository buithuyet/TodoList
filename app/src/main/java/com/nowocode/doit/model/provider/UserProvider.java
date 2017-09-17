package com.nowocode.doit.model.provider;

import com.nowocode.doit.model.repository.database.user.User;

import io.reactivex.Observable;


/**
 * @author Nowocode
 *         17.09.2017.
 */

public interface UserProvider {
    Observable<User> getUserById(String id);

    Observable<Boolean> removeUser(String id);

    Observable<Boolean> incrementTaskTotalCount(long id);

    Observable<Boolean> incrementTaskFinishedCount(long id);

    Observable<Boolean> incrementTaskCanceledCount(long id);

}
