package com.EricNorrwing.Autobattler.models;

import static com.EricNorrwing.Autobattler.models.Colors.*;

public abstract class AUnit {
    private String name;
    private int strength = 10;
    private int agility = 10;
    private int skill = 100;
    private int lethality = 5;
    private int health = 100;
    private int experience = 0;
    private int level = 1;
    private int baseDamage = 10;

    //Empty constructor
    public AUnit(){
    }

    public int getLethality() {
        return lethality;
    }

    public void setLethality(int lethality) {
        this.lethality = lethality;
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
            System.out.println("You have leveled up! new level is: " + getLevel());
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
        boolean crit = ((int)(Math.random() * (100)+getLethality()+1)) >= 100;
        if (crit){
            return ((int)(Math.random() * (maxDamage-minDamage)) + minDamage)*(strength/10)*2;
        }else {
            return ((int)(Math.random() * (maxDamage-minDamage)) + minDamage)*(strength/10);
        }

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
        //Theese 2 rows were pulled from chatGPT, it called it "ternary operator", will be using this more hopefully
        String attackerColor = (attacker instanceof Player) ? Colors.PLAYER_COLOR : Colors.ENEMY_COLOR;
        String targetColor = (target instanceof Player) ? Colors.PLAYER_COLOR : Colors.ENEMY_COLOR;

        if (AUnit.hitLands(attacker, target)) {
            int damageDealt = attacker.getDamage();
            target.setHealth(target.getHealth() - damageDealt);
            System.out.println(attackerColor + attacker.getName() + RESET_COLOR + " did " + RED + damageDealt + RESET + " damage to " + targetColor + target.getName() + RESET_COLOR + " and it has " + GREEN + target.getHealth() + RESET + " hp left!");
        } else {
            System.out.println(targetColor + target.getName() + RESET_COLOR + " " + BLUE + "DODGED" + RESET + " the attack from " + attackerColor + attacker.getName() + RESET_COLOR + "!");
        }
    }

    public static boolean checkIfDead(AUnit attacker, AUnit target){
        return attacker.getHealth() <= 0 || target.getHealth()<= 0;
    }

    //Color prints for non variable methods
    public String printPlayerName(AUnit player){
        return CYAN + player.getName() + RESET;
    }

    public String printEnemyName(AUnit enemy){
        return RED + enemy.getName() + RESET;
    }
}

