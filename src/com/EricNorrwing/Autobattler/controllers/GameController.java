package com.EricNorrwing.Autobattler.controllers;
import com.EricNorrwing.Autobattler.input.InputScanner;
import com.EricNorrwing.Autobattler.models.*;
import com.EricNorrwing.Autobattler.viewers.GameViewer;


public class GameController  {

    // TODO Everything

    private Player player;
    private Enemy enemy;
    private boolean gameIsRunning = true;
    GameViewer GV = new GameViewer();


    public void runGame() throws InterruptedException {
        player = new Player("Benny");
        //Inserts player to determine the strength of opponents based on player strength
        enemy = generateEnemy(player);
        //TODO Remove debugstatements
        //Initialize starting items
        Weapon weapon = new Weapon();
        Armor armor = new Armor();
        armor.generateStartingArmor();
        weapon.generateStarterWeapon();

        do{
            GV.gameplayLoopSwitch();
        }while (gameIsRunning);
        //Fight until one player dies.
        do {
            runFight(player, enemy);
        }while(!AUnit.checkIfDead(player, enemy));

        //Previous loop breaks if anyone drops below 1 health, now it just runs the next part if the player is alive.
        //May rewrite if I have spare time
        if (player.getHealth()> 0) {
            System.out.println(player.getName() + " have defeated " + enemy.printEnemyName(enemy) + " " + enemy.getLevel() + " and have been rewarded " + (player.getExperience() + enemy.getExperience() * enemy.getLevel()) + " experience");
            player.addExperience(enemy.getExperience());
        } else {
            System.out.println(enemy.printEnemyName(enemy) + " have defeated " + player.printPlayerName(player) + " and the game is over");
        }

    }



    //Randomizes affixes/Suffixes and generates a name for the enemy
    public Enemy generateEnemy(Player player) {
        Enemy enemy = new Enemy(((int) (Math.random() * 10)),((int) (Math.random() * 10)), ((int) (Math.random() * 10)));
        enemy.generateName();
        enemy.setLevel(player.getLevel()+(int) (Math.random()*3) +1);
        enemy.setExperience(50);

        //Buffs the enemies with 20% per level they randomly spawned on.
        enemy.applyLevelModifer(enemy);
        enemy.applyTypeModifiers();
        enemy.applyAffixModifiers();
        enemy.applySuffixModifiers();
        //TODO REMOVE DEBUG STATEMENT
        enemy.presentUnit();
        player.presentUnit();
        return enemy;
    }

    //Trades blows and turns between player and enemy until one dies
    // TODO Change delays
    public void runFight(Player player, Enemy enemy) throws InterruptedException {
        if (player.isPlayerTurn()) {
            player.attack(player, enemy,player.getWeapon(), player.getArmor());
            //Slows down the output to make it more intense!
            Thread.sleep(1);
        } else {
            enemy.attack(enemy, player, enemy.getWeapon(), enemy.getArmor());
            Thread.sleep(1);
        }
        player.setPlayerTurn(!player.isPlayerTurn());
    }



}


