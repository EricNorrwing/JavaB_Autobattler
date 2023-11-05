package com.EricNorrwing.Autobattler.models;

public class Weapon implements IItem{
    String name;
    @Override
    public void generateName() {
        String name = getAffix() + "Weapon" + getSuffix();
        System.out.println(name);
    }

    @Override
    public void initializeStats() {

    }
}
