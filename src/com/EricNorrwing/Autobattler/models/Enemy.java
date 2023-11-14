package com.EricNorrwing.Autobattler.models;

import static com.EricNorrwing.Autobattler.models.Colors.*;

public class Enemy extends AUnit{

    //TODO generate list of affixes and suffixes, and their respective modifiers
    private int type;
    private int affix;
    private int suffix;

    private Weapon weapon = new Weapon();
    private Armor armor = new Armor();


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAffix() {
        return affix;
    }

    public void setAffix(int affix) {
        this.affix = affix;
    }

    public int getSuffix() {
        return suffix;
    }

    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public Armor getArmor() {
        return armor;
    }

    //Methods
    public Enemy(int type, int affix, int suffix) {
        this.type = type;
        this.affix = affix;
        this.suffix = suffix;
    }
    public void generateName(){
        String[] typeArray = {" Wraith", " Bandit", " Dragon"," Zombie", " Ghost", " Mimic"," Lich", " Wolf", " Witch"," Duelist"};
        String[] affixArray = {"Greater", "Juggernaught", "Agile","Quick", "Strong", "Weak","Small", "Keen", "Massive","Coward"};
        String[] suffixArray = {" the frail", " the Bright", " of massive loot"," of Brutality", " of Deception", " of Vengeance"," of Chaos", " of Laziness", " of Ineptitude"," the Fearless"};
        setName(affixArray[affix] + typeArray[type] + suffixArray[suffix]);
        // TODO This just needs to intialize a weapon to put into the attack function, it will be final after generation.
        weapon.generateEnemyStarterWeapon();
        armor.generateEnemyStarterArmor();
    }
    public void applyLevelModifer(Enemy enemy){
        double modifier = 1.1;
        enemy.setStrength((int) (enemy.getStrength() * Math.pow(modifier, enemy.getLevel())));
        enemy.setAgility((int) (enemy.getAgility() * Math.pow(modifier, enemy.getLevel())));
        enemy.setHealth((int) (enemy.getHealth() * Math.pow(modifier, enemy.getLevel())));
    }
    public void applyAffixModifiers(){
        switch (getAffix()) {
            case 0 -> {
                //Greater
                setHealth((int) (getHealth() * 1.2));
                setStrength((int) (getStrength() * 1.2));
                setExperience((int) (getExperience() * 1.5));
            }
            case 1 -> {
                //Juggernaught
                setHealth((int) (getHealth() * 1.8));
                setExperience((int) (getExperience() * 1.1));
            }
            case 2 -> {
                //Agile
                setAgility((getAgility() + 10));
                setExperience((int) (getExperience() * 1.1));
            }
            case 3 -> {
                //Quick
                setAgility((getAgility() + 5));
                setLethality((getLethality() + 10));
                setExperience((int) (getExperience() * 1.1));
            }
            case 4 -> {
                //Strong
                setStrength((int) (getStrength() * 1.5));
                setExperience((int) (getExperience() * 1.3));
            }
            case 5 ->
                //Weak
                    setStrength((int) (getStrength() * 0.5));
            case 6 -> {
                //Small
                setHealth((int) (getHealth() * 0.5));
                setAgility((getAgility() + 10));
            }
            case 7 -> {
                //Keen
                setLethality((getLethality() + 30));
                setExperience((int) (getExperience() * 1.2));
            }
            case 8 -> {
                //Massive
                setHealth((int) (getHealth() * 1.5));
                setStrength((int) (getStrength() * 1.5));
                setExperience((int) (getExperience() * 1.6));
            }
            case 9 -> {
            }
            //Coward
            //TODO Write code that prevents it from dealing damage to you when you flee
        }
    }
    public void applyTypeModifiers(){
        //Modifiers for type
        switch (getType()) {
            case 0 -> {
                //Wraith
                setAgility((getAgility() + 30));
                setHealth((int) (getHealth() * 0.5));
                setExperience((int) (getExperience() * 1.1));
            }
            case 1 -> {
                //Bandit
                setLethality((getLethality() + 20));
                setExperience((int) (getExperience() * 1.5));
            }
            case 2 -> {
                //Dragons are very powerful and should be avoided.
                setStrength((int) (getStrength() * 2.5));
                setHealth((int) (getHealth() * 2.5));
                setLethality((getLethality() + 100));
                setExperience((getExperience() * 5));
            }
            case 3 -> {
                //Zombies
                setHealth((int) (getHealth() * 0.75));
                setAgility((getAgility() - 100));
                setExperience((int) (getExperience() * 0.25));
            }
            case 4 -> {
                //Ghost
                setAgility((getAgility() + 40));
                setHealth((int) (getHealth() * 0.25));
                setLethality((getLethality() + 25));
                setExperience((int) (getExperience() * 1.1));
            }
            case 5 -> {
                //Mimic
                //TODO Always drop loot
                setHealth((int) (getHealth() * 1.5));
                setExperience((int) (getExperience() * 1.1));
            }
            case 6 -> {
                //Lich
                setHealth((int) (getHealth() * 0.5));
                setLethality((getLethality() + 25));
                setExperience((int) (getExperience() * 1.1));
            }
            case 7 -> {
                //Wolf
                setLethality((getLethality() + 30));
                setExperience((int) (getExperience() * 1.1));
            }
            case 8 -> {
            }
            //Witch
            //TODO Unsure
            case 9 -> {
                //Duelist
                setLethality((getLethality() + 25));
                setAgility((getAgility() + 15));
                setExperience((int) (getExperience() * 1.3));
            }

        }
    }
    public void applySuffixModifiers(){
        //Modifiers for suffixes
        switch (getSuffix()) {
            case 0 -> {
                //Frail
                setHealth((int) (getHealth() * 0.5));
                setExperience((int) (getExperience() * 0.75));
            }
            case 1 ->
                //The bright
                    setAgility((getAgility() + 5));
            case 2 -> {
            }
            //Massive loot
            //TODO Upgrades possible loot to 2 affixes or something? drops 2 items?
            case 3 -> {
                //Brutality
                setAgility((getAgility() + 5));
                setStrength((getStrength() + 20));
                setExperience((int) (getExperience() * 1.1));
            }
            case 4 -> {
                //of Deception
                setAgility((getAgility() + 10));
                setExperience((int) (getExperience() * 0.25));
            }
            case 5 -> {
                //of Vengeance
                setExperience((int) (getExperience() * 0.75));
            }
            case 6 -> {
                //of Chaos
                setLethality((getLethality() + 30));
                setAgility((getAgility() + 15));
                setExperience((int) (getExperience() * 1.5));
            }
            case 7 -> {
                //of Laziness
                setAgility((getAgility() - 50));
                setExperience((int) (getExperience() * 0.5));
            }
            case 8 -> {
                //of ineptiude
                setSkill((int) (getSkill() * 0.5));
                setAgility((getAgility() - 10));
                setAgility((getAgility() - 10));
            }
            case 9 -> {
                //the uneducated
                setExperience((0));
            }
        }
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
        return (int) Math.round(damage)-armor.getDamageReduction();
    }

    //Just has different colors for introduction to seperate them.
    @Override
    public void presentUnit() {
        System.out.println(
                YELLOW_UNDERLINED + getName() + " level " + getLevel() + " has the following statistics:" + RESET +
                        "\n"+  GREEN + getHealth() + RESET +  " health" +
                        "\n" + YELLOW + getAgility() +   "%" + RESET + " chance to dodge" +
                        "\n" + RED + getStrength() +   "%" + RESET + " increased damage" +
                        "\n" + BLUE + getLethality() + "%" + RESET + " chance to critically strike"
        );
    }
}
