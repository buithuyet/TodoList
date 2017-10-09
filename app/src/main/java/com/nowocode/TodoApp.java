package com.nowocode;

import android.app.Application;

import com.nowocode.doit.model.factory.TaskFactory;
import com.nowocode.doit.model.factory.UserFactory;
import com.nowocode.doit.model.provider.PreferenceProvider;
import com.nowocode.doit.model.repository.database.AppDatabase;
import com.nowocode.doit.model.repository.database.DatabaseProvider;
import com.nowocode.doit.model.repository.database.user.User;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Nowocode
 *         17.09.2017.
 */

public class TodoApp extends Application {
    private DatabaseProvider dbProvider;
    private PreferenceProvider preferenceProvider;
    private AppDatabase db;
    private User currentUser;

    @Override
    public void onCreate() {
        super.onCreate();
        dbProvider = new DatabaseProvider(this);
        preferenceProvider = new PreferenceProvider(this);
        db = dbProvider.getDatabase();
        //Default user erstellen und als aktiv persistieren wenn DB leer ist
        Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                e.onNext(db.userDao().getAll().isEmpty());
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if(aBoolean) {
                            db.userDao().insert(createDefaultUser());
                            preferenceProvider.setCurrentUser("default");
                            TaskFactory.initForUser(currentUser);
                        }
                        else
                        {
                            initCurrentUser();
                            TaskFactory.initForUser(currentUser);
                        }
                    }
                });
    }

    private User createDefaultUser() {
        return UserFactory.create("default");
    }

    private void initCurrentUser() {
        String currentActiveUserId = preferenceProvider.getCurrentUser();
        currentUser = db.userDao().getById(currentActiveUserId);
    }


}
