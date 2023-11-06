package com.EricNorrwing.Autobattler.models;

public interface IItem {

    String[] affixArray = {"Greater ", "Lesser ", "Massive ", "Small ", "Magical "};
    String[] suffixArray = {" of Strength", " of Agility", " of Skill", " of Health", " of Lethality"};

    //Interface methods for things
    public void generateName();
    public default String getAffix(){
        return affixArray[(int) (Math.random()*5)];
    }
    public default String getSuffix(){
        return suffixArray[(int) (Math.random()*5)];
    }
    public void initializeStats(AUnit unit);
}
