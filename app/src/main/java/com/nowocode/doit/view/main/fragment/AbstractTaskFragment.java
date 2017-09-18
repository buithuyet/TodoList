package com.nowocode.doit.view.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getResources().getLayout(R.layout.task_fragment), container, false);
        ButterKnife.bind(view);
        tasks = new ArrayList<>();
        return view;
    }

    public void setTaskActivity(TaskActivity t) {
        this.taskActivity = t;
    }

    ;

    @Override
    public void addTaskToDisplay(Task task) {
        tasks.add(task);
        adapter.notifyDataSetChanged();
    }

    private class TaskRvAdapter extends RecyclerView.Adapter<TaskViewHolder> {

        @Override
        public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(getContext()).inflate(R.layout.task_card, parent);
            return new TaskViewHolder(v);
        }

        @Override
        public void onBindViewHolder(TaskViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return tasks.size();
        }
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {

        public TaskViewHolder(View itemView) {
            super(itemView);
        }
    }
}
