package baseball.model;

import baseball.exception.ErrorCode;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    private final List<Integer> numberList;
    private final Set<Integer> numberSet;

    public Numbers(final String inputString) {
        validate(inputString);
        numberList = convertNumberList(inputString);
        numberSet = new HashSet<>(numberList);
    }

    private Numbers(final List<Integer> numberList) {
        this.numberList = numberList;
        this.numberSet = new HashSet<>(numberList);
    }

    public static Numbers getRandomNumbers() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        return new Numbers(new ArrayList<>(set));
    }

    public int size() {
        return numberList.size();
    }

    public Integer get(final int index) {
        return numberList.get(index);
    }

    public boolean contains(final Integer number) {
        return numberSet.contains(number);
    }

    private List<Integer> convertNumberList(final String inputString) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            String character = String.valueOf(inputString.charAt(i));
            Integer number = Integer.parseInt(character);
            numbers.add(number);
        }
        return numbers;
    }

    private void validate(final String inputString) {
        validateNull(inputString);
        validateLength(inputString);
        validateDuplicate(inputString);
        validateNumber(inputString);
    }

    private void validateNumber(final String inputString) {
        final String REGEX = "[0-9]+";
        if (!inputString.matches(REGEX)) {
            throwIllegalArgumentException(ErrorCode.ONLY_NUMBERS_ALLOW);
        }
    }

    private void validateNull(final String inputString) {
        if (inputString == null) {
            throwIllegalArgumentException(ErrorCode.INVALID_INPUT_STRING_NULL);
        }
    }

    private void validateLength(final String inputString) {
        if (inputString.length() != 3) {
            throwIllegalArgumentException(ErrorCode.ONLY_TREE_DIGITS);
        }
    }

    private void validateDuplicate(final String inputString) {
        Set<Character> set = new HashSet<>();
        char[] chars = inputString.toCharArray();

        for (char aChar : chars) {
            set.add(aChar);
        }

        if (set.size() != chars.length) {
            throwIllegalArgumentException(ErrorCode.EXIST_DUPLICATE_STRING);
        }
    }

    private void throwIllegalArgumentException(ErrorCode errorCode) {
        throw new IllegalArgumentException(errorCode.getErrorMessage());
    }
}
