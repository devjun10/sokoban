package utils;

import static utils.Number.*;

public class Parser {

    public static final String COMMA = ",";
    public static final String BAR = "==========";
    public static final String NO_BLANK = "";

    public static String[] splitByComma(String word) {
        return word.split(COMMA);
    }

    public static String[] splitByStage(String word) {
        return word.split(BAR);
    }

    public static String replaceBar(String word) {
        return word.replace(BAR, NO_BLANK);
    }

    public static Number changeStringSymbol(String value) {
        if (value.equals(FOUR.getSymbol())) return FOUR;
        if (value.equals(ZERO.getSymbol())) return ZERO;
        if (value.equals(ONE.getSymbol())) return ONE;
        if (value.equals(TWO.getSymbol())) return TWO;
        if (value.equals(THREE.getSymbol())) return THREE;
        if (value.equals(NINE.getSymbol())) return NINE;
        return Number.ZERO;
    }

    public static String changeIntSymbol(Number value) {
        if (value == FIVE) return FIVE.getSymbol();
        if (value == ZERO) return ZERO.getSymbol();
        if (value == ONE) return ONE.getSymbol();
        if (value == TWO) return TWO.getSymbol();
        if (value == THREE) return THREE.getSymbol();
        if (value == FOUR) return FOUR.getSymbol();
        return NINE.getSymbol();
    }
}