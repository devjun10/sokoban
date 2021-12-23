package view;

import view.commands.Choice;
import view.commands.SystemInputCommand;
import view.message.ErrorMessage;
import view.message.SystemMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utils.Parser.NO_BLANK;
import static view.commands.DirectionCommand.getDirectionCommands;
import static view.commands.SystemInputCommand.getSystemInputCommands;

public class InputView {

    private Input input = new Input();

    private List<String> commands;
    private List<String> choices;

    public InputView() {
        commands = getDirectionCommands();
        commands.addAll(getSystemInputCommands());
        choices = Choice.getChoices();
    };

    private class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputStage() {
        String value;

        while (true) {
            try {
                value = input.br.readLine().toLowerCase();
                System.out.println(value);
                validateStage(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            } catch (Exception e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            }
        }
        return value;
    }

    private void validateStage(String choice) {
        int number = Integer.parseInt(choice.substring(0, 1));
        String command = choice.substring(1, 2).toLowerCase();
        if (number >= 5 || number < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_VALUE.toString());
        }
        if (!command.equals(SystemInputCommand.L.getCommand())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_VALUE.toString());
        }
    }

    public List<String> inputCommand() {
        String value;
        System.out.print(SystemMessage.SOKOBAN);
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
        String[] temp = direction.split(NO_BLANK);
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