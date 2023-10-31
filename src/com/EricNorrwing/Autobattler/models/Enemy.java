package com.EricNorrwing.Autobattler.models;

public class Enemy extends AUnit{

    //TODO generate list of affixes and suffixes, and their respective modifiers
    private int type;
    private int affix;
    private int suffix;

    public Enemy() {
        this.type = type;
        this.affix = affix;
        this.suffix = suffix;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAffix() {
        return affix;
    }

    public void setAffix(int affix) {
        this.affix = affix;
    }

    public int getSuffix() {
        return suffix;
    }

    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }
}
