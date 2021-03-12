package com.example.teachandlearn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.util.Calendar;

public class Register_2 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Registers currentRegisters;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_2);

        currentRegisters = new Registers();

        setDate();

        initTextChangeEvents_2();
        initSaveButton_2();
        initToggleButton_2();
        setForEditting_2(false);
        hideKeyboard_2();

    }

    private void setDate()
    {
        Button button = (Button) findViewById(R.id.register_2DateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }
    private void initToggleButton_2()
    {
        final ToggleButton editToggle = (ToggleButton)findViewById(R.id.register_2ToggleButton);
        editToggle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setForEditting_2(editToggle.isChecked());
            }
        });
    }
    private void setForEditting_2(boolean enable)
    {
        final EditText name = (EditText)findViewById(R.id.register_2EditText1);
        name.setEnabled(enable);
        if(enable)
        {
            name.requestFocus();
        }

        final EditText certificate = (EditText)findViewById(R.id.register_2EditText2);
        certificate.setEnabled(enable);
        if(enable)
        {
            certificate.requestFocus();
        }

        final EditText email = (EditText)findViewById(R.id.register_2EditText3);
        email.setEnabled(enable);
        if(enable)
        {
            email.requestFocus();
        }

        final EditText subject = (EditText)findViewById(R.id.register_2EditText4);
        subject.setEnabled(enable);
        if(enable)
        {
            subject.requestFocus();
        }

        final Button register_2DateButton = (Button)findViewById(R.id.register_2DateButton);
        register_2DateButton.setEnabled(enable);
        if(enable)
        {
            register_2DateButton.requestFocus();
        }

        final Button register_2SaveButton = (Button)findViewById(R.id.register_2SaveButton);
        register_2SaveButton.setEnabled(enable);
        if(enable)
        {
            register_2SaveButton.requestFocus();
        }
    }




    @Override

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.register_2TextView5);
        textView.setText(currentDateString);

    }

    private void initTextChangeEvents_2()
    {
        final EditText name = (EditText)findViewById(R.id.register_2EditText1);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                currentRegisters.setRegisters_2Name(name.getText().toString());
            }
        });

        final EditText certificate = (EditText)findViewById(R.id.register_2EditText2);
        certificate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }
            @Override
            public void afterTextChanged(Editable s)
            {
                currentRegisters.setRegisters_2Certificate(certificate.getText().toString());
            }
        });

        final EditText email = (EditText)findViewById(R.id.register_2EditText3);
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                currentRegisters.setRegisters_2Email(email.getText().toString());
            }
        });

        final TextView birthday = (TextView)findViewById(R.id.register_2TextView5);
        birthday.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                currentRegisters.setRegisters_2Birthday(birthday.getText().toString());
            }
        });

        final EditText subject = (EditText)findViewById(R.id.register_2EditText4);
        subject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                currentRegisters.setRegisters_2Subject(subject.getText().toString());
            }
        });

    }
    private void initSaveButton_2()
    {
        Button saveButton = (Button)findViewById(R.id.register_2SaveButton);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                boolean isSaved=false;
                hideKeyboard_2();

                final EditText name = (EditText)findViewById(R.id.register_2EditText1);
                final EditText certificate = (EditText)findViewById(R.id.register_2EditText2);
                final EditText email = (EditText)findViewById(R.id.register_2EditText3);
                final EditText subject = (EditText)findViewById(R.id.register_2EditText4);
                final TextView birthday = (TextView)findViewById(R.id.register_2TextView5);

                RegistersDataSource ds = new RegistersDataSource(Register_2.this);

                try {
                    ds.open();
                    if (currentRegisters.getRegisters_2ID()==-1)
                    {
                        isSaved = ds.insertRegisters_2(currentRegisters);
                        if(isSaved)
                        {
                            int newId = ds.getLastContactID();
                            currentRegisters.setRegisters_2ID(newId);
                        }
                    }
                    else
                    {
                        isSaved = ds.updateRegisters_2(currentRegisters);
                    }
                    ds.close();

                }
                catch (Exception e)
                {
                    isSaved = false;
                }

                if(isSaved==true)
                {
                    ToggleButton editToggle = (ToggleButton)findViewById(R.id.register_2ToggleButton);
                    editToggle.toggle();
                    setForEditting_2(false);

                    name.setText("");
                    certificate.setText("");
                    email.setText("");
                    subject.setText("");
                    birthday.setText("Choose Your DOB : ");

                    Context context = Register_2.this;
                    CharSequence text = "your data is saved";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    for (int i = 0; i < 7; i++)
                    {
                        CharSequence text1 = "YOU CAN SWIPE LEFT OR RIGHT IN THE LIST_VIEW TO DELETE THIS ITEM !";
                        int duration1 = Toast.LENGTH_LONG;
                        Toast toast1 = Toast.makeText(context, text1, duration1);
                        toast1.show();
                    }

                }
            }
        });
    }
    private  void hideKeyboard_2()
    {
        InputMethodManager keyboardManager1 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText name = (EditText) findViewById(R.id.register_2EditText1);
        keyboardManager1.hideSoftInputFromWindow(name.getWindowToken(),0);

        InputMethodManager keyboardManager2 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText certificate = (EditText) findViewById(R.id.register_2EditText2);
        keyboardManager2.hideSoftInputFromWindow(certificate.getWindowToken(),0);

        InputMethodManager keyboardManager3 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText email = (EditText) findViewById(R.id.register_2EditText3);
        keyboardManager3.hideSoftInputFromWindow(email.getWindowToken(),0);

        InputMethodManager keyboardManager4 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText subject = (EditText) findViewById(R.id.register_2EditText4);
        keyboardManager4.hideSoftInputFromWindow(subject.getWindowToken(),0);

    }

}