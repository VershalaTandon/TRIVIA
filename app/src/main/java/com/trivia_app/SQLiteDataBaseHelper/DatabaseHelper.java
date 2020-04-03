package com.trivia_app.SQLiteDataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.trivia_app.Model.Summary;
import com.trivia_app.Utils.SessionManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "trivia_db";

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create notes table
        db.execSQL(DBCreation.CREATE_TABLE_SUMMARY);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DBCreation.TABLE_NAME_SUMMARY);
        // Create tables again
        onCreate(db);
    }

    public void insertSummary(String question1, String q1_option1, String q1_option2, String q1_option3,
                              String q1_option4, String answer1, String question2, String q2_option1, String q2_option2, String q2_option3,
                              String q2_option4, String answer2){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        String currentDateTime = sdf.format(new Date());

        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBCreation.SUMMARY_USER_NAME, SessionManager.getPreference(context, SessionManager.userName));
        values.put(DBCreation.SUMMARY_DATE_TIME, currentDateTime);
        values.put(DBCreation.SUMMARY_QUESTION1, question1);
        values.put(DBCreation.SUMMARY_QUESTION1_OPTION1, q1_option1);
        values.put(DBCreation.SUMMARY_QUESTION1_OPTION2, q1_option2);
        values.put(DBCreation.SUMMARY_QUESTION1_OPTION3, q1_option3);
        values.put(DBCreation.SUMMARY_QUESTION1_OPTION4, q1_option4);
        values.put(DBCreation.SUMMARY_QUESTION1_ANSWER, answer1);
        values.put(DBCreation.SUMMARY_QUESTION2, question2);
        values.put(DBCreation.SUMMARY_QUESTION2_OPTION1, q2_option1);
        values.put(DBCreation.SUMMARY_QUESTION2_OPTION2, q2_option2);
        values.put(DBCreation.SUMMARY_QUESTION2_OPTION3, q2_option3);
        values.put(DBCreation.SUMMARY_QUESTION2_OPTION4, q2_option4);
        values.put(DBCreation.SUMMARY_QUESTION2_ANSWER, answer2);

        // insert row
        db.insert(DBCreation.TABLE_NAME_SUMMARY, null, values);

        // close db connection
        db.close();
    }

    public ArrayList<Summary> getAllHistory() {
        ArrayList<Summary> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DBCreation.TABLE_NAME_SUMMARY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Summary note = new Summary(cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_USER_NAME)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_DATE_TIME)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION1)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION1_OPTION1)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION1_OPTION2)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION1_OPTION3)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION1_OPTION4)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION1_ANSWER)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION2)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION2_OPTION1)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION2_OPTION2)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION2_OPTION3)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION2_OPTION4)),
                        cursor.getString(cursor.getColumnIndex(DBCreation.SUMMARY_QUESTION2_ANSWER)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

}