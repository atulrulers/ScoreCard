package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayInOneOver {
    private int batsmanOnStrike;
    private int batsmanOnNonStrike;
    private Player bowler;
    private TeamInAMatch battingTeam;
    private TeamInAMatch bowlingTeam;
}
