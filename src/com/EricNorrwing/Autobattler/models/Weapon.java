package com.EricNorrwing.Autobattler.models;

public class Weapon implements IItem{
    private String[] typeArray = {"Sword", "Staff", "Mace", "Greatsword", "Dagger"};
    private String name;
    private String affix;
    private String suffix;
    private String type;
    private int bonusDamage;
    private int agilityModifier;
    private int strengthModifier;
    private int healthModifier;
    private int skillModifier;
    private int lethalityModifier;

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
                case "Greater " -> setBonusDamage(getBonusDamage()+5);
                case "Lesser " -> setBonusDamage(getBonusDamage()+2);
                case "Massive " -> setBonusDamage(getBonusDamage()+10);
                case "Small " -> setBonusDamage(getBonusDamage()+1);
                case "Magical " -> setBonusDamage(getBonusDamage()+15);
            }

        switch (this.suffix) {
            case " of Strength" -> strengthModifier = 5;
            case " of Agility" -> agilityModifier = 5;
            case " of Skill" -> skillModifier = 5;
            case " of Health" -> healthModifier = 50;
            case " of Lethality" -> lethalityModifier = 5;
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
    public void generateWeapon(Player player){

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
