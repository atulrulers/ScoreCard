package teamstat;

import model.BattingStat;
import model.Player;
import model.PlayerStatInMatch;
import model.Team;
import model.TeamInAMatch;

import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

import static constants.Constants.BALL;
import static constants.Constants.FOURS;
import static constants.Constants.NAME;
import static constants.Constants.RUN;
import static constants.Constants.SIXES;
import static constants.Constants.STRIKE_RATE;

public class TeamStat {

    public void showBattingTeamStatInMatch(final TeamInAMatch teamInAMatch) {
        System.out.printf("%s%n", teamInAMatch.getTeam()
                                              .getTeamName());
        System.out.printf("[%d / %d, Overs: %d]", teamInAMatch.getTotalRunScored(), teamInAMatch.getWicketFallen(),
                teamInAMatch.getOverPlayed());

        final HashMap<Player, PlayerStatInMatch> playerStatInMatchMap = teamInAMatch.getPlayerStatInMatch();
        final int currentPlayer = teamInAMatch.getCurrentBatting();
        final List<Player> playerList = teamInAMatch.getTeam()
                                                    .getPlayerList();
        for (int i = 0; i < playerList.size(); i++) {
            final Player player = playerList.get(i);
            // current player playing
            if (i == currentPlayer - 1 || i == currentPlayer) {
                showBatsmanDetails(player, playerStatInMatchMap.get(player), true);
            } else {
                showBatsmanDetails(player, playerStatInMatchMap.get(player), false);
            }
        }

    }

    private void showBatsmanDetails(final Player player, final PlayerStatInMatch playerStatInMatch,
            final boolean isCurrentlyBatting) {
        System.out.printf("%s %8s %8s %4s %4s %5s %n", NAME, RUN, BALL, FOURS, SIXES, STRIKE_RATE);
        final String playerName = String.format("%s %s", player.getFirstName(), player.getLastName());
        final BattingStat battingStat = playerStatInMatch.getBattingStat();
        if (isCurrentlyBatting) {
            System.out.printf("%s* %8d %8d %4d %4d %5.2f %n", playerName, battingStat.getTotalRunsScored(),
                    battingStat.getTotalBallPlayed(), battingStat.getTotalNumberOf4(),
                    battingStat.getTotalNumberOf6(), battingStat.getStrikeRate());
        } else {
            System.out.printf("%s %8d %8d %4d %4d %5.2f %n", playerName, battingStat.getTotalRunsScored(),
                    battingStat.getTotalBallPlayed(), battingStat.getTotalNumberOf4(),
                    battingStat.getTotalNumberOf6(), battingStat.getStrikeRate());
        }
    }
}
