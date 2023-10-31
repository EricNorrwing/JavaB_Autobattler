package com.EricNorrwing.Autobattler.controllers;

import com.EricNorrwing.Autobattler.models.*;

public class GameController {

    // TODO Everything


    Player player = new Player("Krillinator");
    Enemy enemy = generateEnemy();
    attack(player, enemy);

    public void attack(Player player,Enemy enemy){
        System.out.println(player);
    }

    public Enemy generateEnemy(){
        return new Enemy((int) (Math.random()*10+1), (int) (Math.random()*10+1), (int) (Math.random()*10+1));
    }


}
