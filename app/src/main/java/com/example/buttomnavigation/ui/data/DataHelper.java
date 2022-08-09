package com.example.buttomnavigation.ui.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {
    Context context;
    
    public DataHelper(@Nullable Context context) {
        super(context, "ODSEmployee.db",null,2);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table ODSEmployee(ID Integer Primary key,Name text,Mail text)");
        Toast.makeText(context, "SQL started", Toast.LENGTH_SHORT).show();
    }

    public long insert(SQLiteDatabase sqLiteDatabase,int sno,String name,String mail)
    {
        ContentValues cv=new ContentValues();
        cv.put("id",sno);
        cv.put("Name",name);
        cv.put("Mail",mail);

        long set=sqLiteDatabase.insert("ODSEmployee",null,cv);
        return set;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
