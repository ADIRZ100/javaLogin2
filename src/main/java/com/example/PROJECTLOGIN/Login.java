/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PROJECTLOGIN;

/**
 *
 * @author user
 */
public class Login {
    private static String userName;
    private static String password;
    private static String gmail;
    private static String phoneNumber;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Login.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Login.password = password;
    }

    public static String getGmail() {
        return gmail;
    }

    public static void setGmail(String gmail) {
        Login.gmail = gmail;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        Login.phoneNumber = phoneNumber;
    }
}


