package com.example.projecttpmobile.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttpmobile.R;
import com.example.projecttpmobile.model.tasks;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<tasks> taskList;

    public TaskAdapter(List<tasks> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        tasks task = taskList.get(position);
        holder.taskTitle.setText(task.getTitle());
        holder.taskDescription.setText(task.getDescription());
        holder.taskStatus.setChecked(task.isCompleted());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskTitle;
        TextView taskDescription;
        CheckBox taskStatus;

        ViewHolder(View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.taskTitle);
            taskDescription = itemView.findViewById(R.id.taskDescription);
            taskStatus = itemView.findViewById(R.id.taskStatus);
        }
    }
}
