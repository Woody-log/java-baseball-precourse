package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> answers) {
        List<Ball> balls = mapBall(answers);
        this.answers = balls;
    }

    private List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        PlayResult playResult = new PlayResult();
        for (Ball answer : answers) {
            BallStatus status = userBalls.play(answer);
            playResult.report(status);
        }

        return playResult;
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNoting)
                .findFirst()
                .orElse(BallStatus.NOTING);
    }
}

