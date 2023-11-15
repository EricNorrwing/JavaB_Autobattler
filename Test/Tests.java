import com.EricNorrwing.Autobattler.controllers.GameController;
import com.EricNorrwing.Autobattler.input.InputScanner;
import com.EricNorrwing.Autobattler.models.Player;
import com.EricNorrwing.Autobattler.viewers.GameViewer;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class Tests {

    InputScanner scanner = new InputScanner();
    GameController gc = new GameController();
    static GameViewer gv = new GameViewer();
    static Player player = gv.initializeGame();

    @BeforeEach
    public void beforeAllTests(){
        player.setHealth(50);
    }
    @Test
    public void testSomething(){
        int health = player.getHealth();
        Assertions.assertEquals(health, 100);
    }
    @DisplayName("Add operation test")
    @RepeatedTest(5)
    void addNumber(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
        //Assertions.assertEquals(2, Calculator.add(1, 1), "1 + 1 should equal 2");
    }


    @DisplayName("Game Controller tests: ")
    @Test
    public void testGameController(){
        GameController gc = new GameController();
        GameViewer gv = new GameViewer();
        gv.initializeGame();
        System.out.println(player.getHealth());

    }


}
