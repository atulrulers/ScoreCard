package playmatch;

import model.MatchSetup;
import teamstat.TeamStat;

public class PlayMatch {
    private final BasicMatchSetup   basicMatchSetup   = new BasicMatchSetup();
    private final BattingAndBowling battingAndBowling = new BattingAndBowling();
    private final TeamStat          teamStat          = new TeamStat();

    /**
     * Control will call this method to play the game
     * 1. It does pre match setup
     * - Creates team
     * - decide which team will play first
     * 2. Each inning of game is played
     * 3. Shows stat after inning
     */
    public void playCricket() {
        final MatchSetup matchSetup = basicMatchSetup.beforeMatchSetup();
        battingAndBowling.battingAndBowlingFirst(matchSetup.getBattingTeam(), matchSetup.getBowlingTeam(),
                matchSetup.getNumberOfOver());
        teamStat.showBattingTeamStatInMatch(matchSetup.getBattingTeam());
        System.out.printf("Playing second inning %n");
        battingAndBowling.battingAndBowlingSecond(matchSetup.getBowlingTeam(), matchSetup.getBattingTeam(),
                matchSetup.getNumberOfOver());
        teamStat.showBattingTeamStatInMatch(matchSetup.getBowlingTeam());
    }
}
