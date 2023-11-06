package com.EricNorrwing.Autobattler.models;

public class Weapon implements IItem{
    String[] typeArray = {"Sword", "Staff", "Mace", "Greatsword", "Dagger"};
    private String name;
    private String affix;
    private String suffix;
    private String type;
    int bonusDamage;

    public int getBonusDamage() {
        return bonusDamage;
    }
    public String getType(){
        return typeArray[(int) (Math.random()*5)];
    }

    public void setBonusDamage(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void generateName() {
        String name = getAffix() + getType() + getSuffix();
        System.out.println(name);
    }

    @Override
    public void initializeStats(AUnit unit) {
            switch (getAffix()) {
                case "Greater" -> setBonusDamage(getBonusDamage()+5);
                case "Lesser " -> setBonusDamage(getBonusDamage()+2);
                case "Massive " -> setBonusDamage(getBonusDamage()+10);
                case "Small " -> setBonusDamage(getBonusDamage()+1);
                case "Magical " -> setBonusDamage(getBonusDamage()+15);
            }

        switch (getSuffix()) {
            case " of Strength" -> unit.setStrength(+5);
            case " of Agility" -> unit.setAgility(+5);
            case " of Skill" -> unit.setSkill(+5);
            case " of Health" -> unit.setHealth(+50);
            case " of Lethality" -> unit.setLethality(+5);
        }
        switch (getType()) {
            case "Sword" -> setBonusDamage(getBonusDamage()+10);
            case "Staff" -> {
                unit.setHealth(unit.getHealth()-20);
                unit.setLethality(unit.getLethality()+10);
            }
            case "Mace" -> {
                unit.setAgility(unit.getAgility()-10);
                setBonusDamage(getBonusDamage()+10);
            }
            case "Greatsword" -> {
                unit.setHealth(unit.getHealth()+25);
                setBonusDamage(getBonusDamage()+10);
                unit.setAgility(unit.getAgility()-10);
            }
            case "Dagger" -> unit.setLethality(unit.getLethality()+15);
        }
    }

    public void printWeapon(Weapon weapon){
        System.out.println("This weapon has the following bonuses: " + "\n"



        );
    }

}
