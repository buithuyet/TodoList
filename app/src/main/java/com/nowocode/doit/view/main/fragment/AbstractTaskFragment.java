package com.nowocode.doit.view.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nowocode.doit.R;
import com.nowocode.doit.model.repository.database.task.Task;
import com.nowocode.doit.view.main.TaskActivity;
import com.nowocode.doit.view.main.TaskFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Nowocode
 *         18.09.2017.
 */

public abstract class AbstractTaskFragment<T> extends Fragment implements TaskFragment {
    @BindView(R.id.taskRv)
    RecyclerView listRv;
    List<Task> tasks;
    TaskRvAdapter adapter;
    TaskActivity taskActivity;
    protected static final int daily_fragment = 0;
    protected static final int weekly_fragment = 1;
    protected static final int monthly_fragment = 2;
    protected static final int yearly_fragment = 3;
    private static final String TAG = "AbstractTaskFragment";

    private int type = 0;

    public AbstractTaskFragment(int fragment_type, TaskActivity taskActivity) {
        this.type = fragment_type;
        this.taskActivity = taskActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_fragment, container, false);
        ButterKnife.bind(this, view);
        tasks = new ArrayList<>();
        adapter = new TaskRvAdapter();
        listRv.setHasFixedSize(true);
        listRv.setAdapter(adapter);
        listRv.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    public void setTaskActivity(TaskActivity t) {
        this.taskActivity = t;
    }


    @Override
    public void addTaskToDisplay(Task task) {
        tasks.add(task);
        adapter.notifyDataSetChanged();
        Log.d(TAG, "addTaskToDisplay: " + task.toString());
    }

    private class TaskRvAdapter extends RecyclerView.Adapter<TaskViewHolder> {
        @Override
        public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(getContext()).inflate(R.layout.task_card, parent, false);
            return new TaskViewHolder(v);
        }

        @Override
        public void onBindViewHolder(TaskViewHolder holder, int position) {
            holder.name.setText(tasks.get(position).getTitle());
            holder.description.setText(tasks.get(position).getDescription());
            holder.date.setText(tasks.get(position).getCreated().toGMTString());
            Log.d(TAG, "onBindViewHolder: category:" + tasks.get(position).getCategory());
            switch (tasks.get(position).getCategory()) {
                case Task.CATEGORY.EDU:
                    holder.taskCategory.setImageDrawable(getContext().getResources().getDrawable(R.drawable.book_icon));
                    break;
                case Task.CATEGORY.HEALTH:
                    holder.taskCategory.setImageDrawable(getContext().getResources().getDrawable(R.drawable.apple_icon_black));
                    break;
                case Task.CATEGORY.FINANCE:
                    holder.taskCategory.setImageDrawable(getContext().getResources().getDrawable(R.drawable.dollar_icon_black));
                    break;
                case Task.CATEGORY.LOVE:
                    holder.taskCategory.setImageDrawable(getContext().getResources().getDrawable(R.drawable.couple_icon_black));
                    break;
                default:
                    holder.taskCategory.setImageDrawable(getContext().getResources().getDrawable(R.drawable.book_icon));
            }
        }

        @Override
        public int getItemCount() {
            return tasks.size();
        }
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.taskName)
        public TextView name;
        @BindView(R.id.taskDescription)
        public TextView description;
        @BindView(R.id.taskDate)
        public TextView date;
        @BindView(R.id.taskIcon)
        public ImageView taskCategory;

        public TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
