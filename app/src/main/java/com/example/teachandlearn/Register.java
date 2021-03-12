package com.example.teachandlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        GO();
    }

    private void GO() {

        Button GO = (Button) findViewById(R.id.registerGoButton);
        GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                RadioButton Student = (RadioButton) findViewById(R.id.registerRadioButton1);
                RadioButton Teacher = (RadioButton) findViewById(R.id.registerRadioButton2);

                if (Student.isChecked())
                {
                    Intent intent = new Intent(Register.this, Register_1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                if(Teacher.isChecked())
                {
                    Intent intent = new Intent(Register.this, Register_2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });

    }
}