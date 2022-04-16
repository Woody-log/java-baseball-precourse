package baseball.service;

import baseball.model.Numbers;

import java.util.Objects;

public class BaseBallAnalyzer implements Analyzer {

    private int ballCount;
    private int strikeCount;

    public void init() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    @Override
    public void analyze(final Numbers inputNumbers, final Numbers answerNumbers) {
        init();
        countSwing(inputNumbers, answerNumbers);
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
}
