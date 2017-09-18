package com.nowocode.doit.model.repository.database.user;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * @author Nowocode
 *         17.09.2017.
 */

@Entity
public class User {
    @PrimaryKey
    @ColumnInfo(name = "userId")
    String id;
    @ColumnInfo(name = "totalTasks")
    int totalTasks;
    @ColumnInfo(name = "finishedTasks")
    int finishedTasks;
    @ColumnInfo(name = "canceledTasks")
    int canceledTasks;
    @ColumnInfo(name = "lastActivity")
    long lastActivity;
    @ColumnInfo(name ="created-on")
    private Date createdOn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }

    public int getFinishedTasks() {
        return finishedTasks;
    }

    public void setFinishedTasks(int finishedTasks) {
        this.finishedTasks = finishedTasks;
    }

    public int getCanceledTasks() {
        return canceledTasks;
    }

    public void setCanceledTasks(int canceledTasks) {
        this.canceledTasks = canceledTasks;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(long lastActivity) {
        this.lastActivity = lastActivity;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
