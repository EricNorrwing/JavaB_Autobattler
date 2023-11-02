package com.EricNorrwing.Autobattler.models;


public class Player extends AUnit{

    //Constructor
    public Player(String name){
        setName(name);
    }
    boolean playerTurn = true;

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




    //TODO Add origin classes with default modifiers
    //private String race;
    //private String origin;

    //No setter for name, its Can add later if needed (It should remain unchanged)

}
