package controller;

import buildteam.BuildTeam;
import cricketmatch.CricketMatchBuilder;
import cricketmatchevent.CricketMatchEvent;
import model.CricketMatchTeam;
import model.Team;
import teamstat.TeamStat;

public class Controller {
    public static void main(String... args) {
        final BuildTeam buildTeam = new BuildTeam();
        int numberOfPlayer = 5;
        final Team firstTeam = buildTeam.buildTeam(numberOfPlayer);
        final Team secondTeam = buildTeam.buildTeam(numberOfPlayer);
        final CricketMatchBuilder cricketMatchBuilder = new CricketMatchBuilder();
        final CricketMatchTeam cricketMatchTeam = cricketMatchBuilder.teamsForMatch(firstTeam, secondTeam);
//        cricketMatchBuilder.showTeamDetailsForMatch(cricketMatchTeam.getFirstTeam());
//        cricketMatchBuilder.showTeamDetailsForMatch(cricketMatchTeam.getSecondTeam());

        final CricketMatchEvent cricketMatchEvent = new CricketMatchEvent();

        final TeamStat teamStat = new TeamStat();
        teamStat.showBattingTeamStatInMatch(cricketMatchTeam.getFirstTeam());
        teamStat.showBattingTeamStatInMatch(cricketMatchTeam.getFirstTeam());



    }
}