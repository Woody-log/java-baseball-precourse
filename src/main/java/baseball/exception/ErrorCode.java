package baseball.exception;

public enum ErrorCode {

    INVALID_INPUT_STRING_NULL("입력값이 null 입니다."),
    ONLY_TREE_DIGITS("세 자리만 허용합니다."),
    EXIST_DUPLICATE_STRING("중복된 문자가 존재합니다."),
    ONLY_NUMBERS_ALLOW("숫자만 입력 가능합니다.");

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
