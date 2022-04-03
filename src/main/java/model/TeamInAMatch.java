package model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Builder
@Data
public class TeamInAMatch {
    private Team                               team;
    private HashMap<Player, PlayerStatInMatch> playerStatInMatch;
    private boolean                            isBattingSecond;
    private int                                totalRunScored;
    private int                                runsFromNoBall;
    private int                                runsFromWideBall;
    private int                                overPlayed;
    private int                                wicketFallen;
    private Set<Integer>                       currentBatting;
    private List<FallOfWicket>                 fallOfWickets;
}
