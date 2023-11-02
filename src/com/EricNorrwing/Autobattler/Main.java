package com.EricNorrwing.Autobattler;

import com.EricNorrwing.Autobattler.controllers.GameController;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameController game = new GameController();
        game.runGame();
    }
}
