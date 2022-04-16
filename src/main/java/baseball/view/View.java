package baseball.view;

import baseball.model.ResultDto;

public interface View {

    String inputString();

    void showResult(final ResultDto resultDto);

    void showEnding();
}
