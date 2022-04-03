package buildteam;

import enums.PlayerSkill;
import model.BattingStat;
import model.BowlingStat;
import model.Player;
import model.PlayerStatInMatch;
import model.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BuildTeam {
    private final Scanner scanner = new Scanner(System.in);

    public Team buildTeam(final int numberOfPlayer) {
        System.out.println("Enter team id");
        int teamId = scanner.nextInt();

        System.out.println("Enter team Name");
        final String teamName = scanner.next();

        final List<Player> playerList = getPlayerListForTeam(teamId, numberOfPlayer);

        return Team.builder()
                   .teamName(teamName)
                   .id(teamId)
                   .playerList(playerList)
                   .build();

    }

    private List<Player> getPlayerListForTeam(final int teamId, final int numberOfPlayer) {
        int totalPlayer = numberOfPlayer;
        System.out.printf("Provide players detail in Batting order %n");
        System.out.printf("Enter %d players detail : %n first name, last name & skill[%s, %s, %s] %n", totalPlayer,
                PlayerSkill.BATSMAN.name(), PlayerSkill.BOWLER.name(), PlayerSkill.ALL_ROUNDER.name());

        final List<Player> playerList = new ArrayList<>();

        while (totalPlayer > 0) {
            totalPlayer -= 1;
            final String firstName = scanner.next();
            final String lastName = scanner.next();
            final String skill = scanner.next();
            System.out.println("");
            final Player player = Player.builder()
                                        .playerSkill(PlayerSkill.valueOf(skill.toUpperCase()))
                                        .id(teamId + totalPlayer)
                                        .lastName(lastName)
                                        .firstName(firstName)
                                        .build();
            playerList.add(player);
        }

        return playerList;
    }

}
