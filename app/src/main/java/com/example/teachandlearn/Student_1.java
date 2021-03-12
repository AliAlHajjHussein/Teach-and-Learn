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

public class Student_1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_1);

        RegistersDataSource ds = new RegistersDataSource(this);
        ArrayList<Registers> students;
        Context context = null;

        try
        {
            ds.open();
            students = ds.getStudentView();
            ds.close();

            RecyclerView StudentList = (RecyclerView)findViewById(R.id.rvStudents);
            StudentList.addItemDecoration(new SimpleBlueDivider(this));
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

            Student_1Adaptor student_1Adaptor = new Student_1Adaptor(students, context);

            StudentList.setLayoutManager(layoutManager);
            StudentList.setAdapter(student_1Adaptor);

            new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    students.remove(viewHolder.getAdapterPosition());
                    student_1Adaptor.notifyDataSetChanged();
                    ds.open();
                    ds.removeItem1((Integer) viewHolder.itemView.getTag());
                    ds.close();

                }
            }).attachToRecyclerView(StudentList);

        }
        catch (Exception ex)
        {
            Toast.makeText(this,"error retrieving contents",Toast.LENGTH_LONG).show();

        }
    }

}