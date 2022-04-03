package playmatch;

import enums.BowlType;
import enums.RunType;
import model.BattingStat;
import model.BowlingStat;
import model.FallOfWicket;
import model.PlayInOneOver;
import model.Player;
import model.PlayerStatInMatch;
import model.TeamInAMatch;

import java.util.List;
import java.util.Scanner;

public class BattingAndBowling {
    private final Scanner scanner = new Scanner(System.in);

    public void battingAndBowling(final TeamInAMatch battingTeam, final TeamInAMatch bowlingTeam, final int totalOver) {
        int currentOver = 0;
        int batsmanOnStrike = 0;
        int batsmanOnNonStrike = 1;
        int currentBowler = -1;
        while (currentOver < totalOver) {
            System.out.printf("Select bowler [%d-%d] %n", 0, bowlingTeam.getTeam()
                                                                        .getPlayerList()
                                                                        .size() - 1);
            int bowler = scanner.nextInt();
            while (currentBowler == bowler) {
                System.out.printf("Same bowler cannot bowl again. Select different bowler %n");
                bowler = scanner.nextInt();
            }
            final PlayInOneOver playInOneOver = PlayInOneOver.builder()
                                                             .battingTeam(battingTeam)
                                                             .bowlingTeam(bowlingTeam)
                                                             .batsmanOnStrike(batsmanOnStrike)
                                                             .batsmanOnNonStrike(batsmanOnNonStrike)
                                                             .bowler(bowlingTeam.getTeam()
                                                                                .getPlayerList()
                                                                                .get(bowler))
                                                             .build();
            matchPlayedInOneOver(playInOneOver);
            currentOver += 1;
        }
    }

    private void updateBattingTeamStat(final TeamInAMatch battingTeam, final RunType runType, final BowlType bowlType) {

    }

    private void updateBattingStat(final TeamInAMatch battingTeam, final Player player,
            final RunType runType) {
        final PlayerStatInMatch playerStatInMatch = battingTeam.getPlayerStatInMatch()
                                                               .get(player);
        final BattingStat battingStat = playerStatInMatch.getBattingStat();
        battingStat.setTotalBallPlayed(battingStat.getTotalBallPlayed() + 1);

        switch (runType) {
        case SINGLE:
            battingStat.setTotalRunsScored(battingStat.getTotalRunsScored() + 1);
            battingStat.setTotalNumberOf1(battingStat.getTotalNumberOf1() + 1);
            break;
        case DOUBLE:
            battingStat.setTotalRunsScored(battingStat.getTotalRunsScored() + 2);
            battingStat.setTotalNumberOf2(battingStat.getTotalNumberOf2() + 1);
            break;
        case TRIPLE:
            battingStat.setTotalRunsScored(battingStat.getTotalRunsScored() + 3);
            battingStat.setTotalNumberOf3(battingStat.getTotalNumberOf3() + 1);
            break;
        case FOUR:
            battingStat.setTotalRunsScored(battingStat.getTotalRunsScored() + 4);
            battingStat.setTotalNumberOf4(battingStat.getTotalNumberOf4() + 1);
            break;
        case SIX:
            battingStat.setTotalRunsScored(battingStat.getTotalRunsScored() + 6);
            battingStat.setTotalNumberOf6(battingStat.getTotalNumberOf6() + 1);
            break;
        default:
            System.out.println("Invalid entry");
            break;
        }
        playerStatInMatch.setBattingStat(battingStat);
    }

    private void updateBowlingStat(final TeamInAMatch bowlingTeam, final Player player, final BowlType bowlType) {
        final PlayerStatInMatch playerStatInMatch = bowlingTeam.getPlayerStatInMatch()
                                                               .get(player);
        final BowlingStat bowlingStat = playerStatInMatch.getBowlingStat();
        switch (bowlType) {
        case SINGLE:
            bowlingStat.setTotalRunConceded(bowlingStat.getTotalRunConceded() + 1);
            bowlingStat.setOverBowled(bowlingStat.getOverBowled() + 1);
            break;
        case DOUBLE:
            bowlingStat.setTotalRunConceded(bowlingStat.getTotalRunConceded() + 2);
            bowlingStat.setOverBowled(bowlingStat.getOverBowled() + 1);
            break;
        case TRIPLE:
            bowlingStat.setTotalRunConceded(bowlingStat.getTotalRunConceded() + 3);
            bowlingStat.setOverBowled(bowlingStat.getOverBowled() + 1);
            break;
        case FOUR:
            bowlingStat.setTotalRunConceded(bowlingStat.getTotalRunConceded() + 4);
            bowlingStat.setOverBowled(bowlingStat.getOverBowled() + 1);
            break;
        case SIX:
            bowlingStat.setTotalRunConceded(bowlingStat.getTotalRunConceded() + 6);
            bowlingStat.setOverBowled(bowlingStat.getOverBowled() + 1);
            break;
        case OUT:
            bowlingStat.setWicketTaken(bowlingStat.getWicketTaken() + 1);
            bowlingStat.setOverBowled(bowlingStat.getOverBowled() + 1);
            break;
        case WIDE:
            bowlingStat.setWide(bowlingStat.getWide() + 1);
            bowlingStat.setTotalRunConceded(bowlingStat.getTotalRunConceded() + 1);
            break;

        case NO_BALL:
            bowlingStat.setNoBall(bowlingStat.getNoBall() + 1);
            bowlingStat.setTotalRunConceded(bowlingStat.getTotalRunConceded() + 1);
            break;

        default:
            System.out.println("Invalid entry");
            break;

        }
        playerStatInMatch.setBowlingStat(bowlingStat);
    }

