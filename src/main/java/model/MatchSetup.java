package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MatchSetup {
    private int numberOfPlayer;
    private int numberOfOver;
    private int battingTeam;
}
