package baseball.service;

import baseball.model.Numbers;
import baseball.model.ResultDto;

public interface Analyzer {

    void analyze(final Numbers inputNumbers, final Numbers answerNumbers);

    boolean isCorrect();

    ResultDto getResult();
}
