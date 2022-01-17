package com.example.a4_recyclerviewcustomadapterloadingmorejava.model;

public class Member2 {
    String name;
    String about;
    Member2(String name, String about){
        this.name = name;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setName(String name) {
        this.name = name;
    }
}
