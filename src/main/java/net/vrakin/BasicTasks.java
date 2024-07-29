package net.vrakin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class BasicTasks {

    public static final String SPACE = " ";
    public static final int MINIMAL_COUNT_SYMBOL = 4;
    public static final int MAXIMUM_COUNT_SYMBOL = 14;
    public static final int BEGIN_INDEX = 0;
    public static final char CHAR_B = 'b';

    public static long countB(String string) {
        return string.chars().filter(ch -> ch == CHAR_B).count();
    }

    public static String longestWord(String string) {
        Optional<String> result =
                Arrays.stream(string.split(SPACE))
                        .max(Comparator.comparingInt(String::length));
        if (result.isPresent()) {
            return result.get();
        } else throw new RuntimeException("No word found");
    }

    public static void piPrint() {
        String pi = Math.PI + "";
        for (int i = MINIMAL_COUNT_SYMBOL; i < MAXIMUM_COUNT_SYMBOL; i++) {
            System.out.println(pi.substring(BEGIN_INDEX, i));
        }
    }
}
