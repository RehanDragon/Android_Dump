package com.us.signup_form_and_login_Form_with_sharedPreferences_and_Date_With_SQLliteOpenHelper_Connected;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register.db";

    public static final String TABLE_NAME = "register";

    public static final String COL_1="ID";

    public static final String COL_2="FirstName";
    public static final String COL_3="LastName";
    public static final String COL_4="UserName";
    public static final String COL_5="Password";
    public static final String COL_6="Email";


    public DatabaseOpenHelper(@Nullable Context context) {

        super(context,/*here we will write our database name*/DATABASE_NAME   , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db/*this is the variable which we will use*/) {
/*over here be carefull that their should be no spaces among commas in db.execSQL after AUTOINCREMENT and so on , no spaces are allowed*/
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,FirstName TEXT,LastName TEXT,UserName TEXT,Password TEXT,Email Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db/*this is the variable which we will use*/, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
