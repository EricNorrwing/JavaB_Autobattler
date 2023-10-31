package com.EricNorrwing.Autobattler.controllers;

import com.EricNorrwing.Autobattler.models.*;

public class GameController {

    // TODO Everything

    private Player player;
    private Enemy enemy;

    public GameController() {
        // Constructor
        player = new Player("Krillinator");
        enemy = generateEnemy();
        attack(player, enemy);
    }

    //Trades blows between player and enemy
    public void attack(Player player, Enemy enemy) {
        int damageDealt = player.getDamage();
        enemy.setHealth(enemy.getHealth()-damageDealt);
        System.out.println("You did " + damageDealt + " to " + enemy.getName() + " and it has "+ enemy.getHealth() + " hp left!");
        System.out.println(enemy.getHealth());
    }

    //Randomizes affixes/Suffixes and generates a name for the enemy
    public Enemy generateEnemy() {
        Enemy enemy = new Enemy((int) (Math.random() * 10 ), (int) (Math.random() * 10), (int) (Math.random() * 10));
        enemy.generateName();
        return enemy;
    }
}


