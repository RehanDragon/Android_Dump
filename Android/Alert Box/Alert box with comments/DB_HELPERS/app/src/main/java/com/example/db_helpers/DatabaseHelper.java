package com.example.db_helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String dbname ="mydata12.db"; // we define our our database name here


    private static final String col_id = "id";

    private static final String col_name = "name";

    private static final String col_Father_name = "fathername";



    public DatabaseHelper(@Nullable Context context) {

        /* here we created our database */

        super(context, dbname/*database ka nam aye ga*/, null/* Not needed right now */,  1 /*current version*/ );
    }

    @Override
    public void onCreate(SQLiteDatabase db/*this db is the variable  */) {
/*ya jub chle ga jub application pahle bar run ho ge */

    /*  execSQL  <-- executes SQL  , it runs Querry    */

        /*  this is how we created one table  */

db.execSQL("create table info12 (name varchar(255)  , fathername varchar (255)    )  "

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

db.execSQL("drop table if exists info12 ");
        onCreate(db);   // created our database


        //  till here our table is created but we havent inserted our values to do that  we will create method for that
    }

    // creating method for inserting values in database

    public boolean insert(String n , String f)
    {

        SQLiteDatabase db = this.getWritableDatabase();

       /*  key, value */
        /* kon se value  kon sa column main aye gye   */
        ContentValues cv = new ContentValues();

        /*jo parameters mojude hain parameters ka ander wo yahen pa put kerain ga  aur aus ko aik key name dain ga  */
        cv.put("name",n); // name mare key ka nam hain
        cv.put("fathername",f);

        /*here  we had taken long because it is define  */

        long res = db.insert("info12",null/*we havent learn call back yet */,cv);




        if(res==-1)
        {
/*over here i was having problem  so i returned false if res == 1  and if   */

            /* by doing this i get the values stored */
            return false;





        }
else
        return true;



    }
/*

Cursor is the pointer ,, aishara kerta ha
* */
    public Cursor getall(){

        SQLiteDatabase db = this.getWritableDatabase();
       Cursor res =  db.rawQuery("select * from info12" ,null);
        return  res;

    }


}
