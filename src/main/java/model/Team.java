package model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Builder
@Data
public class Team {
    private int                                id;
    private String                             teamName;
    private HashMap<Player, PlayerStatInMatch> playerStatInMatch;
    private List<FallOfWicket>                 fallOfWickets;
}
