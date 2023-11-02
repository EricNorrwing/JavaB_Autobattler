package com.EricNorrwing.Autobattler.controllers;
import com.EricNorrwing.Autobattler.models.*;

import static com.EricNorrwing.Autobattler.models.Colors.*;


public class GameController  {

    // TODO Everything

    private Player player;
    private Enemy enemy;

    public GameController() throws InterruptedException {
        // Constructor

        player = new Player("Krillinator");
        enemy = generateEnemy();
        do {
            runFight(player, enemy);
            }while(!AUnit.checkIfDead(player, enemy));

        if (player.getHealth()>= 0) {
            System.out.println("You have defeated " + printEnemyName() + " and have been rewarded " + (player.getExperience() + 105 * enemy.getLevel()) + " experience");
            player.setExperience((player.getExperience() + 10 * enemy.getLevel()));
        } else {
            System.out.println(printEnemyName() + " have defeated " + printPlayerName() + " and the game is over");
        }


    }



    //Randomizes affixes/Suffixes and generates a name for the enemy
    public Enemy generateEnemy() {
        Enemy enemy = new Enemy((int) (Math.random() * 10 ), (int) (Math.random() * 10), (int) (Math.random() * 10));
        enemy.generateName();
        return enemy;
    }

    //Trades blows and turns between player and enemy
    // TODO Change delays
    public void runFight(Player player, Enemy enemy) throws InterruptedException {
        if (player.isPlayerTurn()) {
            AUnit.attack(player, enemy);
            Thread.sleep(1);
            player.setPlayerTurn(!player.isPlayerTurn());
        } else {
            AUnit.attack(enemy, player);
            Thread.sleep(1);
            player.setPlayerTurn(!player.isPlayerTurn());
        }
    }
    public String printPlayerName(Player ){
        return CYAN + player.getName() + RESET;
    }

    public String printEnemyName(){
        return RED + player.getName() + RESET;
    }

}


