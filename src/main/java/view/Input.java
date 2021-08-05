package view;

import java.util.Scanner;

public class Input {

    private Input(){

    }

    private static final Scanner SCANNER = new Scanner(System.in);

    public  static String[] inputBaseBallNumbers(){
        return SCANNER.next()
                .trim()
                .split("");
    }

    public static boolean AskReplayGame(){
        return SCANNER.nextInt() == 1;
    }
}
