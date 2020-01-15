package com.lexfillll.myapplication;

import android.text.Editable;

public class Student {

    private String firstName;
    private String lastName;
    private boolean maleGender;
    private int photo;
    private static int index;

    public Student(String firstName, String lastName, boolean malrGender, int photo){
        this.firstName = firstName;
        this.lastName = lastName;
        this.maleGender = malrGender;
        this.photo = photo;
        index+=1;
    }

    public static int getIndex() {
        return index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMaleGender() {
        return maleGender;
    }

    public void setMaleGender(boolean maleGender) {
        this.maleGender = maleGender;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
