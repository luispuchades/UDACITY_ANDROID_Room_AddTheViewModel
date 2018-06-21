package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

// TODO (1) / COMPLETED make this class extend AndroidViewModel and implement its default
// constructor
public class MainViewModel extends AndroidViewModel{

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    // TODO (2) / COMPLETED: Add a tasks member variable for a list of TaskEntry objects wrapped
    // in a LiveData
    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        // TODO (4) / COMPLETED: In the constructor use the loadAllTasks of the taskDao to
        // initialize the tasks
        // variable
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks froim the DataBase");
        tasks = database.taskDao().loadAllTasks();
    }




    // TODO (3) / COMPLETED: Create a getter for the tasks variable
    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
