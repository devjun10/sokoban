import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputView {

    private Input input = new Input();

    private List<String> commands;
    private List<String> choices;

    InputView() {
        commands = Command.getCommands();
        choices = Choice.getChoices();
    }

    ;

    private class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputChoice() {
        String value;
        System.out.print(Message.ASK_LOAD_STAGE_DATA);

        while (true) {
            try {
                value = input.br.readLine().toLowerCase();
                validateChoice(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            } catch (Exception e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            }
        }
        return value;
    }

    private void validateChoice(String choice) {
        if (!choices.contains(choice)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_VALUE.toString());
        }
    }

    public int inputStageNumber() {
        int value;
        System.out.print(Message.ASK_STAGE_NUMBER);

        while (true) {
            try {
                value = Integer.parseInt(input.br.readLine().toLowerCase());
                validateStageNumber(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            } catch (Exception e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            }
        }
        return value;
    }

    private void validateStageNumber(int stageNumber) {
        if (stageNumber <= 0 || stageNumber > 4) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_VALUE.toString());
        }
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
        if (direction.isBlank() || direction.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] temp = direction.split("");
        for (int number = 0; number < temp.length; number++) {
            if (!commands.contains(temp[number])) {
                continue;
            }
            words.add(temp[number]);
        }
        if (words.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return words;
    }
}