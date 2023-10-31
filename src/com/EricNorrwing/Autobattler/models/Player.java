package com.EricNorrwing.Autobattler.models;


public class Player extends AUnit{

    public Player(String name){
        setName(name);
    }

    @Override
    public String toString() {
        return getName();
    }




    //TODO Add origin classes with default modifiers
    //private String race;
    //private String origin;

    //No setter for name, its Can add later if needed (It should remain unchanged)

}
