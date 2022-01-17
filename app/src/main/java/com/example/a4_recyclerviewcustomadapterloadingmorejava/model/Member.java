package com.example.a4_recyclerviewcustomadapterloadingmorejava.model;

public class Member {
    private String name;
    private String tel;
    private boolean activ;

    public Member(String newName, String newTel, boolean newActiv){
        this.name = newName;
        this.tel = newTel;
        this.activ = newActiv;
    }

    public Member(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isActiv() {
        return activ;
    }

    public void setActiv(boolean activ) {
        this.activ = activ;
    }
}
