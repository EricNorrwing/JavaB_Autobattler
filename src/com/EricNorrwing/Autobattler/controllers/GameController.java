package com.EricNorrwing.Autobattler.controllers;
import com.EricNorrwing.Autobattler.models.*;



public class GameController  {

    // TODO Everything

    private Player player;
    private Enemy enemy;
    private Weapon weapon = new Weapon();
    private Armor armor = new Armor();
    // TODO Armor armor = new Armor();

    public void runGame() throws InterruptedException {
        player = new Player("Benny");
        weapon.generateWeapon(player);
        armor.generateArmor(player);
        //Inserts player to determine the strength of opponents based on player strength
        enemy = generateEnemy(player);
        do {
            runFight(player, enemy);
        }while(!AUnit.checkIfDead(player, enemy));

        //Previous loop breaks if anyone drops below 0 health, now it just runs the next part if the player is alive.
        //May rewrite if i have spare time
        if (player.getHealth()>= 0) {
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
            player.attack(player, enemy, weapon, armor);
            //Slows down the output to make it more intense!
            Thread.sleep(1);
        } else {
            enemy.attack(enemy, player, weapon,armor);
            Thread.sleep(1);
        }
        player.setPlayerTurn(!player.isPlayerTurn());
    }



}


