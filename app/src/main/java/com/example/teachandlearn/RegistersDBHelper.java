package com.example.teachandlearn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class RegistersDBHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "myregisters.db";

    private static final int DATABASE_VERSION = 1;

    public RegistersDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private static final String CREATE_TABLE_REGISTERS_1 =
            "create table registers_1 (_id integer primary key autoincrement,"
                    + "name text,"
                    + "certificate text, "
                    + "email text,"
                    + "subject text,"
                    + "birthday text,"
                    + "grade text);";

    private static final String CREATE_TABLE_REGISTERS_2 =
            "create table registers_2(_id integer primary key autoincrement,"
                    + "name text,"
                    + "certificate text,"
                    + "email text,"
                    + "subject text,"
                    + "birthday text);";



    @Override

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_REGISTERS_1);
        db.execSQL(CREATE_TABLE_REGISTERS_2);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(RegistersDBHelper.class.getName(), "upgrading database from version" + oldVersion + "to" + newVersion+", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS registers_1");
        db.execSQL("DROP TABLE IF EXISTS registers_2");
        onCreate(db);
    }

}