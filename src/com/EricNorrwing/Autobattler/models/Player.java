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
    Weapon weapon;

    //Constructor
    public Player(String name){
        setName(name);
    }


    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    @Override
    public String toString() {
        return getName();
    }
    @Override
    public int getDamage(Weapon weapon,Armor armor){
        tempAgility = this.getAgility()+weapon.getAgilityModifier()+armor.getAgilityModifier();




        int minDamage = this.getBaseDamage()-5;
        int maxDamage = this.getBaseDamage()+5;
        double damageModifier = 1.0 + (double) this.getStrength() / 100.0;
        double damage = (Math.random() * (maxDamage - minDamage) + minDamage) * damageModifier;
        return (int) Math.round(damage);
    }

    //Just has different colors for introduction to seperate them.
    @Override
    public void presentUnit() {
        System.out.println(
                CYAN_UNDERLINED + getName() + " has the following statistics:" + RESET +
                        "\n"+  GREEN + getHealth() + RESET +  " health" +
                        "\n" + YELLOW + getAgility() +   "%" + RESET + " chance to dodge" +
                        "\n" + RED + getStrength() +   "%" + RESET + " increased damage" +
                        "\n" + BLUE + getLethality() + "%" + RESET + " chance to critically strike"
        );

    }


    //TODO Add origin classes with default modifiers
    //private String race;
    //private String origin;

    //No setter for name, its Can add later if needed (It should remain unchanged)

}
