package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setup() {
        com = new Ball(1, 4);
    }

    @Test
    public void strike() throws Exception {
        //when
        BallStatus status = com.play(new Ball(1, 4));

        //then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    public void ball() throws Exception {
        //when
        BallStatus status = com.play(new Ball(2, 4));

        //then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    public void noting() throws Exception {
        //when
        BallStatus status = com.play(new Ball(2, 5));

        //then
        assertThat(status).isEqualTo(BallStatus.NOTING);
    }
}
