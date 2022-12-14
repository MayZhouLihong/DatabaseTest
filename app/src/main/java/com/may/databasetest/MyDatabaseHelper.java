package com.may.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * DES:
 * <p>
 * Date: 2022/12/7  22:18
 *
 * @author Jason
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK="create table Book ( id integer primary key autoincrement, " +
            "author text, " +
            "price real, "+
            "pages integer, "+
            "name text)";

    public static final String CREATE_CATEGORY="create table Category ( id integer primary key autoincrement, " +
            "category_name text, " +
            "category_code integer)";

    private Context mContext;





    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);
        sqLiteDatabase.execSQL(CREATE_CATEGORY);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Book");
        sqLiteDatabase.execSQL("drop table if exists Cstegory");
        onCreate(sqLiteDatabase);

    }
}
