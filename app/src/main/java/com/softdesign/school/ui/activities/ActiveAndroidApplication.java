package com.softdesign.school.ui.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

public class ActiveAndroidApplication extends Application {


    private static SharedPreferences preferences;


    public static SharedPreferences getPreferences() {
        return preferences;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        ActiveAndroid.initialize(this);
    }
}
