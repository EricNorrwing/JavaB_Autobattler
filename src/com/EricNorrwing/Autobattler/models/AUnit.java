package com.EricNorrwing.Autobattler.models;

import static com.EricNorrwing.Autobattler.models.Colors.*;

public abstract class AUnit {
    private String name;
    private int strength = 10;
    private int agility = 10;
    private int skill = 100;
    private int health = 100;
    private int experience = 0;
    private int level = 1;
    private int baseDamage = 10;

    //Empty constructor
    public AUnit(){
    }
    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        if (this.experience > 100){
            level++;
            System.out.println("You have leveled up! new level is: " + this.level);
        }
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        int minDamage = baseDamage-5;
        int maxDamage = baseDamage+5;
        return ((int)(Math.random() * (maxDamage-minDamage)) + minDamage)*(strength/10);
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    // Methods here
    public static boolean hitLands(AUnit attacker, AUnit target){
        return (int) (Math.random() * 100) + 1 < (attacker.getSkill() - target.getAgility());
    }
    //Trades blows between player and enemy
    public static void attack(AUnit attacker, AUnit target) {
        if (AUnit.hitLands(attacker, target)) {
            int damageDealt = attacker.getDamage();
            target.setHealth(target.getHealth() - damageDealt);
            System.out.println(attacker.getName() + " did " + RED + damageDealt + RESET + " damage to " + target.getName() + " and it has " + GREEN + target.getHealth() + RESET + " hp left!");
        } else {
            System.out.println(target.getName()+ BLUE + " dodged the attack from " + RESET + attacker.getName() + "!");
        }
    }

    public static boolean checkIfDead(AUnit attacker, AUnit target){
        return attacker.getHealth() <= 0 || target.getHealth()<= 0;
    }

}
