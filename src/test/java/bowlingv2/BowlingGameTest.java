package bowlingv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BowlingGameTest {

    @Test
     void testPrintRollsAndScores() {
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame(1, 4, false, false));
        frames.add(new Frame(4, 5, false, false));
        frames.add(new Frame(6, 4, false, true));
        frames.add(new Frame(5, 5, false, true));
        frames.add(new Frame(10, null, true, false));
        frames.add(new Frame(0, 1, false, false));
        frames.add(new Frame(7, 3, false, true));
        frames.add(new Frame(6, 4, false, true));
        frames.add(new Frame(10, null, true, false));
        frames.add(new Frame(2, 8, 6, false, false));

        Assertions.assertEquals(133, BowlingGame.printRollsAndScores(frames));
    }
}
