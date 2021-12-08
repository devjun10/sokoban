import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Choice {

    YES("y"), NO("n");

    private final String description;

    Choice(String description) {
        this.description = description;
    }

    public String cotent() {
        return description;
    }

    public static List<String> getChoices() {
        return Stream.of(values())
                .map(Choice::cotent)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        return description;
    }
}
