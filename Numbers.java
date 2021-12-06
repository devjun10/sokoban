import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private static List<Number> numbers = null;

    static {
        numbers = IntStream.rangeClosed(0, 15)
                .mapToObj(Number::new)
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    static Number getValue(int value){
        return numbers.get(value);
    }


    public static void main(String[] args) throws Exception {
        String word ="asdf asdf sdafas asd fas dfas dfa sdfsa dfs";
    }

}