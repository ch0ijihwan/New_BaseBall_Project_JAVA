package view;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {

    }

    public static String[] inputBaseballNumbers() {
        return SCANNER.nextLine().split("");
    }

    public static boolean askReplayGame() {
        return SCANNER.nextInt() == 1;
    }
}
