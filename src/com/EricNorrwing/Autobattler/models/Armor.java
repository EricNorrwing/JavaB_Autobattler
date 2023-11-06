package com.EricNorrwing.Autobattler.models;

public class Armor implements IItem{
    private String[] typeArray = {"Leather", "Chainmail", "Platemail", "Robe", "Enchanted platearmor"};
    private String name;
    private String affix;
    private String suffix;
    private String type;
    private int damageReduction;
    private int agilityModifier;
    private int strengthModifier;
    private int healthModifier;
    private int skillModifier;
    private int lethalityModifier;

    public int getDamageReduction() {
        return damageReduction;
    }
    public String getType(){
        return typeArray[(int) (Math.random()*5)];
    }


    public String getName() {
        return name;
    }

    @Override
    public void generateName() {
        this.affix = getAffix();
        this.suffix = getSuffix();
        this.type = getType();
        this.name = affix + type + suffix;

    }

    public int getAgilityModifier() {
        return agilityModifier;
    }

    public int getStrengthModifier() {
        return strengthModifier;
    }

    public int getHealthModifier() {
        return healthModifier;
    }

    public int getSkillModifier() {
        return skillModifier;
    }

    public int getLethalityModifier() {
        return lethalityModifier;
    }

    @Override
    public void initializeStats() {
        switch (this.affix) {
            case "Greater " -> damageReduction = damageReduction+5;
            case "Lesser " -> damageReduction = damageReduction+2;
            case "Massive " -> damageReduction = damageReduction+7;
            case "Small " -> damageReduction = damageReduction+1;
            case "Magical " -> damageReduction = damageReduction+10;
        }

        switch (this.suffix) {
            case " of Strength" -> strengthModifier = 5;
            case " of Agility" -> agilityModifier = 5;
            case " of Skill" -> skillModifier = 5;
            case " of Health" -> healthModifier = 50;
            case " of Lethality" -> lethalityModifier = 5;
        }
        switch (this.type) {
            case "Leather"-> agilityModifier = agilityModifier + 5;
            case "Chainmail" -> {
                healthModifier = healthModifier+20;
                damageReduction = damageReduction+5;
                agilityModifier = agilityModifier - 5;
            }
            case "Platemail" -> {
                damageReduction = damageReduction+10;
                agilityModifier = agilityModifier - 10;
            }
            case "Robe" -> {
                agilityModifier=agilityModifier+10;
                lethalityModifier= lethalityModifier+15;
            }
            case "Enchanted platearmor" -> {
                damageReduction = damageReduction+10;
            }
        }
    }
    public void generateArmor(Player player){
        generateName();
        initializeStats();
        System.out.println(getName());
    }

    //TODO FIX PRINTER
    public void printWeapon(Weapon weapon){
        System.out.println("This weapon has the following bonuses: " + "\n"



        );
    }

}
