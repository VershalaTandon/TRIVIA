package com.trivia_app.SQLiteDataBaseHelper;

public class DBCreation {

    public static final String TABLE_NAME_SUMMARY = "trivia_summary";
    public static final String SUMMARY_ID = "summary_id";
    public static final String SUMMARY_USER_NAME = "summary_user_name";
    public static final String SUMMARY_DATE_TIME = "summary_date_time";
    public static final String SUMMARY_QUESTION1 = "summary_question1";
    public static final String SUMMARY_QUESTION1_OPTION1 = "summary_question1_option1";
    public static final String SUMMARY_QUESTION1_OPTION2 = "summary_question1_option2";
    public static final String SUMMARY_QUESTION1_OPTION3 = "summary_question1_option3";
    public static final String SUMMARY_QUESTION1_OPTION4 = "summary_question1_option4";
    public static final String SUMMARY_QUESTION1_ANSWER = "summary_question1_answer";
    public static final String SUMMARY_QUESTION2 = "summary_question2";
    public static final String SUMMARY_QUESTION2_OPTION1 = "summary_question2_option1";
    public static final String SUMMARY_QUESTION2_OPTION2 = "summary_question2_option2";
    public static final String SUMMARY_QUESTION2_OPTION3 = "summary_question2_option3";
    public static final String SUMMARY_QUESTION2_OPTION4 = "summary_question2_option4";
    public static final String SUMMARY_QUESTION2_ANSWER = "summary_question2_answer";

    public static final String CREATE_TABLE_SUMMARY =
            "CREATE TABLE " + TABLE_NAME_SUMMARY + "("
                    + SUMMARY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + SUMMARY_USER_NAME + " TEXT,"
                    + SUMMARY_DATE_TIME + " TEXT,"
                    + SUMMARY_QUESTION1 + " TEXT,"
                    + SUMMARY_QUESTION1_OPTION1 + " TEXT,"
                    + SUMMARY_QUESTION1_OPTION2 + " TEXT,"
                    + SUMMARY_QUESTION1_OPTION3 + " TEXT,"
                    + SUMMARY_QUESTION1_OPTION4 + " TEXT,"
                    + SUMMARY_QUESTION1_ANSWER + " TEXT,"
                    + SUMMARY_QUESTION2 + " TEXT,"
                    + SUMMARY_QUESTION2_OPTION1 + " TEXT,"
                    + SUMMARY_QUESTION2_OPTION2 + " TEXT,"
                    + SUMMARY_QUESTION2_OPTION3 + " TEXT,"
                    + SUMMARY_QUESTION2_OPTION4 + " TEXT,"
                    + SUMMARY_QUESTION2_ANSWER + " TEXT"
                    + ")";

}
