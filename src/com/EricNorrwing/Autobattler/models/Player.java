package com.EricNorrwing.Autobattler.models;


import static com.EricNorrwing.Autobattler.models.Colors.*;
import static com.EricNorrwing.Autobattler.models.Colors.RESET;

public class Player extends AUnit{
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
        return super.getAgility()+weapon.getAgilityModifier()+armor.getAgilityModifier();
    }
    @Override
    public int getStrength() {
        return super.getStrength()+weapon.getStrengthModifier()+armor.getStrengthModifier();
    }

    @Override
    public int getSkill() {
        return super.getSkill()+weapon.getSkillModifier()+armor.getSkillModifier();
    }
    @Override
    public int getLethality() {
        return super.getLethality()+weapon.getLethalityModifier()+armor.getLethalityModifier();
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
    public void equipArmor(Armor armor){
        this.armor = armor;
        setHealth(getHealth()+armor.getHealthModifier());
    }
    //Adds the bonus hp of the new weapon to the player, this technically heals/damages the player. but it works out gameplay wise
    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
        setHealth(getHealth()+weapon.getHealthModifier());
    }

    @Override
    public String toString() {
        return getName();
    }
    @Override
    public int getDamage(Weapon weapon,Armor armor){
        int minDamage = this.getBaseDamage()-5;
        int maxDamage = this.getBaseDamage()+5;
        double damageModifier = 1.0 + getStrength() / 100.0;
        double damage = (Math.random() * (maxDamage - minDamage) + minDamage) * damageModifier;
        damage = damage + weapon.getBonusDamage();
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
                        "\n" + BLUE + (getLethality()+weapon.getLethalityModifier()+armor.getLethalityModifier()) + "%" + RESET + " chance to critically strike" +
                        "\n" + CYAN + (getSkill()+weapon.getSkillModifier()+armor.getSkillModifier()) + "%" + RESET + " chance to hit" +
                        "\n" + "and deals " + RED + weapon.getBonusDamage() + RESET + " bonus damage" +
                        "\n" + "and takes " + PURPLE + armor.getDamageReduction() + RESET + " less damage per hit"
        );

    }

}
