package view;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {

    }
    
    public static String[] inputBaseballNumbers() {
        return SCANNER.next()
                .trim()
                .split("");
    }

    public static boolean AskReplayGame() {
        return SCANNER.nextInt() == 1;
    }
}
