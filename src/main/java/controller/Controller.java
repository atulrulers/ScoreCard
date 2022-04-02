package controller;

import enums.PlayerSkill;
import model.Player;


public class Controller {
    public static void main(String... args) {
        Player player = Player.builder()
                              .id(1)
                              .firstName("Rohan")
                              .lastName("Sharma")
                              .playerSkill(PlayerSkill.BATSMAN)
                              .build();

        System.out.println(player.toString());
    }
}
