package com.example.db_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_HELPER_SQL_Lite   extends      SQLiteOpenHelper






{

    private static final String db_name = "mydata.db";

    private static final String table_name ="info";

    private static final String col_id ="id";

    private static final String col_name="name ";

     private  static final String col_Father_Name="father name ";






    public DB_HELPER_SQL_Lite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, db_name, null , 1);





    }

    @Override
    public void onCreate(SQLiteDatabase db /* this is the variable  that we will use */ ) {

        db.execSQL("create table if not exists "+table_name+""+

      "    (id int (11) primary key AutoIncrement not null , name varchar(255)  , fathername varchar(255) )         "



        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(" drop table if exists "+table_name);

        onCreate(db);
    }

    public boolean insert (String n , String f)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(col_name,n);

        cv.put(col_Father_Name,f);


        /*here we had taken long because iot is defined  in the insert method*/
        long res = db.insert(table_name , null ,cv);

        if(res==1)
        {
            return true;
        }
        return false;

    }

}
