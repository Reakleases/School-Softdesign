package com.softdesign.school.data.storage.preferences;

import android.content.SharedPreferences;

import com.softdesign.school.ui.activities.ActiveAndroidApplication;

import java.util.ArrayList;
import java.util.List;

public class UserPreferences {

    private static final String USER_PROFILE_PHONE = "phone";
    private static final String USER_PROFILE_EMAIL = "email";
    private static final String USER_PROFILE_VK = "vk";
    private static final String USER_PROFILE_GIT = "git";
    private static final String USER_PROFILE_BIO = "bio";
    private static final String[] USER_FIELDS = {USER_PROFILE_PHONE, USER_PROFILE_EMAIL, USER_PROFILE_VK, USER_PROFILE_GIT, USER_PROFILE_BIO};
    private SharedPreferences mPreferences;


    public void saveUserProfileData(List<String> userFields) {
        mPreferences = ActiveAndroidApplication.getPreferences();
        SharedPreferences.Editor preferenceEditor = mPreferences.edit();

        for (int i = 0; i < userFields.size(); ++i) {
            preferenceEditor.putString(USER_FIELDS[i], userFields.get(i));
        }

        preferenceEditor.apply();
    }

    public List<String> loadUserProfileData() {
        mPreferences = ActiveAndroidApplication.getPreferences();
        List<String> userFields = new ArrayList<>();
        userFields.add(mPreferences.getString(USER_PROFILE_PHONE, "+7 (917) 826–58–76"));
        userFields.add(mPreferences.getString(USER_PROFILE_EMAIL, "Reakleases@gmail.com"));
        userFields.add(mPreferences.getString(USER_PROFILE_VK, "https://vk.com/Reakleases"));
        userFields.add(mPreferences.getString(USER_PROFILE_GIT, "https://github.com/Reakleases"));
        userFields.add(mPreferences.getString(USER_PROFILE_BIO, "хочу стать андроид разработчиком"));
        return userFields;
    }
}
