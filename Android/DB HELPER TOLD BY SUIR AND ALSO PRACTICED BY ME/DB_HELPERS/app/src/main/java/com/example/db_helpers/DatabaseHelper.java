package com.example.db_helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String dbname ="mydata.db";

    private static final String table_name = " info ";

    private static final String col_id = "id";

    private static final String col_name = "name";

    private static final String col_Father_name = " father name ";



    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {

        /* here we created our database */

        super(context, dbname/*database ka nam aye ga*/, null/* Not needed right now */,  1 /*current version*/ );
    }

    @Override
    public void onCreate(SQLiteDatabase db/*this db is the variable  */) {
/*ya jub chle ga jub application pahle bar run ho ge */

    /*  execSQL  <-- executes SQL  , it runs Querry    */

        /*  this is how we created one table  */

db.execSQL("create table if not exists"+table_name+""+

        "  (   id int (11)  primary key AutoIncrement  not null  , name varchar(255)  , fathername varchar (255))  "

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" drop table if exists /*  delet table if it exists  if not create a database */"+table_name );

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

        cv.put(col_name,n);
        cv.put(col_Father_name,f);

        /*here  we had taken long because it is define  */

        long res = db.insert(table_name,null/*we havent learn call back yet */,cv);




        if(res==1)
        {
            return true;
        }
        return false;




    }

}
