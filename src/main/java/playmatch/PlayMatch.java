package playmatch;

import model.MatchSetup;
import teamstat.TeamStat;

public class PlayMatch {
    private final BasicMatchSetup   basicMatchSetup   = new BasicMatchSetup();
    private       BattingAndBowling battingAndBowling = new BattingAndBowling();
    final         TeamStat          teamStat          = new TeamStat();

    public void playCricket() {
        final MatchSetup matchSetup = basicMatchSetup.beforeMatchSetup();
        battingAndBowling.battingAndBowling(matchSetup.getBattingTeam(), matchSetup.getBowlingTeam(),
                matchSetup.getNumberOfOver());
        teamStat.showBattingTeamStatInMatch(matchSetup.getBattingTeam());
//        teamStat.showBattingTeamStatInMatch(matchSetup.getBowlingTeam());
        System.out.printf("Playing second inning %n");
        battingAndBowling.battingAndBowling(matchSetup.getBowlingTeam(), matchSetup.getBattingTeam(),
                matchSetup.getNumberOfOver());
        teamStat.showBattingTeamStatInMatch(matchSetup.getBowlingTeam());
//        teamStat.showBattingTeamStatInMatch(matchSetup.getBattingTeam());
    }
}
