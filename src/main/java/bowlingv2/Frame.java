package bowlingv2;

public class Frame {

    private Integer roll1;
    private Integer roll2;
    private Integer roll3;
    private boolean isStrike;
    private boolean isSpare;

    public Frame(Integer roll1, Integer roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = null;
    }

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
}
