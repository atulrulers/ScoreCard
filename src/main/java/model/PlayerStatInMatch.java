package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayerStatInMatch {
    private Player player;
    private BattingStat battingStat;
    private BowlingStat bowlingStat;
}
