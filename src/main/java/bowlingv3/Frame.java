package bowlingv3;

public class Frame {
    private Integer roll1;
    private Integer roll2;
    private Integer roll3; // Only for the 10th frame
    private boolean isStrike;
    private boolean isSpare;
    private int score;

    // Constructor for frames 1-9
    public Frame(Integer roll1, Integer roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = null; // Not applicable for frames 1-9
    }

    // Constructor for the 10th frame
    public Frame(Integer roll1, Integer roll2, Integer roll3) {
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
    }

    public Integer getRoll1() {
        return roll1;
    }

    public Integer getRoll2() {
        return roll2;
    }

    public Integer getRoll3() {
        return roll3;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public void setSpare(boolean spare) {
        isSpare = spare;
    }

    public void setRoll1(Integer roll1) {
        this.roll1 = roll1;
    }

    public void setRoll2(Integer roll2) {
        this.roll2 = roll2;
    }

    public void setRoll3(Integer roll3) {
        this.roll3 = roll3;
    }

    public int getScore() {
        return score;
    }
}