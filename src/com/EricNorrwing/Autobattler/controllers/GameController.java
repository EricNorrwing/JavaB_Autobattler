package com.EricNorrwing.Autobattler.controllers;
import com.EricNorrwing.Autobattler.input.InputScanner;
import com.EricNorrwing.Autobattler.models.*;

import static com.EricNorrwing.Autobattler.models.Colors.*;


public class GameController  {

    InputScanner scanner = new InputScanner();

    //Randomizes an encounter that is either:
    //Presents a fight, find some gold, Find a weapon, find some armor, find a merchant, or find a healing potion.
    //The odds are 60%, 5%, 5%, 10%, 10%, 10%

    public void generateEncounter(Player player) throws InterruptedException {
        System.out.println("As benny travels further into the woods he finds... ");
        switch (randomizeEncounter()){
            case 1 -> {
                System.out.println("a foe!");
                Enemy enemy = generateEnemy(player);
                enemy.presentUnit();
                System.out.println("And benny only has " + RED + player.getHealth() + RESET + " hp left...");
                fightOrFlee(enemy, player);
            }
            case 2 -> {
                int coins = (int) (Math.random()*100) +1;
                System.out.println(" a " + YELLOW +  "trove of treasure!" + RESET + " Benny opens the trove and finds... " +
                        "\n" + " a pouch of coins! Benny pockets " + coins + " coins and moves on");
            }
            case 3 -> {
                Weapon weapon = new Weapon();
                weapon.generateWeapon();
                System.out.println("""
                        a trove of treasure! Benny opens the trove and finds...
                        a weapon! He examines it and sees that it is a
                        """);
                weapon.printItem(weapon);
                System.out.println("Do you wish to equip this weapon?");
                if (scanner.getYesNo().equals("y")){
                    player.equipWeapon(weapon);
                } else {
                    System.out.println("Benny discards the weapon, he does not recycle it");
                }
            }
            case 4 -> {
                Armor armor = new Armor();
                armor.generateArmor();
                System.out.println("""
                        a trove of treasure! Benny opens the trove and finds...
                        a piece of armor! He examines it and sees that it is a
                        """);
                armor.printItem(armor);
                System.out.println("Do you wish to equip this armor?");
                if (scanner.getYesNo().equals("y")){
                    player.equipArmor(armor);
                } else {
                    System.out.println("Benny discards the armor, he does not recycle it");
                }
            }
            case 5 -> {
                System.out.println("Benny rounds an turn and finds himself facing a racoon pulling a backpack. He takes a look at benny before clinking his purse and motioning him to come closer to take a look inside the bag ");
                switch ((int) (Math.random()*2)+1){
                    case 1 -> {
                        int cost = (int) (Math.random()*100)+50;
                        Weapon weapon = new Weapon();
                        weapon.generateWeapon();
                        System.out.println("The racoon showcases a weapon he found in his travels, and asks if you wish to buy this item (Y/N)");
                        System.out.println("Benny checks his pockets and sees that he has " + YELLOW + player.getMoney() + RESET + " coins");
                        weapon.printItem(weapon);
                        System.out.println("This item costs " + cost);
                        if (scanner.getYesNo().equals("y")) {
                            if ((player.getMoney() - cost) >= 0) {
                                System.out.println("Pleasure doing business says the raccoon in a perfect british accent, before magicly disapearing along with his bag");
                                player.equipWeapon(weapon);
                                player.setMoney(player.getMoney() - cost);
                                System.out.println("Benny checks his pockets and realizes he has " + player.getMoney() + " coins left");
                            } else {
                                System.out.println("You dont have enough money, begone adventurer! He says and dissapears with a poof");
                            }
                        }else {
                            System.out.println("Shame, my goods are of the highest quality it says before painstakingly pulling the bag. Benny is reasonably certain its all an act but does not investigate further");
                        }

                    }
                    case 2 -> {
                        int cost = (int) (Math.random() * 100) + 50;
                        Armor armor = new Armor();
                        armor.generateArmor();
                        System.out.println("The racoon showcases a piece of armor he found in his travels, and makes a gestures that indicate hes asking if you wish to buy this item (Y/N)");
                        System.out.println("Benny checks his pockets and sees that he has " + YELLOW + player.getMoney() + RESET + " coins");
                        armor.printItem(armor);
                        System.out.println("This item costs " + cost);
                        if (scanner.getYesNo().equals("y")) {
                            if ((player.getMoney() - cost) >= 0) {
                                System.out.println("Pleasure doing business says the raccoon in a perfect british accent, before magicly disapearing along with his bag");
                                player.equipArmor(armor);
                                player.setMoney(player.getMoney() - cost);
                                System.out.println("Benny checks his pockets and realizes he has " + YELLOW+ player.getMoney() + RESET + " coins left");
                            } else {
                                System.out.println("You dont have enough money, begone adventurer! He says and dissapears with a poof");
                            }
                        }else {
                            System.out.println("Shame, my goods are of the highest quality it says before painstakingly pulling the bag. Benny is reasonably certain its all an act but does not investigate further");
                        }
                    }
                }
            }
            case 6 -> {
                int health = (int) (100*Math.pow(1.2,(player.getLevel())));
                System.out.println("Benny finds a healing potion! and it heals him to " + health + " health");
                player.setHealth(health);
            }

        }
    }

