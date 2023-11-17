import com.EricNorrwing.Autobattler.controllers.GameController;
import com.EricNorrwing.Autobattler.models.Armor;
import com.EricNorrwing.Autobattler.models.Enemy;
import com.EricNorrwing.Autobattler.models.Player;
import com.EricNorrwing.Autobattler.models.Weapon;
import com.EricNorrwing.Autobattler.viewers.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("Test enemy strength at very high levels")
    @Test
    public void testEnemyStats(){
        player.setLevel(500);
        enemy = gc.generateEnemy(player);
        enemy.presentUnit();

    }
}
