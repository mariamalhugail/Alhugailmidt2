package com.example.alhugailmidt2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

    public class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "data.db";
        public static final String TABLE_NAME = "Datab";
        public static final String COLUMN_ID = "ID";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_phonenub= "PhoneNumber";
        public static final String COLUMN_email= "Email";


        public DatabaseHelper(@Nullable Context context) {


            super(context, DATABASE_NAME, null, 1
            ); }


        @Override
        public void onCreate(SQLiteDatabase datab) {
            datab.execSQL(

                    "CREATE TABLE " +TABLE_NAME +"(" +
                            COLUMN_ID + " INTEGER PRIMARY KEY," +
                            COLUMN_NAME + " TEXT NOT NULL," +
                            COLUMN_phonenub + " INTEGER NOT NULL, " +
                            COLUMN_email + " INTEGER NOT NULL)"
            );
        }


        //button method 1 (add)
        public void Addinfo(String id, String name, String email , int phonenumber) {

            SQLiteDatabase datab = this.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put(COLUMN_ID, id);
            val.put(COLUMN_NAME, name);
            val.put(COLUMN_phonenub, phonenumber);
            val.put(COLUMN_email, email);
            datab.insert(TABLE_NAME, null, val);
        }


        //button method 2 (view)
        public Cursor ViewEmployees() {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor dax = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            return dax;

        }


        //button method 3 (delete)
        public Integer Deleteinfo(String id){
            SQLiteDatabase db=this.getWritableDatabase ();
            return db.delete (TABLE_NAME, "PersonalID = ?", new String[] {id});
        }



        @Override
        /* Every time the dB is updated (or upgraded) */

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }


    }

