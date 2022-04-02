package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BattingStat {
    private int totalBallPlayed;
    private int totalRunsScored;
    private int totalNumberOf1;
    private int totalNumberOf2;
    private int totalNumberOf3;
    private int totalNumberOf4;
    private int totalNumberOf6;
    private double strikeRate;
}
