package com.donntu.kp.client.csv.creations.interfaces;


import com.donntu.kp.client.csv.creations.Sex;

public class Mammal extends Creation {
    private boolean hooves;
    private boolean horns;
    private boolean wool;
    private boolean scales;

    public Mammal() {
    }

    public Mammal(String arial, String sound, Integer limbCount, Sex sex, Boolean pet, Boolean hooves, Boolean horns, Boolean wool, Boolean scales, String name) {
        setArial(arial);
        setSound(sound);
        setHorns(horns);
        setLimbCount(limbCount);
        setHooves(hooves);
        setPet(pet);
        setSex(sex);
        setScales(scales);
        setWool(wool);
        setName(name);
    }

    public boolean isHooves() {
        return hooves;
    }

    public void setHooves(boolean hooves) {
        this.hooves = hooves;
    }

    public boolean isHorns() {
        return horns;
    }

    public void setHorns(boolean horns) {
        this.horns = horns;
    }

    public boolean isWool() {
        return wool;
    }

    public void setWool(boolean wool) {
        this.wool = wool;
    }

    public boolean isScales() {
        return scales;
    }

    public void setScales(boolean scales) {
        this.scales = scales;
    }
}
