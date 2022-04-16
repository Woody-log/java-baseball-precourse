package baseball.model;

public class ResultDto {

    private final int ballCount;
    private final int strikeCount;

    public ResultDto(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }
}
