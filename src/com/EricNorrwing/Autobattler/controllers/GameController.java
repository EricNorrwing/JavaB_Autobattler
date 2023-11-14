package com.EricNorrwing.Autobattler.controllers;
import com.EricNorrwing.Autobattler.input.InputScanner;
import com.EricNorrwing.Autobattler.models.*;
import static com.EricNorrwing.Autobattler.models.Colors.*;


public class GameController  {

    // TODO Everything

    private Player player = new Player("Benny");
    private Enemy enemy;
    private boolean gameIsRunning = true;
    InputScanner scanner = new InputScanner();


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


        //TODO REMOVE Fight until one player dies.
        /*do {
            runFight(player, enemy);
        }while(!AUnit.checkIfDead(player, enemy));
        */
        //Previous loop breaks if anyone drops below 1 health, now it just runs the next part if the player is alive.
        //May rewrite if I have spare time
        if (player.getHealth()> 0) {
            System.out.println(player.getName() + " have defeated " + enemy.printEnemyName(enemy) + " " + enemy.getLevel() + " and have been rewarded " + (player.getExperience() + enemy.getExperience() * enemy.getLevel()) + " experience");
            player.addExperience(enemy.getExperience());
        } else {
            System.out.println(enemy.printEnemyName(enemy) + " have defeated " + player.printPlayerName(player) + " and the game is over");
        }

    }

    public void generateEncounter() throws InterruptedException {
        // TODO ADD TO STATEMENT (int) (Math.random()*3)+1
        switch (1){
            case 1 -> {
                System.out.println("As benny travels further into the woods he finds ... ");
                Enemy enemy = generateEnemy(player);
                enemy.presentUnit();
                System.out.println("And benny only has " + RED + player.getHealth() + RESET + " hp left...");
                fightOrFlee(enemy, player);
            }
            case 2 -> player.presentUnit();
            default -> {
                System.out.println("End of generate encounter");
            }
        }
    }

    public void fightOrFlee(Enemy enemy,Player player) throws InterruptedException {
        System.out.println("Do you wish to fight this foe? Y/N, running away has a cost...");
        if (scanner.getYesNo().equals("y")){
            runFight(player, enemy);
        }
    }

    //Randomizes affixes/Suffixes and generates a name for the enemy
    public Enemy generateEnemy(Player player) {
        Enemy enemy = new Enemy(((int) (Math.random() * 10)),((int) (Math.random() * 10)), ((int) (Math.random() * 10)));
        enemy.generateName();
        enemy.setLevel(player.getLevel()+(int) (Math.random()*3) +1);
        enemy.setExperience(50);
        enemy.setMoney(50);

        //Buffs the enemies with 20% per level they randomly spawned on and applies modifiers based off randomized names
        enemy.applyLevelModifer(enemy);
        enemy.applyTypeModifiers();
        enemy.applyAffixModifiers();
        enemy.applySuffixModifiers();
        return enemy;
    }

    //Trades blows and turns between player and enemy until one dies
    // TODO Change delays
    public void runFight(Player player, Enemy enemy) throws InterruptedException {
        do {
            if (player.isPlayerTurn()) {
                player.attack(player, enemy, player.getWeapon(), player.getArmor());
                //Slows down the output to make it more intense!
                Thread.sleep(1);
            } else {
                enemy.attack(enemy, player, enemy.getWeapon(), enemy.getArmor());
                Thread.sleep(1);
            }
            player.setPlayerTurn(!player.isPlayerTurn());
        } while (!AUnit.checkIfDead(player, enemy));
    }
}


