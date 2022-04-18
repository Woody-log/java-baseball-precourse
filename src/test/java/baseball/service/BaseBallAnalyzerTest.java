package baseball.service;

import baseball.model.Numbers;
import baseball.model.ResultDto;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallAnalyzerTest {

    Analyzer analyzer = new BaseBallAnalyzer();

    @Test
    @DisplayName("낫싱 테스트")
    void nothing_test() {
        // given
        Numbers inputNumbers = getInputNumbers();
        Numbers answerNumbers = new Numbers("123");

        // when
        ResultDto resultDto = analyzer.analyze(inputNumbers, answerNumbers);

        // then
        assertThat(resultDto.getBallCount()).isEqualTo(0);
        assertThat(resultDto.getStrikeCount()).isEqualTo(0);
        assertThat(resultDto.isNothing()).isTrue();
    }

    @Test
    @DisplayName("볼 카운트 테스트")
    void ball_count_test() {
        // given
        Numbers inputNumbers = new Numbers("357");
        Numbers answerNumbers = new Numbers("123");

        // when
        ResultDto resultDto = analyzer.analyze(inputNumbers, answerNumbers);

        // then
        assertThat(resultDto.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크 카운트 테스트")
    void strike_count_test() {
        // given
        Numbers inputNumbers = new Numbers("123");
        Numbers answerNumbers = new Numbers("123");

        // when
        ResultDto resultDto = analyzer.analyze(inputNumbers, answerNumbers);

        // then
        assertThat(resultDto.getStrikeCount()).isEqualTo(3);

    }

    private Numbers getInputNumbers() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != 3) {
            set.add(Randoms.pickNumberInRange(7, 9));
        }
        List<Integer> numbers = new ArrayList<>(set);
        List<Integer> shuffle = Randoms.shuffle(numbers);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : shuffle) {
            stringBuilder.append(integer);
        }
        return new Numbers(stringBuilder.toString());
    }
}