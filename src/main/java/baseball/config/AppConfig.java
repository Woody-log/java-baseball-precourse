package baseball.config;

import baseball.controller.BaseBallGame;
import baseball.controller.Game;
import baseball.service.Analyzer;
import baseball.service.BaseBallAnalyzer;
import baseball.view.BaseBallGameView;
import baseball.view.View;

public class AppConfig {

    public View view() {
        return new BaseBallGameView();
    }

    public Analyzer analyzer() {
        return new BaseBallAnalyzer();
    }

    public Game game() {
        return new BaseBallGame(view(), analyzer());
    }
}
