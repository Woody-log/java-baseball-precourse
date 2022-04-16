package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGameView implements View {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    @Override
    public String inputString() {
        printMessage(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    private void printMessage(String message) {
        System.out.print(message);
    }

    private void printlnMessage(String message) {
        System.out.println(message);
    }
}
