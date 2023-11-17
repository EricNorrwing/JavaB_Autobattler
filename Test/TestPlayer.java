import com.EricNorrwing.Autobattler.controllers.GameController;
import com.EricNorrwing.Autobattler.models.*;
import com.EricNorrwing.Autobattler.viewers.GameViewer;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class TestPlayer {

    static GameViewer gv = new GameViewer();
    static GameController gc = new GameController();
    Player player;
    Enemy enemy;
    Armor armor = new Armor();
    Weapon weapon = new Weapon();

    @BeforeEach
    public void setupPlayer(){
        this.player = gv.initializeGame();
        //Generate a random enemy
        enemy = gc.generateEnemy(player);
        armor.generateStartingArmor();
        weapon.generateStarterWeapon();
    }
    @DisplayName("Testing player class")
    @Test
    public void testPlayerClass() {
        armor.setAgilityModifier(5);
        weapon.setStrengthModifier(5);
        player.getAgility();
        //Test if adding stats through armor gives expected results, starting items have no stats.
        Assertions.assertEquals(10, player.getAgility()+armor.getAgilityModifier());
        //Same for weapons
        Assertions.assertEquals(10, player.getAgility()+armor.getAgilityModifier());


        //Testing that player health is within reasonable amounts, above 0 and lower than theoretical max health.
        //There are scenarios in the game where max health can be above this value, but only by adding weapons and armor
        Assertions.assertTrue(0 <= player.getHealth() && player.getHealth() <= (int) (100*Math.pow(1.2,player.getLevel())));

        //Make it deal damage to the player, insert player weapons because they dont have stats
        //Ensure that player health gets reduced by the damage dealt to the player
        int health = player.getHealth();
        int damage = enemy.getDamage(weapon, armor);
        Assertions.assertEquals(health-damage, player.getHealth()-damage);
        //same but for enemies
        //TODO Move to enemy class
        health = enemy.getHealth();
        damage = player.getDamage(weapon, armor);
        Assertions.assertEquals(health-damage, enemy.getHealth()-damage);
    }

    @DisplayName("Test so adding many weapons wont change anything other than hp")
    @Test
    public void testAddingWeapons(){

        for (int i = 0; i < 10; i++){
            weapon.generateWeapon();
            player.equipWeapon(weapon);
        }
        weapon = player.getWeapon();
        weapon.printItem(weapon);
        player.presentUnit();
        //Checking agility because it does not increase with levels so we know the base is always the same
        assertEquals(player.getAgility(), 5+weapon.getAgilityModifier());
    }

    @DisplayName("Test so adding many armors wont change anything other than hp")
    @Test
    public void testAddingArmor(){

        for (int i = 0; i < 10; i++){
            armor.generateArmor();
            player.equipArmor(armor);
        }

        armor.printItem(armor);
        player.presentUnit();
        //Checking agility because it does not increase with levels so we know the base is always the same
        assertEquals(player.getAgility(), 5+armor.getAgilityModifier());
    }

    @DisplayName("Repeated test to ensure damage is always 0 or above")
    @RepeatedTest(500)
    public void damageAbove0 (){
        Assertions.assertTrue(player.getDamage(weapon, armor) >= 0);
    }
    //copy of runFight() in gamecontroller that doesnt slow it down.
    @DisplayName("Test that ensures not both player and enemy dies in a fight")
    @RepeatedTest(500)
    public void testFight(){
        do {
            if (player.isPlayerTurn()) {
                player.attack(player, enemy, player.getWeapon(), player.getArmor());

            } else {
                enemy.attack(enemy, player, enemy.getWeapon(), enemy.getArmor());
            }
            player.setPlayerTurn(!player.isPlayerTurn());
        } while (!AUnit.checkIfDead(player, enemy));
    }

    @DisplayName("Test integer overflow")
    @Test
    public void intOverflow(){
        player.setHealth(2147483647+134985394);
        System.out.println(player.getHealth());
    }
}
