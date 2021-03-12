package com.example.teachandlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Object MainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GO();

    }

    private void GO() {

        Button GO = (Button) findViewById(R.id.mainGoButton);
        GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                RadioButton Student = (RadioButton) findViewById(R.id.mainRadioButton1);
                RadioButton Teacher = (RadioButton) findViewById(R.id.mainRadioButton2);
                RadioButton Register = (RadioButton) findViewById(R.id.mainRadioButton3);
                if (Student.isChecked())
                {
                    Intent intent = new Intent(MainActivity.this, Teacher_1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                if(Teacher.isChecked())
                {
                    Intent intent = new Intent(MainActivity.this, Student_1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                if(Register.isChecked())
                {
                    Intent intent = new Intent(MainActivity.this, Register.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });

    }

}