package com.EricNorrwing.Autobattler.models;

import static com.EricNorrwing.Autobattler.models.Colors.*;
import static com.EricNorrwing.Autobattler.models.Colors.RESET;

public class Weapon implements IItem{
    //6th item in lists for generating default items, is not in randomizer
    private final String[] typeArray = {"Sword", "Staff", "Mace", "Greatsword", "Dagger"};
    private String name;
    private String affix;
    private String suffix;
    private String type;
    private int bonusDamage= 0;
    private int agilityModifier= 0;
    private int strengthModifier= 0;
    private int healthModifier= 0;
    private int skillModifier= 0;
    private int lethalityModifier= 0;

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

    public int getBonusDamage() {
        return bonusDamage;
    }
    public String getType(){
        return typeArray[(int) (Math.random()*5)];
    }

    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
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

    @Override
    public void initializeStats() {
            switch (this.affix) {
                case "Greater " -> setBonusDamage(getBonusDamage()+5);
                case "Lesser " -> setBonusDamage(getBonusDamage()+2);
                case "Massive " -> setBonusDamage(getBonusDamage()+10);
                case "Small " -> setBonusDamage(getBonusDamage()+1);
                case "Magical " -> setBonusDamage(getBonusDamage()+15);
            }

        switch (this.suffix) {
            case " of Strength" -> strengthModifier = strengthModifier + 5;
            case " of Agility" -> agilityModifier = agilityModifier + 5;
            case " of Skill" -> skillModifier = skillModifier + 5;
            case " of Health" -> healthModifier = healthModifier + 50;
            case " of Lethality" -> lethalityModifier = lethalityModifier + 5;
        }
        switch (this.type) {
            case "Sword" -> setBonusDamage(getBonusDamage()+10);
            case "Staff" -> {
                healthModifier = healthModifier-20;
                lethalityModifier = lethalityModifier+10;
            }
            case "Mace" -> {
                agilityModifier = agilityModifier-10;
                setBonusDamage(getBonusDamage()+10);
            }
            case "Greatsword" -> {
                healthModifier = healthModifier+25;
                setBonusDamage(getBonusDamage()+10);
                agilityModifier=agilityModifier-10;
            }
            case "Dagger" -> lethalityModifier = lethalityModifier+15;
        }
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


    public void generateWeapon(){
        resetStats();
        generateName();
        initializeStats();
    }
    public void generateStarterWeapon(){
        this.name = "Inverted Spoon that needs cleaning";
    }
    public void generateEnemyStarterWeapon(){
        this.name = "Unsharp claws of feebleness";
    }
    @Override
    public void printItem(IItem item) {
        System.out.println(PURPLE_BOLD + getName() + RESET + " has the following bonuses:"  +
                "\n"+  GREEN + getBonusDamage() + RESET +  " additional bonus damage" +
                "\n"+  GREEN + getHealthModifier() + RESET +  " health" +
                "\n" + YELLOW + getAgilityModifier() +   "%" + RESET + " increased chance to dodge" +
                "\n" + RED + getStrengthModifier() +   "%" + RESET + " increased damage" +
                "\n" + BLUE + getStrengthModifier() + "%" + RESET + " chance to critically strike" +
                "\n" + BLUE + getSkillModifier() + "%" + RESET + " increased chance to hit"
        );
    }

    @Override
    public void resetStats() {
        setBonusDamage(0);
        setAgilityModifier(0);
        setHealthModifier(0);
        setSkillModifier(0);
        setStrengthModifier(0);
        setLethalityModifier(0);
    }


}
