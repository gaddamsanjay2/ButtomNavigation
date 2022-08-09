package com.example.buttomnavigation.ui.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListReadHelper extends SQLiteOpenHelper {
    Context context;

    public ListReadHelper(@Nullable Context context) {
        super(context,"ODSEmployee.db",null,2);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
