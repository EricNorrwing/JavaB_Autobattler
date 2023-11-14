package com.EricNorrwing.Autobattler.viewers;

import com.EricNorrwing.Autobattler.controllers.GameController;
import com.EricNorrwing.Autobattler.input.InputScanner;
import com.EricNorrwing.Autobattler.models.Armor;
import com.EricNorrwing.Autobattler.models.Player;
import com.EricNorrwing.Autobattler.models.Weapon;

public class GameViewer {
    InputScanner scanner = new InputScanner();
    GameController gc = new GameController();
    Player player;
    boolean gameIsRunning = true;

    //Gameplay loop runs here
    public void gameplayLoopSwitch() throws InterruptedException {
        initializeGame();
        System.out.println("Welcome to the game, chose your next move...");
        do {
            presentGameplayMenu();
            switch (scanner.choseAction()) {
                case 1 -> gc.generateEncounter(player);
                case 2 -> player.presentUnit();
                case 3 -> System.exit(0);

                default -> System.out.println("Not a correct statement");
            }
        } while (gameIsRunning);
    }
    public void initializeGame(){
        Player player = new Player("Benny");
        Weapon weapon = new Weapon();
        Armor armor = new Armor();
        armor.generateStartingArmor();
        weapon.generateStarterWeapon();
        this.player = player;
    }
    public void presentGameplayMenu(){
        System.out.println("""
                1. Benny is feeling fearless and continues his travels
                2. Benny is curious to how healthy he is, and the state of his character
                3. Benny is afraid and wants to flee the scene
                4. Benny is unaware what happens when one chooses from options higher than 3, maybe it saves the game?"""
        );
    }


}
