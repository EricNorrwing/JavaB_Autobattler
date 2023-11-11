package com.EricNorrwing.Autobattler.models;


import static com.EricNorrwing.Autobattler.models.Colors.*;
import static com.EricNorrwing.Autobattler.models.Colors.RESET;

public class Player extends AUnit{
    private int tempStrength;
    private int tempAgility;
    private int tempHealth;
    private int tempSkill;
    private int tempLethality;
    private boolean playerTurn = true;
    private Weapon weapon = new Weapon();
    private Armor armor = new Armor();

    //Constructor
    public Player(String name){
        setName(name);
        //initializes the starter items
        weapon.generateStarterWeapon();
        armor.generateStartingArmor();
    }
    //Overriding getters to account for the bonuses of the weapons
    //TODO CHECK IF THIS WORKS

    @Override
    public int getAgility() {
        return super.getAgility()+tempAgility;
    }
    @Override
    public int getStrength() {
        return super.getStrength()+tempStrength;
    }
    @Override
    public int getHealth() {
        return super.getHealth()+tempHealth;
    }
    @Override
    public int getSkill() {
        return super.getSkill()+tempSkill;
    }
    @Override
    public int getLethality() {
        return super.getLethality()+tempLethality;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public Armor getArmor() {
        return armor;
    }

    @Override
    public String toString() {
        return getName();
    }
    @Override
    public int getDamage(Weapon weapon,Armor armor){
        System.out.println(armor.getDamageReduction());
        int minDamage = this.getBaseDamage()-5;
        int maxDamage = this.getBaseDamage()+5;
        double damageModifier = 1.0 + (double) tempStrength / 100.0;
        double damage = (Math.random() * (maxDamage - minDamage) + minDamage) * damageModifier;
        //ensures you dont heal the enemies if you dealt negative damage
        damage = Math.max(0,damage);
        return (int) Math.round(damage);
    }

    //Just has different colors for introduction to seperate them.
    @Override
    public void presentUnit() {
        System.out.println(
                CYAN_UNDERLINED + getName() + " has the following statistics:" + RESET +
                        "\n"+  GREEN + (getHealth()+weapon.getHealthModifier()+armor.getHealthModifier()) + RESET +  " health" +
                        "\n" + YELLOW + (getAgility()+weapon.getAgilityModifier()+armor.getAgilityModifier()) +   "%" + RESET + " chance to dodge" +
                        "\n" + RED + (getStrength()+weapon.getStrengthModifier()+armor.getStrengthModifier()) +   "%" + RESET + " increased damage" +
                        "\n" + BLUE + (getLethality()+weapon.getLethalityModifier()+armor.getLethalityModifier()) + "%" + RESET + " chance to critically strike"
        );

    }


    //TODO Add origin classes with default modifiers
    //private String race;
    //private String origin;

    //No setter for name, its Can add later if needed (It should remain unchanged)

}
