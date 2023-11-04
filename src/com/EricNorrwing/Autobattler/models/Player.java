package com.EricNorrwing.Autobattler.models;


import static com.EricNorrwing.Autobattler.models.Colors.*;
import static com.EricNorrwing.Autobattler.models.Colors.RESET;

public class Player extends AUnit{
    public static final String PLAYER_COLOR = "BLUE";
    public static final String RESET_COLOR = "RESET";

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

    //TODO fix
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
