package com.lexfillll.myapplication;

public class Student {

    private String firstName;
    private String lastName;
    private boolean maleGender;
    private int photo;

    public Student(String firstName, String lastName, boolean maleGender, int photo){
        this.firstName = firstName;
        this.lastName = lastName;
        this.maleGender = maleGender;
        this.photo = photo;
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
