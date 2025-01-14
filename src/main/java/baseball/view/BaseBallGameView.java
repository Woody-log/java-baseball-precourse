package baseball.view;

import baseball.model.ResultDto;
import baseball.type.Command;
import baseball.type.SwingResult;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGameView implements View {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_COMMAND = "게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요.";
    private final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public String inputString() {
        printMessage(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    @Override
    public void showResult(final ResultDto resultDto) {
        stringBuilder.setLength(0);
        if (!isNothing(resultDto)) {
            appendResult(resultDto);
            printlnMessage(stringBuilder.toString());
            return;
        }
        printlnMessage(SwingResult.NOTHING.getDescription());
    }

    @Override
    public void showEnding() {
        System.out.println(GAME_OVER_MESSAGE);
    }

    @Override
    public Command inputCommand() {
        printlnMessage(INPUT_COMMAND);
        return Command.getCommand(Console.readLine());
    }

    private boolean isNothing(final ResultDto resultDto) {
        return resultDto == null || resultDto.isNothing();
    }

    private void appendResult(final ResultDto resultDto) {
        appendCount(resultDto.getBallCount(), SwingResult.BALL);
        appendSpace();
        appendCount(resultDto.getStrikeCount(), SwingResult.STRIKE);
    }

    private void appendCount(final Integer count, final SwingResult swingResult) {
        if (count != 0) {
            stringBuilder.append(count)
                    .append(swingResult.getDescription());
        }
    }

    private void appendSpace() {
        if (stringBuilder.length() != 0) {
            stringBuilder.append(" ");
        }
    }

    private void printMessage(String message) {
        System.out.print(message);
    }

    private void printlnMessage(String message) {
        System.out.println(message);
    }
}
