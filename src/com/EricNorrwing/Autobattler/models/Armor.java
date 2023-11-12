package com.EricNorrwing.Autobattler.models;

import static com.EricNorrwing.Autobattler.models.Colors.*;

public class Armor implements IItem{
    //6th item in lists for generating default items, is not in randomizer
    private final String[] typeArray = {"Leather", "Chainmail", "Platemail", "Robe", "Enchanted platearmor", "t-shirt"};
    private String name;
    private String affix;
    private String suffix;
    private String type;
    private int damageReduction = 0;
    private int agilityModifier = 0;
    private int strengthModifier= 0;
    private int healthModifier= 0;
    private int skillModifier= 0;
    private int lethalityModifier= 0;

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
            case "Leather armor"-> agilityModifier = agilityModifier + 5;
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
            case "Enchanted Platearmor" -> {
                damageReduction = damageReduction+10;
            }
        }
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public void setAgilityModifier(int agilityModifier) {
        this.agilityModifier = agilityModifier;
    }

    public void setStrengthModifier(int strengthModifier) {
        this.strengthModifier = strengthModifier;
    }

    public void setHealthModifier(int healthModifier) {
        this.healthModifier = healthModifier;
    }

    public void setSkillModifier(int skillModifier) {
        this.skillModifier = skillModifier;
    }

    public void setLethalityModifier(int lethalityModifier) {
        this.lethalityModifier = lethalityModifier;
    }

    @Override
    public void printItem(IItem item) {
        System.out.println(PURPLE_BOLD + getName() + RESET + " has the following bonuses:"  +
                "\n"+  GREEN + getDamageReduction() + RESET +  " damage reduction" +
                "\n"+  GREEN + getHealthModifier() + RESET +  " health" +
                "\n" + YELLOW + getAgilityModifier() +   "%" + RESET + " chance to dodge" +
                "\n" + RED + getStrengthModifier() +   "%" + RESET + " increased damage" +
                "\n" + BLUE + getStrengthModifier() + "%" + RESET + " chance to critically strike" +
                "\n" + BLUE + getSkillModifier() + "%" + RESET + " increased chance to hit"


        );
    }

    @Override
    public void resetStats() {
        setDamageReduction(0);
        setAgilityModifier(0);
        setHealthModifier(0);
        setSkillModifier(0);
        setStrengthModifier(0);
        setLethalityModifier(0);
    }

    public void generateArmor(){
        resetStats();
        generateName();
        initializeStats();
        System.out.println(getName());
    }
    public void generateStartingArmor(){
        this.name = "Old t-shirt questionable origin";
        System.out.println(getName());
    }
    public void generateEnemyStarterArmor(){
        this.name = "Thin hide of snowflakes";
        System.out.println(getName());
    }


}
