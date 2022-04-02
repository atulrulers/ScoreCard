package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CricketMatchTeam {
    private int matchId;
    private Team firstTeam;
    private Team secondTeam;
}
