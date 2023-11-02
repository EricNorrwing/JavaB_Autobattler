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

        for (int i = 0; i < 30; i++){
            do {
                AUnit.attack(player, enemy);
                Thread.sleep(500);
                AUnit.attack(enemy,player);
            }while(!AUnit.checkIfDead(enemy));
            System.out.println(RED_BOLD + "You have defeated " + enemy.getName() + RESET);
            player.setExperience(player.getExperience()+10*enemy.getLevel());

        }
    }



    //Randomizes affixes/Suffixes and generates a name for the enemy
    public Enemy generateEnemy() {
        Enemy enemy = new Enemy((int) (Math.random() * 10 ), (int) (Math.random() * 10), (int) (Math.random() * 10));
        enemy.generateName();
        return enemy;
    }

}


