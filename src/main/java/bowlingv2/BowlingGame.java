package bowlingv2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private static final Logger logger = LoggerFactory.getLogger(BowlingGame.class);

    private static final int MAX_FRAMES = 10;

    protected static Integer printRollsAndScores(List<Frame> frames) {
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
        int frameScore = calculateBasicFrameScore(frame);

        if (frameIndex == frames.size() - 1 && frame.getRoll3() != null) {
                frameScore += frame.getRoll3();
            }
        applyStrikeOrSpareFlags(frame, frameScore);
        frameScore += applyBonuses(frame, frameIndex, frames);

        return frameScore;
    }

    private static int calculateBasicFrameScore(Frame frame) {
        if (frame.getRoll2() != null) {
            return frame.getRoll1() + frame.getRoll2();
        } else {
            return frame.getRoll1();
        }
    }

    private static void applyStrikeOrSpareFlags(Frame frame, int frameScore) {
        if (frame.getRoll1() != null && frame.getRoll1() == 10) {
            frame.setStrike(true);
        } else if (frame.getRoll2() != null && frame.getRoll2() == 10) {
            frame.setStrike(true);
        } else if (frameScore == 10) {
            frame.setSpare(true);
        }
    }

    private static int applyBonuses(Frame frame, int frameIndex, List<Frame> frames) {
        int bonus = 0;

        if (frame.isStrike()) {
            bonus += strikeBonus(frameIndex, frames);
        } else if (frame.isSpare()) {
            bonus += spareBonus(frameIndex, frames);
        }
        return bonus;
    }

    private static int strikeBonus(int frameIndex, List<Frame> frames) {
        if (frameIndex >= MAX_FRAMES - 1) {
            return 0;
        }

        Frame nextFrame = frames.get(frameIndex + 1);
        int bonus = nextFrame.getRoll1() != null ? nextFrame.getRoll1() : 0;
        if (bonus == 10 && frameIndex < MAX_FRAMES - 2) {
            Frame nextNextFrame = frames.get(frameIndex + 2);
            bonus += nextNextFrame.getRoll1() != null ? nextNextFrame.getRoll1() : 0;
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
        return nextFrame.getRoll1() != null ? nextFrame.getRoll1() : 0;
    }

    private static void logFrameDetails(Frame frame, int frameIndex, int totalScore, boolean isLastFrame) {
        logger.info("Roll in frame {}: {} pins", (frameIndex + 1), frame.getRoll1() != null ? frame.getRoll1() : "Gutter");
        if (frame.getRoll2() != null) {
            logger.info("Roll in frame {}: {} pins", (frameIndex + 1), frame.getRoll2() != null ? frame.getRoll2() : "Gutter");
        }
        if (isLastFrame) {
            logger.info("Roll in frame {}: {} pins", (frameIndex + 2), frame.getRoll3() != null ? frame.getRoll3() : "0");
        }
        logger.info("Frame {}: total score: {}", (frameIndex + 1), totalScore);
    }

    public static void main(String[] args) {
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

        logger.info("Final Score: {}", printRollsAndScores(frames));
    }
}
