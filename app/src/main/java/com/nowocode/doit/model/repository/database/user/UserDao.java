package com.nowocode.doit.model.repository.database.user;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * @author Nowocode
 *         17.09.2017.
 */

@Dao
public interface UserDao {
    @Query("Select * from User")
    List<User> getAll();

    @Query("Select * from User where id = :id")
    User getById(String id);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