    private BowlType getBowlType() {
        System.out.printf("Enter bowlType %n");
        System.out.printf("Select %n");
        System.out.printf("%s%n %s%n %s%n %s%n %s%n %s%n %s%n %s%n", BowlType.SINGLE.name(), BowlType.DOUBLE.name(),
                BowlType.TRIPLE.name(), BowlType.FOUR.name(), BowlType.SIX.name(), BowlType.OUT.name(),
                BowlType.WIDE.name(), BowlType.NO_BALL.name());
        final String bowlingType = scanner.next();
        return BowlType.valueOf(bowlingType.toUpperCase());
    }

    private RunType getRunType(final BowlType bowlType) {
        switch (bowlType) {
        case SINGLE:
            return RunType.SINGLE;
        case DOUBLE:
            return RunType.DOUBLE;
        case TRIPLE:
            return RunType.TRIPLE;
        case FOUR:
            return RunType.FOUR;
        case SIX:
            return RunType.SIX;
        case NO_BALL:
            System.out.printf("How many Runs on NoBall ? %n");
            final int runScored = scanner.nextInt();
            return getRunTypeFromRun(runScored);
        default:
            return RunType.INVALID;
        }

    }

    private RunType getRunTypeFromRun(final int run) {
        switch (run) {
        case 0:
            return RunType.ZERO;
        case 1:
            return RunType.SINGLE;
        case 2:
            return RunType.DOUBLE;
        case 3:
            return RunType.TRIPLE;
        case 4:
            return RunType.FOUR;
        case 6:
            return RunType.SIX;
        default:
            return RunType.INVALID;
        }
    }

    private void matchPlayedInOneOver(final PlayInOneOver playInOneOver) {
        int ballInthisOver = 0;
        final Player bowler = playInOneOver.getBowler();
        Player batsmanOnStrike =
                playInOneOver.getBattingTeam()
                             .getTeam()
                             .getPlayerList()
                             .get(playInOneOver.getBatsmanOnStrike());
        while (ballInthisOver < 6) {
            ballInthisOver += 1;
            final BowlType bowlType = getBowlType();
            updateBattingStat(playInOneOver.getBattingTeam(), batsmanOnStrike, getRunType(bowlType));
            updateBowlingStat(playInOneOver.getBowlingTeam(), bowler, bowlType);
            updateTeamStat(playInOneOver.getBattingTeam(), bowlType);
            if (ballInthisOver <= 5) {
                batsmanOnStrike = getBatsmanOnStrike(playInOneOver, bowlType);
            }
        }
        playInOneOver.setBatsmanOnStrike(playInOneOver.getBatsmanOnNonStrike());
    }

    private Player getBatsmanOnStrike(final PlayInOneOver playInOneOver, final BowlType bowlType) {
        switch (bowlType) {
        case SINGLE:
        case TRIPLE:
        case OVER:
            playInOneOver.setBatsmanOnStrike(playInOneOver.getBatsmanOnNonStrike());
            return playInOneOver.getBattingTeam()
                                .getTeam()
                                .getPlayerList()
                                .get(playInOneOver.getBatsmanOnNonStrike());
        default:
            playInOneOver.setBatsmanOnStrike(playInOneOver.getBatsmanOnStrike());
            return playInOneOver.getBattingTeam()
                                .getTeam()
                                .getPlayerList()
                                .get(playInOneOver.getBatsmanOnStrike());
        }
    }

    private void updateTeamStat(final TeamInAMatch battingTeam, final BowlType bowlType) {
        switch (bowlType) {
        case SINGLE:
            battingTeam.setTotalRunScored(battingTeam.getTotalRunScored() + 1);
            battingTeam.setOverPlayed(battingTeam.getOverPlayed() + 1);
            break;
        case DOUBLE:
            battingTeam.setTotalRunScored(battingTeam.getTotalRunScored() + 2);
            battingTeam.setOverPlayed(battingTeam.getOverPlayed() + 1);
            break;
        case TRIPLE:
            battingTeam.setTotalRunScored(battingTeam.getTotalRunScored() + 3);
            battingTeam.setOverPlayed(battingTeam.getOverPlayed() + 1);
            break;
        case FOUR:
            battingTeam.setTotalRunScored(battingTeam.getTotalRunScored() + 4);
            battingTeam.setOverPlayed(battingTeam.getOverPlayed() + 1);
            break;
        case SIX:
            battingTeam.setTotalRunScored(battingTeam.getTotalRunScored() + 6);
            battingTeam.setOverPlayed(battingTeam.getOverPlayed() + 1);
            break;
        case OUT:
            battingTeam.setWicketFallen(battingTeam.getWicketFallen() + 1);
            battingTeam.setOverPlayed(battingTeam.getOverPlayed() + 1);
            final FallOfWicket fallOfWicket = FallOfWicket.builder()
                                                          .over(battingTeam.getOverPlayed())
                                                          .run(battingTeam.getTotalRunScored())
                                                          .build();
            List<FallOfWicket> fallOfWickets = battingTeam.getFallOfWickets();
            fallOfWickets.add(fallOfWicket);
            break;
        case WIDE:
            battingTeam.setTotalRunScored(battingTeam.getTotalRunScored() + 1);
            battingTeam.setRunsFromWideBall(battingTeam.getRunsFromWideBall()+1);
            break;

        case NO_BALL:
            battingTeam.setTotalRunScored(battingTeam.getTotalRunScored() + 1);
            battingTeam.setRunsFromNoBall(battingTeam.getRunsFromNoBall() + 1);
            break;

        default:
            System.out.println("Invalid entry");
            break;

        }

    }

}
