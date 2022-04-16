package baseball;

import baseball.config.AppConfig;
import baseball.controller.Game;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Game baseballGame = appConfig.game();

        baseballGame.start();
    }
}
