package com.example.projecttpmobile.controller;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.projecttpmobile.model.user;

public class UserController {
    private static final String PREF_NAME = "UserPreferences";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMAIL = "email";
    private String username;
    private String pwd;
    private String email;
    private com.example.projecttpmobile.model.user user;
    public UserController(){
    }
    public void createUser(String username, String pwd, String email,Context context){
        user= new user(username,pwd,email);
        //here we are going to save our info using sharedPreference
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_PASSWORD,pwd);
    }
    public static void recapUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString(KEY_USERNAME, "");
        String password = sharedPreferences.getString(KEY_PASSWORD, "");
        String email = sharedPreferences.getString(KEY_EMAIL, "");

        if (!userName.isEmpty() && !password.isEmpty()) {
            user user = new user(userName, password,email);
        }
    }
    /*public static void saveUser(Context context, String userName, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, userName);
        editor.putString(KEY_PASSWORD, password);
        // Save additional user data if needed
        // editor.putString(KEY_EMAIL, userEmail);
        editor.apply();
    }*/

}
