package com.nowocode.doit.model.repository.database.task;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.nowocode.doit.model.repository.database.task.Task;

import java.util.List;

/**
 * @author Nowocode
 *         17.09.2017.
 */

@Dao
public interface TaskDao {
    @Query("SELECT * from Task")
    List<Task> getAll();

    @Query("SELECT * from Task where id = :id")
    Task getById(long id);

    @Query("SELECT * from Task where category=:category")
    List<Task> getAllFromCategory(String category);

    @Query("SELECT * from Task ORDER BY created")
    List<Task> getAllOrderedByTime();

    @Query("SELECT * from Task where category=:category ORDER BY created")
    List<Task> getAllFromCategoryOrderedByTime(String category);

    @Query("Select * from Task where isDone=1")
    List<Task> getAllDone();

    @Query("Select * from Task where isDone=0")
    List<Task> getAllNotDone();

    @Query("Select * from Task where type=:type")
    List<Task> getAllByType(int type);

    @Delete
    void delete(Task... tasks);

    @Insert
    void insert(Task... tasks);

    @Update
    void update(Task... task);

}
