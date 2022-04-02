package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Over {
    private int numberOfBallInOver;
    private int perPlayerOverAllowed;
}
