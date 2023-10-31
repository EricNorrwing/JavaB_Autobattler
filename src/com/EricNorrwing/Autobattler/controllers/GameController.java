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
        int health = enemy.getHealth();


        int damage = enemy.getHealth()-player.getBaseDamage();
        enemy.setHealth(enemy.getHealth()-player.getBaseDamage());
        System.out.println("You did " + damage + " to " + enemy.getName());
        System.out.println(enemy.getHealth());
    }

    public Enemy generateEnemy() {
        return new Enemy((int) (Math.random() * 10 + 1), (int) (Math.random() * 10 + 1), (int) (Math.random() * 10 + 1));
    }
}


