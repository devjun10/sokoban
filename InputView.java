import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputView {

    private Input input = new Input();

    private class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputMap() {
        String inputValue;
        while (true) {
            try {
                inputValue = input.br.readLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            } catch (Exception e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            }
        }
        return inputValue;
    }


}
