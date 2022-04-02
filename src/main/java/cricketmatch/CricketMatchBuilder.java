package cricketmatch;

import model.CricketMatchTeam;
import model.Team;

public class CricketMatchBuilder {

    public CricketMatchTeam teamsForMatch(final Team firstTeam, final Team secondTem) {
        int matchId = (int) (Math.random() * (1000));

        return CricketMatchTeam.builder()
                               .matchId(matchId)
                               .firstTeam(firstTeam)
                               .secondTeam(secondTem)
                               .build();
    }
}
