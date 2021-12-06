import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private final List<Number> numbers;

    Numbers() {
        this.numbers = IntStream.rangeClosed(0, 15)
                .mapToObj(Number::new)
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

}
