package model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Builder
@Data
public class TeamInAMatch {
    private Team                               team;
    private HashMap<Player, PlayerStatInMatch> playerStatInMatch;
    private int                                totalRunScored;
    private int                                overPlayed;
    private int                                wicketFallen;
    private int                                currentBatting;
    private List<FallOfWicket>                 fallOfWickets;
}
