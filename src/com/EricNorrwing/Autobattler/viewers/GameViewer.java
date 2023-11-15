package com.EricNorrwing.Autobattler.viewers;
import static com.EricNorrwing.Autobattler.models.Colors.*;

import com.EricNorrwing.Autobattler.controllers.GameController;
import com.EricNorrwing.Autobattler.input.InputScanner;
import com.EricNorrwing.Autobattler.models.Armor;
import com.EricNorrwing.Autobattler.models.Player;
import com.EricNorrwing.Autobattler.models.Weapon;

public class GameViewer {
    private InputScanner scanner = new InputScanner();
    private GameController gc = new GameController();
    private Player player;


    //Gameplay loop runs here
    public void gameplayLoopSwitch() throws InterruptedException {
        initializeGame();
        System.out.println("Welcome to the game, chose your next move...");
        do {
            presentGameplayMenu();
            switch (scanner.choseAction()) {
                case 1 -> gc.generateEncounter(player);
                case 2 ->{
                    player.presentUnit();
                    Weapon weapon = player.getWeapon();
                    Armor armor = player.getArmor();
                    weapon.printItem(weapon);
                    armor.printItem(armor);
                }
                case 3 -> System.exit(0);
                //case 4 -> saveGame();
                case 5 -> disclaimer();
                default -> System.out.println("Something went wrong with input, you should never reach this default. Im keeping it for shits and giggles");
            }
        } while (player.getPlayerIsAlive());
    }
    public Player initializeGame(){
        Player player = new Player("Benny");
        Weapon weapon = new Weapon();
        Armor armor = new Armor();
        armor.generateStartingArmor();
        weapon.generateStarterWeapon();
        this.player = player;
        return player;
    }
    public void presentGameplayMenu(){
        System.out.println("""
                1. Benny is feeling fearless and continues his travels
                2. Benny is curious to how healthy he is, and the state of his character
                3. Benny is afraid and wants to flee the scene
                4. Benny is unaware what happens when one chooses from options higher than 3, maybe it saves the game?
                5. Benny does not understand this game, and wants to know more about his imminent future"""
        );
    }
    public void disclaimer(){
        System.out.println( RED_BOLD + """
                This game is about Benny and his travels to go visit his mother on the other end of the forrest. Spoiler it never ends well for him.
                This game cannot be beat, you simply try to kill as many enemies as you can before you die.
                I am not a gamedev and this game has horrible balance, its very possible to early on reach things such as 80% dodge and you basicly can no longer die
                Leveling up gives you full hp, every 100 experience you recieve. But the experience gained is anywhere between 0 and 500 for a foe, read the statement above.
                Structure:
                You can chose to enter a random encounter, examine your character, exit game, save game or print this message whenever you want. That is all the game does.
                The game ends when the player dies, and never otherwise, you would have to exit game to end it.
                When your character dies it will print the amount of enemies you defeated
                This game is in dire need of some refactoring, but i simply do not have the time to properly finish this because i bought a kitten that needs my time.
                Therefor this game is aims to be a VG grade, but only does so by minimum requirements, sorry about that.
                """ + RESET
        );
    }
}
