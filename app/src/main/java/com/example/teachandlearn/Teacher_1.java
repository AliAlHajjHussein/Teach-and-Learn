package com.example.teachandlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Teacher_1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_1);

        RegistersDataSource ds = new RegistersDataSource(this);
        ArrayList<Registers> teachers;
        Context context = null;

        try
        {
            ds.open();
            teachers = ds.getTeacherView();
            ds.close();

            RecyclerView teacherList = (RecyclerView)findViewById(R.id.rvTeachers);
            teacherList.addItemDecoration(new SimpleBlueDivider(this));
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

            Teacher_1Adapter teacher_1Adapter = new Teacher_1Adapter(teachers, context);

            teacherList.setLayoutManager(layoutManager);
            teacherList.setAdapter(teacher_1Adapter);

            new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    teachers.remove(viewHolder.getAdapterPosition());
                    teacher_1Adapter.notifyDataSetChanged();
                    ds.open();
                    ds.removeItem((Integer) viewHolder.itemView.getTag());
                    ds.close();

                }
            }).attachToRecyclerView(teacherList);

        }
        catch (Exception ex)
        {
            Toast.makeText(this,"error retrieving contents",Toast.LENGTH_LONG).show();

        }
    }

}