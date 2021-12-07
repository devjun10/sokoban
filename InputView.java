import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputView {

    private Input input = new Input();

    private List<String> commands;

    InputView() {
        commands = Command.getCommands();
    };

    private class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<String> inputCommand() {
        String value;
        System.out.print(Message.SOKOBAN);
        List<String> words;
        while (true) {
            try {
                value = input.br.readLine().toLowerCase();
                words = validateCommandContains(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            } catch (Exception e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            }
        }
        return words;
    }

    private List<String> validateCommandContains(String direction) {
        List<String> words = new ArrayList<>();
        Objects.requireNonNull(direction);
        if(direction.isBlank() || direction.isEmpty()){
            throw new IllegalArgumentException();
        }
        String[] temp = direction.split("");
        for(int number= 0; number<temp.length; number++){
            if (!commands.contains(temp[number])) {
                words.add(String.valueOf(Command.INVALID_COMMAND));
                continue;
            }
            words.add(temp[number]);
        }
        if(words.isEmpty()){
            throw new IllegalArgumentException();
        }
        return words;
    }
}