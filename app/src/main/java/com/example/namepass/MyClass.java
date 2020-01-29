package com.example.namepass;

import android.text.TextUtils;

import java.util.regex.Pattern;

public class MyClass {

    public static boolean emailExists(String password) {

        if (password == null || !password.isEmpty()) {
            //Check lenght of Password
            return true;
        }
        return false;
    }


    public static boolean passIsLongEnought(String password) {
        if (password.length() > 6) {
            return true;
        }

        return false;
    }

    public static boolean passHasUppercase(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        if (hasUppercase) {
            return true;
        }

        return false;
    }

    public static boolean passHaslowercase(String password) {
        boolean hasLowercase = !password.equals(password.toUpperCase());

        if (hasLowercase){
            return true;
        }

        return false;
    }

    public static boolean passHasSymbol(String password) {
        boolean hasSymbol   = !password.matches("[A-Za-z0-9]*");
        if (hasSymbol){
            return true;
        }

        return false;
    }

    public static boolean passHasNumber (String password) {
        boolean hasNumber   = Pattern.matches(".*\\d+.*", password);
        if (hasNumber){
            return true;
        }

        return false;
    }


    public static int progressBarValue(int i){

        return i*20;
    }



}
