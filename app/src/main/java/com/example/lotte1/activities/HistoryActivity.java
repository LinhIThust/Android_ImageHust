package com.example.lotte1.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lotte1.R;
import com.example.lotte1.adapters.StudentAdapter;
import com.example.lotte1.database.RealmHandle;
import com.example.lotte1.model.StudentModel;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView rvStudent;
    List<StudentModel> studentModels;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        rvStudent = findViewById(R.id.rv_student);
        rvStudent.setItemAnimator(new DefaultItemAnimator());
        studentModels = RealmHandle.getInstance().getAll();
        studentAdapter = new StudentAdapter(studentModels);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvStudent.setLayoutManager(gridLayoutManager);
       // rvStudent.setLayoutManager(linearLayoutManager);
        rvStudent.setAdapter(studentAdapter);
    }
}
