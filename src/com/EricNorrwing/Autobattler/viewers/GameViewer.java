package com.EricNorrwing.Autobattler.viewers;

import com.EricNorrwing.Autobattler.input.InputScanner;

public class GameViewer {
    InputScanner scanner = new InputScanner();

    public void gameplayLoopSwitch(){
        switch (scanner.getNextInt()){
            case 1 -> //generateEncounter();
            case 2 -> //Showcase character;
            case 3 -> System.exit(0);
        }
    }



}
