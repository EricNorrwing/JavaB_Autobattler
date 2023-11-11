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
    public int getBaseDamage() {
        return baseDamage;
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

    public void addExperience(int experience) {
        setExperience(getExperience()+experience);
        while(getExperience()>=100) {
            setExperience(getExperience()-100);
            addLevel(1);
            System.out.println("You have leveled up! new level is: " + getLevel());
        }
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void addLevel(int level) {
        //Updates all values by 1.2 when you levelup
        setStrength((int)(getStrength() * Math.pow(1.2, level)));
        setAgility((int)(getAgility() * Math.pow(1.2, level)));
        setHealth((int)(getHealth() * Math.pow(1.2, level)));
        setLevel(getLevel()+level);
    }

    //Damage dealt is always basedamage +-5, it can however be modified by equipment and multipliers. The +-5 is static.
    //This is technically not a getter, since it does calculations?
    public int getDamage(Weapon weapon, Armor armor) {
        int minDamage = baseDamage-5;
        int maxDamage = baseDamage+5;
        double damageModifier = 1.0 + (double) strength / 100.0;
        double damage = ((Math.random() * (maxDamage - minDamage) + minDamage) * damageModifier) + weapon.getBonusDamage() - armor.getDamageReduction();
        //ensures you dont heal the enemies if you dealt negative damage
        damage = Math.max(0,damage);
        return (int) Math.round(damage);
    }


    // Methods here

    public abstract void presentUnit();

    public static boolean hitLands(AUnit attacker, AUnit target){
        return (int) (Math.random() * 100) + 1 <= (attacker.getSkill() - target.getAgility());
    }
    //Trades blows between Units
    public void attack(AUnit attacker, AUnit target, Weapon weapon, Armor armor) {
        //Theese 2 rows were pulled from chatGPT, it called it "ternary operator", will be using this more hopefully
        String attackerColor = (attacker instanceof Player) ? Colors.PLAYER_COLOR : Colors.ENEMY_COLOR;
        String targetColor = (target instanceof Player) ? Colors.PLAYER_COLOR : Colors.ENEMY_COLOR;

        if (AUnit.hitLands(attacker, target)) {
            int damageDealt = attacker.getDamage(weapon, armor);

                if (((int)(Math.random() * (100)+attacker.getLethality()+1)) >= 100){
                    damageDealt = (damageDealt*2);
                    target.setHealth(target.getHealth() - damageDealt);
                    System.out.println(attackerColor + attacker.getName() + RESET_COLOR + " dealt a " +
                            RED_BOLD + "CRITICAL STRIKE " + "for " + damageDealt + RESET + " damage to " +
                            targetColor + target.getName() + RESET_COLOR + " and it has " +
                            GREEN + target.getHealth() + RESET + " hp left!");

                } else{
                    target.setHealth(target.getHealth() - damageDealt);
                    System.out.println(attackerColor + attacker.getName() + RESET_COLOR + " dealt " +
                            RED + damageDealt + RESET + " damage to " + targetColor + target.getName() + RESET_COLOR +
                            " and it has " + GREEN + target.getHealth() + RESET + " hp left!");
                }
        } else {
            System.out.println(attackerColor + attacker.getName() + RESET_COLOR + " attacked, but the attack was " + BLUE_BOLD + "DODGED " + RESET + "by " + targetColor + target.getName() + RESET_COLOR + "!");

        }
    }

    //Checks if anyone died to stop the sequence
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

