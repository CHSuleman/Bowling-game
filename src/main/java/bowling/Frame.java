package bowling;

public class Frame {
    private Integer firstRoll;
    private Integer secondRoll;
    private Integer thirdRoll; // Used only in the 10th frame if needed
    private boolean isStrike;
    private boolean isSpare;
    private int score;

    public Frame() {
        this.firstRoll = 0;
        this.secondRoll = 0;
        this.thirdRoll = 0;
        this.isStrike = false;
        this.isSpare = false;
        this.score = 0;
    }

    public Frame(Integer firstRoll, Integer secondRoll, Integer thirdRoll, boolean isStrike, boolean isSpare) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.thirdRoll = thirdRoll;
        this.isStrike = isStrike;
        this.isSpare = isSpare;
        this.score = 0;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
        if (firstRoll == 10) {
            this.isStrike = true;
        }
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
        if (firstRoll + secondRoll == 10 && !isStrike) {
            this.isSpare = true;
        }
    }

    public int getThirdRoll() {
        return thirdRoll;
    }

    public void setThirdRoll(int thirdRoll) {
        this.thirdRoll = thirdRoll;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
