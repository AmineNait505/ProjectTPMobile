package com.example.projecttpmobile.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttpmobile.R;
import com.example.projecttpmobile.controller.TaskController;
import com.example.projecttpmobile.model.tasks;

public class HomeActivity extends AppCompatActivity {
    private TaskController taskController;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        taskController = new TaskController();
        setupRecyclerView();
        Button addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddTaskDialog();
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
        TaskAdapter taskAdapter = new TaskAdapter(taskController.getTaskList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(taskAdapter);
    }
    private void showAddTaskDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Task");

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.add_task_dialog_layout, null);
        final EditText titleInput = viewInflated.findViewById(R.id.titleInput);
        final EditText descriptionInput = viewInflated.findViewById(R.id.descriptionInput);
        builder.setView(viewInflated);
        builder.setPositiveButton(android.R.string.ok, (dialog, which) -> {
            String title = titleInput.getText().toString();
            String description = descriptionInput.getText().toString();

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please enter both title and description", Toast.LENGTH_SHORT).show();
            } else {
                tasks newTask = new tasks(title, description, false);
                taskController.addTask(newTask);

                if (taskAdapter == null) {
                    taskAdapter = new TaskAdapter(taskController.getTaskList());
                    RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
                    recyclerView.setAdapter(taskAdapter);
                } else {
                    taskAdapter.notifyDataSetChanged();
                }
            }
        });

        builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.cancel());

        builder.show();
    }

}
