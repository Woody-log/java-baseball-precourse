package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls answers;

    @BeforeEach
    void setup() {
        answers = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    public void play() throws Exception {
        //when
        PlayResult result = answers.play(Arrays.asList(4, 5, 6));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    public void strike() throws Exception {
        //when
        BallStatus status = answers.play(new Ball(1, 1));

        //then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        //when
        BallStatus status = answers.play(new Ball(1, 3));

        //then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        //when
        BallStatus status = answers.play(new Ball(1, 4));

        //then
        assertThat(status).isEqualTo(BallStatus.NOTING);
    }
}
