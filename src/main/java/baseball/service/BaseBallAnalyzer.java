package baseball.service;

import baseball.model.Numbers;
import baseball.model.ResultDto;

import java.util.Objects;

public class BaseBallAnalyzer implements Analyzer {

    private int ballCount;
    private int strikeCount;
    private boolean isAllStrike;

    public void init() {
        this.ballCount = 0;
        this.strikeCount = 0;
        this.isAllStrike = false;
    }

    @Override
    public void analyze(final Numbers inputNumbers, final Numbers answerNumbers) {
        init();
        countSwing(inputNumbers, answerNumbers);
        checkAllStrike();
    }

    @Override
    public ResultDto getResult() {
        return new ResultDto(ballCount, strikeCount);
    }

    @Override
    public boolean isCorrect() {
        return isAllStrike;
    }

    private void countSwing(final Numbers inputNumbers, final Numbers answerNumbers) {
        for (int i = 0; i < inputNumbers.size(); i++) {
            boolean isContains = answerNumbers.contains(inputNumbers.get(i));
            boolean isEquals = Objects.equals(inputNumbers.get(i), answerNumbers.get(i));
            countBall(isContains, isEquals);
            countStrike(isEquals);
        }
    }

    private void countBall(boolean isContains, boolean isEquals) {
        if (isContains && !isEquals) {
            ballCount++;
        }
    }

    private void countStrike(boolean isEquals) {
        if (isEquals) {
            strikeCount++;
        }
    }

    private void checkAllStrike() {
        if (strikeCount == 3) {
            isAllStrike = true;
        }
    }
}
