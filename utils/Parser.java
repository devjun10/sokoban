package utils;

public class Parser {
    public static String[] splitByComma(String word) {
        return word.split(",");
    }

    public static String[] splitByStage(String word) {
        return word.split("==========");
    }

    public static String replaceBar(String word) {
        return word.replace("==========", "");
    }

    public static int changeStringSymbol(String value) {
        if (value.equals("P")) return 4;
        if (value.equals(" ")) return 0;
        if (value.equals("O")) return 1;
        if (value.equals("o")) return 2;
        if (value.equals("0")) return 3;
        if (value.equals("#")) return 9;
        return 0;
    }

    public static String changeIntSymbol(int value) {
        if (value == 5) return "P";
        if (value == 0) return " ";
        if (value == 1) return "O";
        if (value == 2) return "o";
        if (value == 3) return "0";
        if (value == 4) return "P";
        return "#";
    }

}