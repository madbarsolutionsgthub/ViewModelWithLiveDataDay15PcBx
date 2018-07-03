package com.example.mobileapp.roompb5;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.List;

public class MainViewModel extends AndroidViewModel{
    private Context context;
    private LiveData<List<Student>>students;
    private StudentDatabase db;
    public MainViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        db = StudentDatabase.getInstance(context);
    }

    public LiveData<List<Student>> getStudents() {
        students = db.getDao().getAllLiveStudents();
        return students;
    }
}
