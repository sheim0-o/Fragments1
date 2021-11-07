package com.example.fragments1;

public class Utility {
    public static boolean isEmail(String email) {
        return email != null && email.contains("@");
    }
}
