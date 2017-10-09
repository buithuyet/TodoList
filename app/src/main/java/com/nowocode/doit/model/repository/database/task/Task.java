package com.nowocode.doit.model.repository.database.task;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.nowocode.doit.model.repository.database.user.User;

import java.util.Calendar;
import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * @author Nowocode
 *         17.09.2017.
 */

@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "userId", onDelete = CASCADE))
public class Task {
    public static class CATEGORY
    {
        public static final String EDU = "education";
        public static final String HEALTH = "health";
        public static final String FINANCE = "finance";
        public static final String LOVE = "love";
    }
    @Ignore
    public static final int DAILY = 0;
    @Ignore
    public static final int WEEKLY = 1;
    @Ignore
    public static final int MONTHLY = 2;
    @Ignore
    public static final int YEARLY = 3;

    @PrimaryKey
    private long id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "category")
    private String category;
    @ColumnInfo(name = "isDone")
    private boolean isDone;
    @ColumnInfo(name = "created")
    private Date created;
    @ColumnInfo(name = "userId")
    private String userId;
    @ColumnInfo(name = "type")
    private int type;


    public Task() {
        id = Calendar.getInstance().getTimeInMillis();
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Task : " + title + " , type : " + type + " created on : " + created.toGMTString();
    }
}
