package view;

import static org.graalvm.compiler.hotspot.replacements.Log.println;

public class StatusDisplay {
    private StatusDisplay() {

    }

    public static void showBallAndStrike(int ball, int strike) {
        println("Ball : " + ball + "Strike : " + strike);
    }

    public static void showStartGame() {
        println("숫자 야구 게임을 시작 합니다.");
    }

    public static void showEndGame() {
        println("게임을 끝 마칩니다.");
    }

    public static void showNewGameQuestion() {
        println("게임을 재실행 하려면 1을 누르세요 \n 게임을 종료하시려면 2를 누르세요");
    }
}
