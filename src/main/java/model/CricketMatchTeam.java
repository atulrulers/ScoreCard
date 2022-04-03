package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CricketMatchTeam {
    private int matchId;
    private TeamInAMatch firstTeam;
    private TeamInAMatch secondTeam;
}
