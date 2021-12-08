import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Choice {
    YES("yes"), NO("no");

    private final String description;

    Choice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static List<String> getChoices() {
        return Stream.of(values())
                .map(Choice::getDescription)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        return description;
    }
}
