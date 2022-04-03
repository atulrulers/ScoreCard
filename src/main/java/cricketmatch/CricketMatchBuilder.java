package cricketmatch;

import model.BattingStat;
import model.BowlingStat;
import model.CricketMatchTeam;
import model.Player;
import model.PlayerStatInMatch;
import model.Team;
import model.TeamInAMatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CricketMatchBuilder {

    public CricketMatchTeam teamsForMatch(final Team firstTeam, final Team secondTeam) {
        int matchId = (int) (Math.random() * (1000));

        return CricketMatchTeam.builder()
                               .matchId(matchId)
                               .firstTeam(getTeamInAMatch(firstTeam))
                               .secondTeam(getTeamInAMatch(secondTeam))
                               .build();
    }

    public void showTeamDetailsForMatch(final TeamInAMatch teamInAMatch) {
        System.out.printf("Team Name = %s%n", teamInAMatch.getTeam()
                                                          .getTeamName());
        System.out.printf("Team Details %n%n");
        final HashMap<Player, PlayerStatInMatch> playerStatInMatchMap = teamInAMatch.getPlayerStatInMatch();

        playerStatInMatchMap.forEach(((player, playerStatInMatch) -> {
            System.out.printf("%s %s %s %n", player.getFirstName(), player.getLastName(), player.getPlayerSkill());
            final BattingStat battingStat = playerStatInMatch.getBattingStat();
            System.out.printf("Batting Stat: %n %d %d %d %d %.2f%n%n", battingStat.getTotalRunsScored(),
                    battingStat.getTotalBallPlayed(), battingStat.getTotalNumberOf4(),
                    battingStat.getTotalNumberOf6(), battingStat.getStrikeRate());
            final BowlingStat bowlingStat = playerStatInMatch.getBowlingStat();
            System.out.printf("Bowling Stat:%n %d %d %d %d", bowlingStat.getOverBowled(),
                    bowlingStat.getWicketTaken(), bowlingStat.getNoBall(), bowlingStat.getWide());
            System.out.printf("%n%n");
        }));

    }

    private TeamInAMatch getTeamInAMatch(final Team team) {
        final HashMap<Player, PlayerStatInMatch> playerStatInMatch = getPlayersStatInMatch(team.getPlayerList());
        return TeamInAMatch.builder()
                           .team(team)
                           .currentBatting(1)
                           .fallOfWickets(new ArrayList<>())
                           .wicketFallen(0)
                           .overPlayed(0)
                           .totalRunScored(0)
                           .playerStatInMatch(playerStatInMatch)
                           .build();
    }

    private HashMap<Player, PlayerStatInMatch> getPlayersStatInMatch(final List<Player> playerList) {
        final BowlingStat bowlingStat = BowlingStat.builder()
                                                   .maxOverAllowed(0)
                                                   .overBowled(0)
                                                   .noBall(0)
                                                   .totalRunConceded(0)
                                                   .wicketTaken(0)
                                                   .wide(0)
                                                   .build();

        final BattingStat battingStat = BattingStat.builder()
                                                   .strikeRate(0)
                                                   .totalBallPlayed(0)
                                                   .totalRunsScored(0)
                                                   .totalNumberOf1(0)
                                                   .totalNumberOf2(0)
                                                   .totalNumberOf3(0)
                                                   .totalNumberOf4(0)
                                                   .totalNumberOf6(0)
                                                   .build();

        final HashMap<Player, PlayerStatInMatch> playerPlayerStatInMatch = new HashMap<>();
        for (final Player player : playerList) {
            final PlayerStatInMatch playerStatInMatch = PlayerStatInMatch.builder()
                                                                         .battingStat(battingStat)
                                                                         .bowlingStat(bowlingStat)
                                                                         .build();
            playerPlayerStatInMatch.put(player, playerStatInMatch);
        }

        return playerPlayerStatInMatch;
    }

}
