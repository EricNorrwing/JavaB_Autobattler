package com.EricNorrwing.Autobattler.controllers;

import com.EricNorrwing.Autobattler.models.AUnit;
import com.EricNorrwing.Autobattler.models.Enemy;
import com.EricNorrwing.Autobattler.models.Player;

public class GameController {

    // TODO Everything

    Player player = new Player("Krillinator");
    generateEnemy();


    public void runTurn(AUnit player,AUnit enemy){


    }

    public void generateEnemy(){
        Enemy enemy = new Enemy((Math.random()*10+1),(Math.random()*10+1),(Math.random()*10+1));
    }
}
