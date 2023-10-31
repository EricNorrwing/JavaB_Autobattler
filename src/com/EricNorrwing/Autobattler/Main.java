package com.EricNorrwing.Autobattler;

import com.EricNorrwing.Autobattler.controllers.GameController;

public class Main {
    public static void main(String[] args) {
        GameController game = new GameController();
        System.out.println((int) (Math.random()*10+1));
        //game.run();
    }
}
