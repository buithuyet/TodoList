package com.nowocode.doit.view.create.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.nowocode.doit.R;
import com.nowocode.doit.view.create.TaskReceiver;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Nowocode
 *         24.09.2017.
 */

@SuppressLint("ValidFragment")
public class ChooseContentFragment extends AbstractCreateTaskFragment {
    @BindView(R.id.taskTitle)
    TextView taskTitle;

    @BindView(R.id.taskTitleEditText)
    TextInputEditText taskInput;

    @BindView(R.id.note)
    TextView note;

    @BindView(R.id.taskNoteEditText)
    TextInputEditText noteInput;

    @BindView(R.id.confirmButton)
    AppCompatButton confirmButton;

    @OnClick(R.id.taskTitle)
    void onTaskTitleClick() {
        taskTitle.setVisibility(View.GONE);
        taskInput.setVisibility(View.VISIBLE);
        changeConfirmButton(true);
    }

    @OnClick(R.id.note)
    void onNoteClick() {
        note.setVisibility(View.GONE);
        noteInput.setVisibility(View.VISIBLE);
        changeConfirmButton(true);
    }

    public ChooseContentFragment(TaskReceiver receiver) {
        super(receiver, CONTENT);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    void changeConfirmButton(boolean isEditingMode) {
        if (isEditingMode) {
            confirmButton.setText("Änderungen speichern");
            confirmButton.setBackgroundColor(getResources().getColor(R.color.red));
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    confirmChanges();
                }
            });
        } else {
            confirmButton.setText("Erstellen");
            confirmButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveTask();
                }
            });
        }
    }

    void confirmChanges() {
        if (taskInput.getText() != null && !taskInput.getText().toString().trim().equals(""))
            taskTitle.setText(taskInput.getText().toString());
        if (noteInput.getText() != null && !noteInput.getText().toString().trim().equals(""))
            note.setText(noteInput.getText().toString());
        taskInput.setVisibility(View.GONE);
        taskTitle.setVisibility(View.VISIBLE);
        note.setVisibility(View.VISIBLE);
        noteInput.setVisibility(View.GONE);
        setContent(TaskReceiver.TITLE, taskTitle.getText().toString());
        setContent(TaskReceiver.DESCRIPTION, note.getText().toString());
        changeConfirmButton(false);
    }

    void saveTask() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Task erstellen");
        builder.setMessage("Möchtest du den Task " + taskTitle.getText().toString() + " erstellen?")
                .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        createTask();
                    }
                }).show();
    }
}
