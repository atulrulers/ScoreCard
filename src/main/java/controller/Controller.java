package controller;

import buildteam.BuildTeam;
import cricketmatch.CricketMatchBuilder;
import model.CricketMatchTeam;
import model.Team;

public class Controller {
    public static void main(String... args) {
        final BuildTeam buildTeam = new BuildTeam();
        int numberOfPlayer = 5;
        final Team firstTeam = buildTeam.buildTeam(numberOfPlayer);
        final Team secondTeam = buildTeam.buildTeam(numberOfPlayer);
        final CricketMatchBuilder cricketMatchBuilder = new CricketMatchBuilder();
        final CricketMatchTeam cricketMatchTeam = cricketMatchBuilder.teamsForMatch(firstTeam, secondTeam);
        cricketMatchBuilder.showTeamDetails(firstTeam);
        cricketMatchBuilder.showTeamDetails(secondTeam);


    }
}