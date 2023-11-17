import com.EricNorrwing.Autobattler.controllers.GameController;
import com.EricNorrwing.Autobattler.models.*;
import com.EricNorrwing.Autobattler.viewers.GameViewer;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class TestEnemy {
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

    @DisplayName("Test enemy agility at very high levels to ensure they dont reach 100% dodge")
    @Test
    public void testEnemyStats(){
        player.setLevel(500);
        enemy = gc.generateEnemy(player);
        assertTrue(enemy.getAgility()<=100);

    }
}
