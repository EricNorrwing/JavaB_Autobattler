package com.EricNorrwing.Autobattler;

import com.EricNorrwing.Autobattler.viewers.GameViewer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameViewer gv = new GameViewer();
        gv.gameplayLoopSwitch();
    }
}
