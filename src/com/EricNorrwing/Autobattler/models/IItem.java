package com.EricNorrwing.Autobattler.models;

public interface IItem {

    String[] affixArray = {"Greater ", "Lesser ", "Massive ", "Small ", "Magical "};
    String[] suffixArray = {" of Strength", " of Agility", " of Skill", " of Health", " of Lethality"};

    //Interface methods for things
    void generateName();
    default String getAffix(){
        return affixArray[(int) (Math.random()*5)];
    }
    default String getSuffix(){
        return suffixArray[(int) (Math.random()*5)];
    }
    void initializeStats();
}
