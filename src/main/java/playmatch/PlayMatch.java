package playmatch;

import buildteam.BuildTeam;
import cricketmatch.CricketMatchBuilder;
import model.CricketMatchTeam;
import model.MatchSetup;
import model.Team;

import java.util.Scanner;

public class PlayMatch {
    private final Scanner   scanner   = new Scanner(System.in);
    private final BuildTeam buildTeam = new BuildTeam();
    private MatchSetup matchSetup;

    public void beforeMatchSetup() {
        System.out.printf("Provide no. of player in each team %n");
        int numberOfPlayer = scanner.nextInt();
        final Team firstTeam = buildTeam.buildTeam(numberOfPlayer);
        final Team secondTeam = buildTeam.buildTeam(numberOfPlayer);
        final CricketMatchBuilder cricketMatchBuilder = new CricketMatchBuilder();
        final CricketMatchTeam cricketMatchTeam = cricketMatchBuilder.teamsForMatch(firstTeam, secondTeam);
        System.out.printf("Provide no. of over each team will play %n");
        int totalOver = scanner.nextInt();
        System.out.printf("Select team batting first %n");
        System.out.printf("1 -> %s %n", firstTeam.getTeamName());
        System.out.printf("2 -> %s %n", secondTeam.getTeamName());
        int battingTeam = scanner.nextInt();
        matchSetup.setBattingTeam(battingTeam);
        matchSetup.setNumberOfOver(totalOver);
        matchSetup.setNumberOfPlayer(numberOfPlayer);
    }

    public void startMatch() {

    }


}
