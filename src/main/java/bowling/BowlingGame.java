package bowling;

public class BowlingGame {
    private static final int MAX_FRAMES = 11;

    private final Frame[] frames = new Frame[MAX_FRAMES];
    private int currentFrame = 1;
    private int currentRollInFrame = 0;

    public BowlingGame() {
        for (int i = 1; i < MAX_FRAMES; i++) {
            frames[i] = new Frame();
        }
        System.out.println(frames.length);
    }

    public void roll(int pins) {
        if (currentFrame == MAX_FRAMES) {
            return;
        }
        System.out.println("Roll in frame " + (currentFrame) + ": " + pins + " pins");
        Frame frame = frames[currentFrame];

        if (currentRollInFrame == 0) {
            frame.setFirstRoll(pins);
            currentRollInFrame++;
            if (pins == 10) {
                currentFrame++;
                currentRollInFrame = 0;
            }
        } else if (currentRollInFrame == 1) {
            frame.setSecondRoll(pins);
            currentRollInFrame++;
            if (currentFrame < MAX_FRAMES - 1) {
                currentFrame++;
                currentRollInFrame = 0;
            }
        } else if (currentRollInFrame == 2) {
            frame.setThirdRoll(pins);
        }
    }

    public int score() {
        int totalScore = 0;

        for (int frameIndex = 1; frameIndex < MAX_FRAMES; frameIndex++) {
            Frame frame = frames[frameIndex];
            int frameScore = frame.getFirstRoll() + frame.getSecondRoll();

            if (frame.isStrike()) {
                frameScore += strikeBonus(frameIndex);
            } else if (frame.isSpare()) {
                frameScore += spareBonus(frameIndex);
            }

            if (frameIndex == MAX_FRAMES - 1) {
                frameScore += frame.getThirdRoll();
            }

            frame.setScore(frameScore);
            totalScore += frameScore;
            System.out.println("Frame " + (frameIndex) + ": " + (frame.isStrike() ? "Strike" : frame.isSpare() ? "Spare" : "Open frame") + ", total score: " + totalScore);
        }

        return totalScore;
    }

    private int strikeBonus(int frameIndex) {
        if (frameIndex >= MAX_FRAMES - 1) {
            return 0;
        }
        int bonus = frames[frameIndex + 1].getFirstRoll();
        if (frames[frameIndex + 1].isStrike() && frameIndex < MAX_FRAMES - 2) {
            bonus += frames[frameIndex + 2].getFirstRoll();
        } else {
            bonus += frames[frameIndex + 1].getSecondRoll();
        }
        return bonus;
    }

    private int spareBonus(int frameIndex) {
        if (frameIndex >= MAX_FRAMES - 1) {
            return 0;
        }
        return frames[frameIndex + 1].getFirstRoll();
    }

    public static void main(String[] args) {
        BowlingGame game = new BowlingGame();

        int[] sampleRolls = {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};

        for (int roll : sampleRolls) {
            game.roll(roll);
        }
        System.out.println("Final Score: " + game.score());
    }
}
