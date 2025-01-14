package baseball.controller;

import baseball.model.Numbers;
import baseball.model.ResultDto;
import baseball.service.Analyzer;
import baseball.type.Command;
import baseball.view.View;

public class BaseBallGame implements Game {

    private final View view;
    private final Analyzer analyzer;

    public BaseBallGame(final View view, final Analyzer analyzer) {
        this.view = view;
        this.analyzer = analyzer;
    }

    @Override
    public void start() {
        Numbers answerNumbers = Numbers.getRandomNumbers();
        boolean isGameOver = false;

        while (!isGameOver) {
            Numbers inputNumbers = drawBall();
            ResultDto resultDto = swingBat(inputNumbers, answerNumbers);
            view.showResult(resultDto);
            isGameOver = isGameOver(resultDto);
            answerNumbers = getNumberForRestart(resultDto, isGameOver, answerNumbers);
        }
    }

    private Numbers drawBall() {
        return new Numbers(view.inputString());
    }

    private ResultDto swingBat(final Numbers inputNumbers, final Numbers answerNumbers) {
        return analyzer.analyze(inputNumbers, answerNumbers);
    }

    private boolean isGameOver(final ResultDto resultDto) {
        if (resultDto.getStrikeCount() == 3) {
            view.showEnding();
            Command command = view.inputCommand();
            return command == Command.GAME_OVER;
        }
        return false;
    }

    private Numbers getNumberForRestart(final ResultDto resultDto, final boolean isGameOver,
                                        final Numbers answerNumbers) {
        if (resultDto.getStrikeCount() == 3 && !isGameOver) {
            return Numbers.getRandomNumbers();
        }
        return answerNumbers;
    }
}
