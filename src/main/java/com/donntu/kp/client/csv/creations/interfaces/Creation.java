package com.donntu.kp.client.csv.creations.interfaces;



import com.donntu.kp.client.csv.creations.Sex;

import java.io.Serializable;

public abstract class Creation implements Serializable {
    private boolean pet;
    private String arial;
    private int limbCount;
    private Sex sex;
    private String sound;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doSound(){
        System.out.println(sound);
    }

    public boolean isPet() {
        return pet;
    }

    public void setPet(boolean pet) {
        this.pet = pet;
    }

    public String getArial() {
        return arial;
    }

    public void setArial(String arial) {
        this.arial = arial;
    }

    public int getLimbCount() {
        return limbCount;
    }

    public void setLimbCount(int limbCount) {
        this.limbCount = limbCount;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
