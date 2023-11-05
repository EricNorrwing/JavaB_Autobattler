package com.EricNorrwing.Autobattler.models;

public class Weapon implements IItem{
    String name;
    String affix;
    String suffix;
    String type = "Weapon";
    @Override
    public void generateName() {
        String name = getAffix() + "Weapon" + getSuffix();
        System.out.println(name);
    }

    @Override
    public void initializeStats() {
        public void applyAffixModifiers(){
            switch (getAffix()) {
                case 0 -> {
                    //Greater
                    setHealth((int) (getHealth() * 1.2));
                    setStrength((int) (getStrength() * 1.2));
                }
                case 1 ->
                    //Juggernaught
                        setHealth((int) (getHealth() * 1.8));
                case 2 ->
                    //Agile
                        setAgility((getAgility() + 10));
                case 3 -> {
                    //Quick
                    setAgility((getAgility() + 5));
                    setLethality((getLethality() + 10));
                }
                case 4 ->
                    //Strong
                        setStrength((int) (getStrength() * 1.5));
                case 5 ->
                    //Weak
                        setStrength((int) (getStrength() * 0.5));
                case 6 -> {
                    //Small
                    setHealth((int) (getHealth() * 0.5));
                    setAgility((getAgility() + 10));
                }
                case 7 ->
                    //Keen
                        setLethality((getLethality() + 30));
                case 8 -> {
                    //Massive
                    setHealth((int) (getHealth() * 1.5));
                    setStrength((int) (getStrength() * 1.5));
                }
                case 9 -> {
                }
                //Coward
                //TODO Write code that prevents it from dealing damage to you when you flee
                default -> {
                }
                //TODO Do sometehing
            }
        }

    }
}
