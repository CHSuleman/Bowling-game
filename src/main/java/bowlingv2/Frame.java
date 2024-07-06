package bowlingv2;

public class Frame {
    Integer roll1;
    Integer roll2;
    private Integer roll3; // Only for the 10th frame
    private boolean isStrike;
    private boolean isSpare;

    public int getScore() {
        return score;
    }

    private int score;

    // Constructor for frames 1-9
    public Frame(Integer roll1, Integer roll2, boolean isStrike, boolean isSpare) {
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.isStrike = isStrike;
        this.isSpare = isSpare;
        this.roll3 = null; // Not applicable for frames 1-9
    }

    // Constructor for the 10th frame
    public Frame(Integer roll1, Integer roll2, Integer roll3, boolean isStrike, boolean isSpare) {
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
        this.isStrike = isStrike;
        this.isSpare = isSpare;
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
}
