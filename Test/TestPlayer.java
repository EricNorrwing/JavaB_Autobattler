import com.EricNorrwing.Autobattler.controllers.GameController;
import com.EricNorrwing.Autobattler.input.InputScanner;
import com.EricNorrwing.Autobattler.models.Armor;
import com.EricNorrwing.Autobattler.models.Player;
import com.EricNorrwing.Autobattler.viewers.GameViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.EricNorrwing.Autobattler.*;

public class TestPlayer {

    static GameViewer gv = new GameViewer();
    Player player;

    @BeforeEach
    public void setupPlayer(){
        this.player = gv.initializeGame();
    }
    @DisplayName("Testing player class")
    @Test
    public void testPlayerClass(){
        Armor armor = new Armor();
        armor.generateStartingArmor();
        armor.setAgilityModifier(5);
        player.getAgility();
        Assertions.assertEquals(player.getAgility()+armor.getAgilityModifier(), 10);
    }
}
