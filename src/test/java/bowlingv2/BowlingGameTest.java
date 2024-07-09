package bowlingv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BowlingGameTest {

    @Test
    @DisplayName("Test Rolls and Scores: Mixed Rolls")
    void testRollsAndScores_MixedRolls() {
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame(1, 4));
        frames.add(new Frame(4, 5));
        frames.add(new Frame(6, 4));
        frames.add(new Frame(5, 5));
        frames.add(new Frame(10, null));
        frames.add(new Frame(0, 1));
        frames.add(new Frame(7, 3));
        frames.add(new Frame(6, 4));
        frames.add(new Frame(10, null));
        frames.add(new Frame(2, 8, 6));

        Assertions.assertEquals(133, BowlingGame.printRollsAndScores(frames));
    }

    @Test
    @DisplayName("Test Rolls and Scores: Spares and Strikes")
    void testRollsAndScores_SparesAndStrikes() {
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame(8, 1));
        frames.add(new Frame(6, 4));
        frames.add(new Frame(8, 2));
        frames.add(new Frame(0, 4));
        frames.add(new Frame(10, null));
        frames.add(new Frame(6, 3));
        frames.add(new Frame(8, 2));
        frames.add(new Frame(7, 2));
        frames.add(new Frame(2, 0));
        frames.add(new Frame(5, 4, null));

        Assertions.assertEquals(106, BowlingGame.printRollsAndScores(frames));
    }

    @Test
    @DisplayName("Test Rolls and Scores: Strikes and Spares")
    void testRollsAndScores_StrikesAndSpares() {
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, null));
        frames.add(new Frame(7, 3));
        frames.add(new Frame(8, 1));
        frames.add(new Frame(10, null));
        frames.add(new Frame(4, 2));
        frames.add(new Frame(5, 4));
        frames.add(new Frame(7, 3));
        frames.add(new Frame(9, 0));
        frames.add(new Frame(10, 10, 7));

        Assertions.assertEquals(160, BowlingGame.printRollsAndScores(frames));
    }

    @Test
    @DisplayName("Test Rolls and Scores: Perfect Game")
    void testRollsAndScores_PerfectGame() {
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, null));
        frames.add(new Frame(10, 10, 10));

        Assertions.assertEquals(300, BowlingGame.printRollsAndScores(frames));
    }

    @Test
    @DisplayName("Test Rolls and Scores: Gutter Game")
    void testRollsAndScores_GutterGame() {
        List<Frame> frames = new ArrayList<>();
        frames.add(new Frame(0, 0));
        frames.add(new Frame(0, 0));
        frames.add(new Frame(0, 0));
        frames.add(new Frame(0, 0));
        frames.add(new Frame(0, 0));
        frames.add(new Frame(0, 0));
        frames.add(new Frame(0, 0));
        frames.add(new Frame(0, 0));
        frames.add(new Frame(0, 0));
        frames.add(new Frame(0, 0, 0));

        Assertions.assertEquals(0, BowlingGame.printRollsAndScores(frames));
    }
}
