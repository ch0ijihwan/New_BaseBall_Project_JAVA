package view;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {
    }

    public static String[] inputBaseballNumbers() {
        return SCANNER.next().split("");
    }

    public static boolean askNewRound() {
        return SCANNER.nextInt() == 1;
    }
}
