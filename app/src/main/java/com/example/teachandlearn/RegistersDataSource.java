package com.example.teachandlearn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class  RegistersDataSource {
    private SQLiteDatabase database;
    private RegistersDBHelper dbHelper;

    public RegistersDataSource(Context context) {
        dbHelper = new RegistersDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    //................................................................

    public boolean insertRegisters_1(Registers c) {
        boolean isInserted = false;
        try {
            ContentValues values = new ContentValues();
            values.put("name", c.getRegisters_1Name());
            values.put("certificate", c.getRegisters_1Certificate());
            values.put("email", c.getRegisters_1Email());
            values.put("subject", c.getRegisters_1Subject());
            values.put("birthday", c.getRegisters_1Birthday());
            values.put("grade", c.getRegisters_1Grade());
            isInserted = database.insert("registers_1", null, values) > 0;
        } catch (Exception e) {

        }
        return isInserted;
    }

    ;

    public boolean insertRegisters_2(Registers c) {
        boolean isInserted = false;
        try {
            ContentValues values = new ContentValues();
            values.put("name", c.getRegisters_2Name());
            values.put("certificate", c.getRegisters_2Certificate());
            values.put("email", c.getRegisters_2Email());
            values.put("subject", c.getRegisters_2Subject());
            values.put("birthday", c.getRegisters_2Birthday());
            isInserted = database.insert("registers_2", null, values) > 0;
        } catch (Exception e) {

        }
        return isInserted;
    }

    ;

    //................................................................

    public boolean updateRegisters_1(Registers c) {
        boolean isUpdated = false;
        try {

            int rowID = c.getRegisters_1ID();
            ContentValues updatedValues = new ContentValues();
            updatedValues.put("name", c.getRegisters_1Name());
            updatedValues.put("certificate", c.getRegisters_1Certificate());
            updatedValues.put("email", c.getRegisters_1Email());
            updatedValues.put("subject", c.getRegisters_1Subject());
            updatedValues.put("birthday", c.getRegisters_1Birthday());

            isUpdated = database.update("registers_1", updatedValues, "id=" + rowID, null) > 0;

        } catch (Exception e) {
        }
        return isUpdated;
    }

    ;

    public boolean updateRegisters_2(Registers c) {
        boolean isUpdated = false;
        try {

            int rowID = c.getRegisters_2ID();
            ContentValues updatedValues = new ContentValues();
            updatedValues.put("name", c.getRegisters_2Name());
            updatedValues.put("certificate", c.getRegisters_2Certificate());
            updatedValues.put("email", c.getRegisters_2Email());
            updatedValues.put("subject", c.getRegisters_2Subject());
            updatedValues.put("birthday", c.getRegisters_2Birthday());

            isUpdated = database.update("registers_2", updatedValues, "id=" + rowID, null) > 0;

        } catch (Exception e) {
        }
        return isUpdated;
    }

    ;

    //................................................................

    public void removeItem(int id)
    {

        try
        {
            database.delete("registers_2", "_id=" + id, null);
        }
        catch (Exception e)
        {

        }
    }

    public void removeItem1(int id)
    {

        try
        {
            database.delete("registers_1", "_id=" + id, null);
        }
        catch (Exception e)
        {

        }
    }

    public int getLastContactID() {
        int lastID;
        try {
            String query = "SELECT MAX(_id) from registers";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastID = cursor.getInt(0);
            cursor.close();
        } catch (Exception e) {
            lastID = -1;
        }
        return lastID;
    }

    public ArrayList<Registers> getTeacherView() {
        ArrayList<Registers> teacherview = new ArrayList<>();
        try {
            String query = "SELECT * FROM registers_2";
            Cursor cursor = database.rawQuery(query, null);

            Registers newRegisters;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                newRegisters = new Registers();

                newRegisters.setRegisters_2ID(cursor.getInt(0));
                newRegisters.setRegisters_2Name(cursor.getString(1));
                newRegisters.setRegisters_2Certificate(cursor.getString(2));
                newRegisters.setRegisters_2Email(cursor.getString(3));
                newRegisters.setRegisters_2Subject(cursor.getString(4));
                newRegisters.setRegisters_2Birthday(cursor.getString(5));

                teacherview.add(newRegisters);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            teacherview = new ArrayList<Registers>();
        }

        return teacherview;
    }

    public ArrayList<Registers> getStudentView() {
        ArrayList<Registers> studentview = new ArrayList<>();
        try {
            String query = "SELECT * FROM registers_1";
            Cursor cursor = database.rawQuery(query, null);

            Registers newRegisters;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                newRegisters = new Registers();

                newRegisters.setRegisters_1ID(cursor.getInt(0));
                newRegisters.setRegisters_1Name(cursor.getString(1));
                newRegisters.setRegisters_1Certificate(cursor.getString(2));
                newRegisters.setRegisters_1Email(cursor.getString(3));
                newRegisters.setRegisters_1Subject(cursor.getString(4));
                newRegisters.setRegisters_1Birthday(cursor.getString(5));
                newRegisters.setRegisters_1Grade(cursor.getString(6));

                studentview.add(newRegisters);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            studentview = new ArrayList<Registers>();
        }

        return studentview;
    }



}

