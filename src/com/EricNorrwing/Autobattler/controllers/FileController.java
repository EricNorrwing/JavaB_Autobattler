package com.EricNorrwing.Autobattler.controllers;

import com.EricNorrwing.Autobattler.models.Player;
import com.EricNorrwing.Autobattler.models.Weapon;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileController {


    public void saveGame (Player player) {

        try (Writer writer =
                        new BufferedWriter(
                        new OutputStreamWriter(
                        new FileOutputStream("AutoBattler_saved_player.txt" ), StandardCharsets.UTF_8)))
        {
            writer.write(savePlayerInfo(player));
        }
        catch (IOException ex) {
            // Handle me
        }
    }

    public String savePlayerInfo(Player player){
        String playerInfo = player.getName() + " has the following statistics:" +
                "\n" +  player.getHealth() +  " health" +
                "\n" +  (player.getAgility()) +   "%" +  " chance to dodge" +
                "\n" + (player.getStrength()) +   "%" + " increased damage" +
                "\n" + (player.getLethality()) + "%" + " chance to critically strike" +
                "\n" + (player.getSkill()) + "%" + " chance to hit" +
                "\n" + player.getWeapon().getBonusDamage() +" increased damage per hit" +
                "\n" + player.getArmor().getDamageReduction() + " less damage taken per hit" +
                "\n" + player.getTurnsPlayed() + " monsters have been slain";
        return playerInfo;
    }


}
