package cricketmatch;

import model.BattingStat;
import model.BowlingStat;
import model.CricketMatchTeam;
import model.Player;
import model.PlayerStatInMatch;
import model.Team;

import java.util.HashMap;
import java.util.List;

public class CricketMatchBuilder {

    public CricketMatchTeam teamsForMatch(final Team firstTeam, final Team secondTem) {
        int matchId = (int) (Math.random() * (1000));

        return CricketMatchTeam.builder()
                               .matchId(matchId)
                               .firstTeam(firstTeam)
                               .secondTeam(secondTem)
                               .build();
    }

    public void showTeamDetails(final Team team) {
        System.out.printf("Team Name = %s%n", team.getTeamName());
        System.out.printf("Team Details %n%n");
        final HashMap<Player, PlayerStatInMatch> playerStatInMatchMap = team.getPlayerStatInMatch();

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
}
