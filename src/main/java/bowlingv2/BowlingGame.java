package bowlingv2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private static final Logger logger = LoggerFactory.getLogger(BowlingGame.class);
    private static final int MAX_FRAMES = 10;

    public static Integer printRollsAndScores(List<Frame> frames) {
        int totalScore = 0;

        for (int frameIndex = 0; frameIndex < frames.size(); frameIndex++) {
            Frame frame = frames.get(frameIndex);
            int frameScore = calculateFrameScore(frame, frameIndex, frames);
            totalScore += frameScore;
            logFrameDetails(frame, frameIndex, totalScore, frameIndex == frames.size() - 1);
        }
        return totalScore;
    }

    private static int calculateFrameScore(Frame frame, int frameIndex, List<Frame> frames) {
        int frameScore;
        if (frame.getRoll1() != 10 && frameIndex != frames.size() - 1) {
            frameScore = frame.getRoll1() + frame.getRoll2();
        } else if (frameIndex == frames.size() - 1) {
            frameScore = frame.getRoll1() + frame.getRoll2() + frame.getRoll3();
        } else {
            frameScore = frame.getRoll1();
        }

        if (frame.isStrike()) {
            frameScore += strikeBonus(frameIndex, frames);
        } else if (frame.isSpare()) {
            frameScore += spareBonus(frameIndex, frames);
        }

        return frameScore;
    }

    private static void logFrameDetails(Frame frame, int frameIndex, int totalScore, boolean isLastFrame) {
        logger.info("Roll in frame {}: {} pins", (frameIndex + 1), frame.getRoll1());
        if (frame.getRoll2() != null) {
            logger.info("Roll in frame {}: {} pins", (frameIndex + 1), frame.getRoll2());
        }
        if (isLastFrame) {
            logger.info("Roll in frame {}: {} pins", (frameIndex + 2), (frame.getRoll3() != null ? frame.getRoll3() : "0"));
        }
        logger.info("Frame {}: total score: {}", (frameIndex + 1),  totalScore);
    }

    private static int strikeBonus(int frameIndex, List<Frame> frames) {
        if (frameIndex >= MAX_FRAMES - 1) {
            return 0;
        }

        Frame nextFrame = frames.get(frameIndex + 1);
        int bonus = nextFrame.getRoll1();
        if (nextFrame.isStrike() && frameIndex < MAX_FRAMES - 2) {
            Frame nextNextFrame = frames.get(frameIndex + 2);
            bonus += nextNextFrame.getRoll1();
        } else {
            bonus += nextFrame.getRoll2() != null ? nextFrame.getRoll2() : 0;
        }

        return bonus;
    }

    private static int spareBonus(int frameIndex, List<Frame> frames) {
        if (frameIndex >= MAX_FRAMES - 1) {
            return 0;
        }

        Frame nextFrame = frames.get(frameIndex + 1);
        return nextFrame.getRoll1();
    }

    public static void main(String[] args) {
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

        logger.info("Final Score: {}", printRollsAndScores(frames));
    }
}
