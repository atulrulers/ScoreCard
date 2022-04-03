package controller;

import playmatch.PlayMatch;

public class Controller {
    private static final PlayMatch playMatch = new PlayMatch();

    public static void main(String... args) {
        playMatch.playCricket();
    }
}