package com.donntu.kp.client.csv.creations.interfaces;


import com.donntu.kp.client.csv.creations.Sex;

public class Bird extends Creation {
    private String color;
    private boolean manual;
    private boolean speaking;

    public Bird(String arial, String sound, Integer limbCount, Sex sex, Boolean pet, String color, Boolean manual, Boolean speaking, String name) {
        setArial(arial);
        setColor(sound);
        setLimbCount(limbCount);
        setManual(manual);
        setPet(pet);
        setSex(sex);
        setSound(sound);
        setSpeaking(speaking);
        setName(name);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public boolean isSpeaking() {
        return speaking;
    }

    public void setSpeaking(boolean speaking) {
        this.speaking = speaking;
    }

    public Bird(){

    }
}
