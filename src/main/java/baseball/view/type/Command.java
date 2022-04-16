package baseball.view.type;

import baseball.exception.ErrorCode;

import java.util.HashMap;
import java.util.Map;

public enum Command {
    
    RESTART,
    GAME_OVER;

    public static final Map<String, Command> commandMapping = new HashMap<>();

    static {
        commandMapping.put("1", RESTART);
        commandMapping.put("2", GAME_OVER);
    }

    public static Command getCommand(String commandType) {
        Command command = commandMapping.get(commandType);
        if (command == null) {
            throw new IllegalArgumentException(ErrorCode.INVALID_COMMAND.getErrorMessage());
        }
        return command;
    }
}
