package controller;

import buildteam.BuildTeam;
import model.Team;

public class Controller {
    public static void main(String... args) {
        final BuildTeam buildTeam = new BuildTeam();
        final Team team = buildTeam.buildTeam(5);
        System.out.println(team.toString());
    }
}
