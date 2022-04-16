package baseball.view.type;

public enum SwingResult {

    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String description;

    SwingResult(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
