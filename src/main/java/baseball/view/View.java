package baseball.view;

import baseball.model.ResultDto;
import baseball.type.Command;

public interface View {

    String inputString();

    void showResult(final ResultDto resultDto);

    void showEnding();

    Command inputCommand();
}
