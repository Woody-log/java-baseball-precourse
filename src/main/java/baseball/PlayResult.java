package baseball;

public class PlayResult {
    private int strike;
    private int ball;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.strike += 1;
        }

        if (status.isBall()) {
            this.ball += 1;
        }
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }
}
