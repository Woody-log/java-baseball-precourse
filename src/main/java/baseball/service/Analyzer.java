package baseball.service;

import baseball.model.Numbers;
import baseball.model.ResultDto;

public interface Analyzer {

    ResultDto analyze(final Numbers inputNumbers, final Numbers answerNumbers);
}