    public void fightOrFlee(Enemy enemy,Player player) throws InterruptedException {
        System.out.println("Do you wish to fight this foe? Y/N, running away has a cost...");
        if (scanner.getYesNo().equals("y")){
            runFight(player, enemy);
            if (player.getHealth()> 0) {
                int experienceGained = (player.getExperience() + enemy.getExperience() * enemy.getLevel());
                System.out.println(player.getName() + " have defeated " + enemy.printEnemyName(enemy) + " " + enemy.getLevel() + " and have been rewarded " + experienceGained + " experience");
                System.out.println("and Benny also pockets " + YELLOW + enemy.getMoney() + RESET + " coins");
                player.addExperience(experienceGained,player, player.getWeapon(), player.getArmor());
                player.setMoney(player.getMoney()+enemy.getMoney());
                player.setTurnsPlayed(player.getTurnsPlayed()+1);
            } else {
                System.out.println(enemy.printEnemyName(enemy) + " have defeated " + player.printPlayerName(player) + " and the game is over");
                System.out.println("Benny did however defeat " + RED_BOLD + player.getTurnsPlayed() + RESET + " monsters before his demise");
                player.setPlayerIsDead(false);
            }
        } else{
            int takeDamage = enemy.getDamage(enemy.getWeapon(),enemy.getArmor());
            player.setHealth(player.getHealth()-takeDamage);
            System.out.println(enemy.getName() +  " did " + takeDamage + " to you as you fled....");
        }
    }

    //Randomizes affixes/Suffixes and generates a name for the enemy
    public Enemy generateEnemy(Player player) {
        Enemy enemy = new Enemy(((int) (Math.random() * 10)),((int) (Math.random() * 10)), ((int) (Math.random() * 10)));
        enemy.generateName();
        enemy.setBaseDamage(8);
        enemy.setLevel(player.getLevel()+(int) (Math.random()*3) +1);
        enemy.setExperience(10);
        enemy.setHealth(65);
        enemy.setMoney(20);

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
                Thread.sleep(200);
            } else {
                enemy.attack(enemy, player, enemy.getWeapon(), enemy.getArmor());
                Thread.sleep(200);
            }
            player.setPlayerTurn(!player.isPlayerTurn());
        } while (!AUnit.checkIfDead(player, enemy));
    }
    //Weighted randomizer for encounters to increase chance for fightin and reduce chance for other events
    public int randomizeEncounter(){
        int value = (int) (Math.random()*100)+1;
        if (value <= 60){
            return 1;
        } else if (value <= 70) {
            return 2;
        } else if (value <= 75) {
            return 3;
        } else if (value <= 80){
            return 4;
        } else if (value <= 90){
            return 5;
        }
        return 6;
    }
}


