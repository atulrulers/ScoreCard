package playmatch;

import enums.BowlType;
import enums.RunType;
import model.BattingStat;
import model.BowlingStat;
import model.Player;
import model.PlayerStatInMatch;
import model.TeamInAMatch;

import java.util.Scanner;

public class BattingAndBowling {
    private final Scanner scanner = new Scanner(System.in);

    public void battingAndBowling(final TeamInAMatch battingTeam, final TeamInAMatch bowlingTeam, final int totalOver) {
        int currentOver = 0;
        while (currentOver < totalOver) {
            int ballInthisOver = 0;

            while (ballInthisOver < 6) {
                ballInthisOver += 1;
                final BowlType bowlType = getBowlType();

                updateBattingStat(battingTeam, battingTeam.getTeam()
                                                          .getPlayerList()
                                                          .get(0), getRunType(bowlType));
                updateBowlingStat(bowlingTeam, bowlingTeam.getTeam()
                                                          .getPlayerList()
                                                          .get(0), bowlType);

            }

            currentOver += 1;
        }
    }

    private void updateBattingStat(final TeamInAMatch battingTeam, final Player player,
            final RunType runType) {
        final PlayerStatInMatch playerStatInMatch = battingTeam.getPlayerStatInMatch()
                                                               .get(player);
        final BattingStat battingStat = playerStatInMatch.getBattingStat();

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
        return BowlType.valueOf(bowlingType);
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
        }
        return RunType.INVALID;
    }

}
