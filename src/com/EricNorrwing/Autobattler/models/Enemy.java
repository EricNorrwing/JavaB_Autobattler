package com.EricNorrwing.Autobattler.models;

public class Enemy extends AUnit{

    //TODO generate list of affixes and suffixes, and their respective modifiers
    private int type;
    private int affix;
    private int suffix;


    public Enemy(int type, int affix, int suffix) {
        this.type = type;
        this.affix = affix;
        this.suffix = suffix;
    }
    public void generateName(){
        String[] typeArray = {" Wraith", " Bandit", " Dragon"," Zombie", " Ghost", " Mimic"," Lich", " Wolf", " Witch"," Duelist"};
        String[] affixArray = {"Greater", "Juggernaught", "Agile","Quick", "Strong", "Weak","Small", "Keen", "Massive","Coward"};
        String[] suffixArray = {" the frail", " the Bright", " of massive loot"," of Brutality", " of Deception", " of Vengeance"," of Chaos", " of Laziness", " of Ineptitude"," the uneducated"};
        System.out.println(affixArray[affix] + typeArray[type] + suffixArray[suffix]);
        setName(affixArray[affix] + typeArray[type] + suffixArray[suffix]);
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
