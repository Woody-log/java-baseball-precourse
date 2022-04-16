package baseball.service;

import baseball.model.Numbers;
import baseball.model.ResultDto;

import java.util.Objects;

public class BaseBallAnalyzer implements Analyzer {

    @Override
    public ResultDto analyze(final Numbers inputNumbers, final Numbers answerNumbers) {
        int ballCount = 0, strikeCount = 0;

        for (int i = 0; i < inputNumbers.size(); i++) {
            boolean isContains = answerNumbers.contains(inputNumbers.get(i));
            boolean isEquals = Objects.equals(inputNumbers.get(i), answerNumbers.get(i));
            ballCount = isBall(isContains, isEquals) ? ballCount + 1 : ballCount;
            strikeCount = isStrike(isEquals) ? strikeCount + 1 : strikeCount;
        }
        return new ResultDto(ballCount, strikeCount);
    }

    private boolean isBall(final boolean isContains, final boolean isEquals) {
        return (isContains && !isEquals);
    }

    private boolean isStrike(final boolean isEquals) {
        return isEquals;
    }
}
