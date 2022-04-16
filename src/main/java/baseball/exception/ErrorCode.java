package baseball.exception;

public enum ErrorCode {
    // number 관련 에러
    INVALID_INPUT_STRING_NULL("입력값이 null 입니다."),
    ONLY_TREE_DIGITS("세 자리만 허용합니다."),
    EXIST_DUPLICATE_STRING("중복된 문자가 존재합니다."),
    ONLY_NUMBERS_ALLOW("숫자만 입력 가능합니다."),

    // command 관련 에러
    INVALID_COMMAND("잘못된 명령어입니다.");

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
