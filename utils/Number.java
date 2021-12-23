package utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Number {

    ZERO(0, " "),
    ONE(1, "O"),
    TWO(2, "o"),
    THREE(3, "0"),
    FOUR(4, "P"),
    FIVE(5, "P"),
    SIX(6, "UNDEFINED"),
    SEVEN(7, "UNDEFINED"),
    EIGHT(8, "UNDEFINED"),
    NINE(9, "#");

    private final int value;
    private final String symbol;

    Number(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public static Number findNumber(int inputNumber) {
        return Arrays.stream(values())
                .filter(number -> number.getIntvalue() == inputNumber)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getIntvalue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return value + "";
    }

}
