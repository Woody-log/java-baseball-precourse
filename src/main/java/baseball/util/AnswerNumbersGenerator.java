package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerNumbersGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int SIZE = 3;

    private AnswerNumbersGenerator() {
    }

    public static String generate() {
        final Set<Integer> set = new HashSet<>();

        while (set.size() != SIZE) {
            set.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }

        return convertToString(new ArrayList<>(set));
    }

    private static String convertToString(final List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : list) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }
}
