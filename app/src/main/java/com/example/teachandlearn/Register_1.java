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

public class Register_1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Registers currentRegisters;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_1);

        currentRegisters = new Registers();

        setDate();

        initTextChangeEvents_1();
        initSaveButton_1();
        initToggleButton_1();
        setForEditting_1(false);
        hideKeyboard_1();

    }

    private void setDate()
    {
        Button button = (Button) findViewById(R.id.register_1DateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }
    private void initToggleButton_1()
    {
        final ToggleButton editToggle = (ToggleButton)findViewById(R.id.register_1ToggleButton);
        editToggle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setForEditting_1(editToggle.isChecked());
            }
        });
    }
    private void setForEditting_1(boolean enable)
    {
        final EditText name = (EditText)findViewById(R.id.register_1EditText1);
        name.setEnabled(enable);
        if(enable)
        {
            name.requestFocus();
        }

        final EditText certificate = (EditText)findViewById(R.id.register_1EditText2);
        certificate.setEnabled(enable);
        if(enable)
        {
            certificate.requestFocus();
        }

        final EditText email = (EditText)findViewById(R.id.register_1EditText3);
        email.setEnabled(enable);
        if(enable)
        {
            email.requestFocus();
        }

        final EditText subject = (EditText)findViewById(R.id.register_1EditText4);
        subject.setEnabled(enable);
        if(enable)
        {
            subject.requestFocus();
        }

        final EditText grade = (EditText)findViewById(R.id.register_1EditText5);
        grade.setEnabled(enable);
        if(enable)
        {
            subject.requestFocus();
        }

        final Button register_1DateButton = (Button)findViewById(R.id.register_1DateButton);
        register_1DateButton.setEnabled(enable);
        if(enable)
        {
            register_1DateButton.requestFocus();
        }

        final Button register_1SaveButton = (Button)findViewById(R.id.register_1SaveButton);
        register_1SaveButton.setEnabled(enable);
        if(enable)
        {
            register_1SaveButton.requestFocus();
        }
    }




    @Override

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.register_1TextView5);
        textView.setText(currentDateString);

    }

    private void initTextChangeEvents_1()
    {
        final EditText name = (EditText)findViewById(R.id.register_1EditText1);
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
                currentRegisters.setRegisters_1Name(name.getText().toString());
            }
        });

        final EditText certificate = (EditText)findViewById(R.id.register_1EditText2);
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
                currentRegisters.setRegisters_1Certificate(certificate.getText().toString());
            }
        });

        final EditText email = (EditText)findViewById(R.id.register_1EditText3);
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
                currentRegisters.setRegisters_1Email(email.getText().toString());
            }
        });

        final EditText subject = (EditText)findViewById(R.id.register_1EditText4);
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
                currentRegisters.setRegisters_1Subject(subject.getText().toString());
            }
        });

        final TextView birthday = (TextView)findViewById(R.id.register_1TextView5);
        birthday.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                currentRegisters.setRegisters_1Birthday(birthday.getText().toString());
            }
        });

        final EditText grade = (EditText)findViewById(R.id.register_1EditText5);
        grade.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                currentRegisters.setRegisters_1Grade(subject.getText().toString());
            }
        });

    }
    private void initSaveButton_1()
    {
        Button saveButton = (Button)findViewById(R.id.register_1SaveButton);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                boolean isSaved = false;
                hideKeyboard_1();

                final EditText name = (EditText) findViewById(R.id.register_1EditText1);
                final EditText certificate = (EditText) findViewById(R.id.register_1EditText2);
                final EditText email = (EditText) findViewById(R.id.register_1EditText3);
                final EditText subject = (EditText) findViewById(R.id.register_1EditText4);
                final EditText grade = (EditText) findViewById(R.id.register_1EditText5);
                final TextView birthday = (TextView) findViewById(R.id.register_1TextView5);

                RegistersDataSource ds = new RegistersDataSource(Register_1.this);

                try {
                    ds.open();
                    if (currentRegisters.getRegisters_1ID() == -1) {
                        isSaved = ds.insertRegisters_1(currentRegisters);
                        if (isSaved) {
                            int newId = ds.getLastContactID();
                            currentRegisters.setRegisters_1ID(newId);
                        }
                    } else {
                        isSaved = ds.updateRegisters_1(currentRegisters);
                    }
                    ds.close();

                } catch (Exception e) {
                    isSaved = false;
                }

                if (isSaved == true) {
                    ToggleButton editToggle = (ToggleButton) findViewById(R.id.register_1ToggleButton);
                    editToggle.toggle();
                    setForEditting_1(false);

                    name.setText("");
                    certificate.setText("");
                    email.setText("");
                    subject.setText("");
                    grade.setText("");
                    birthday.setText("Choose Your DOB : ");

                    Context context = Register_1.this;

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
    private  void hideKeyboard_1()
    {
        InputMethodManager keyboardManager1 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText name = (EditText) findViewById(R.id.register_1EditText1);
        keyboardManager1.hideSoftInputFromWindow(name.getWindowToken(),0);

        InputMethodManager keyboardManager2 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText certificate = (EditText) findViewById(R.id.register_1EditText2);
        keyboardManager2.hideSoftInputFromWindow(certificate.getWindowToken(),0);

        InputMethodManager keyboardManager3 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText email = (EditText) findViewById(R.id.register_1EditText3);
        keyboardManager3.hideSoftInputFromWindow(email.getWindowToken(),0);

        InputMethodManager keyboardManager4 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText subject = (EditText) findViewById(R.id.register_1EditText4);
        keyboardManager4.hideSoftInputFromWindow(subject.getWindowToken(),0);

        InputMethodManager keyboardManager5 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText grade = (EditText) findViewById(R.id.register_1EditText5);
        keyboardManager4.hideSoftInputFromWindow(grade.getWindowToken(),0);

    }

}