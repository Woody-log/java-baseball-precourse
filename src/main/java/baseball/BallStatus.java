package baseball;

public enum BallStatus {
    NOTING,
    STRIKE,
    BALL;

    public boolean isNotNoting() {
        return this != BallStatus.NOTING;
    }

    public boolean isStrike() {
        return this == BallStatus.STRIKE;
    }

    public boolean isBall() {
        return this == BallStatus.BALL;
    }

}
