package baseball.model;

import baseball.exception.ErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumbersTest {

    @Test
    @DisplayName("null 검사")
    void validateNull() {
        assertThatThrownBy(() -> new Numbers(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_INPUT_STRING_NULL.getErrorMessage());
    }

    @Test
    @DisplayName("문자열 길이 검사 - 세자리 보다 클 때")
    void validateLength_more_than_three() {
        assertThatThrownBy(() -> new Numbers("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.ONLY_TREE_DIGITS.getErrorMessage());
    }

    @Test
    @DisplayName("문자열 길이 검사 - 세자리 보다 작을 때")
    void validateLength_less_than_three() {
        assertThatThrownBy(() -> new Numbers("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.ONLY_TREE_DIGITS.getErrorMessage());
    }

    @Test
    @DisplayName("중복문자열 검사")
    void validateDuplicate() {
        assertThatThrownBy(() -> new Numbers("333"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.EXIST_DUPLICATE_STRING.getErrorMessage());
    }

    @Test
    @DisplayName("숫자 문자열인지 검사")
    void validateNumber() {
        assertThatThrownBy(() -> new Numbers("12A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.ONLY_NUMBERS_ALLOW.getErrorMessage());
    }

    @Test
    @DisplayName("size 함수 검사")
    void size() {
        Numbers numbers = new Numbers("123");
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    @DisplayName("contains 함수 true case")
    void contains_success(int input) {
        Numbers numbers = new Numbers("423");

        Assertions.assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 6, 7, 8, 9, 0})
    @DisplayName("contains 함수 false case")
    void contains_fail(int input) {
        Numbers numbers = new Numbers("423");
        Assertions.assertThat(numbers.contains(input)).isFalse();
    }

    @Test
    @DisplayName("get 함수 검사")
    void get() {
        Numbers numbers = new Numbers("512");

        Assertions.assertThat(numbers.get(0)).isEqualTo(5);
        Assertions.assertThat(numbers.get(1)).isEqualTo(1);
        Assertions.assertThat(numbers.get(2)).isEqualTo(2);
        assertThrows(IndexOutOfBoundsException.class, () -> numbers.get(4));
    }
}