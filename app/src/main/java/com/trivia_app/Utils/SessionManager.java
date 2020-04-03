package com.trivia_app.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static SharedPreferences preferences;
    public static final String USER_PREFERENCES = "userPreference";
    public static final String userName = "userName";

    public static void savePreference(Context context, String key, String value){
        preferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getPreference(Context context, String key){
        preferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }
}
