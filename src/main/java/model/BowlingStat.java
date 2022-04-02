package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BowlingStat {
    private int maxOverAllowed;
    private int overBowled;
    private int totalRunConceded;
    private int wicketTaken;
    private int wide;
    private int noBall;
}
