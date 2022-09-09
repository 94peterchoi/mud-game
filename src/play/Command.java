package play;

public class Command {

    String command;

    public Command(String command) {
        if (command.equals("q") || command.equals("w") || command.equals("e") || command.equals("r")) {
            this.command = command;
            return;
        }
        throw new IllegalArgumentException("잘못된 커맨드 키 오류");
    }

    public String getCommand() {
        return command;
    }
}
