package view;

public class StatusDisplay {
    private StatusDisplay() {

    }

    public static void showBallAndStrike(int ball, int strike) {
        System.out.println("Ball : " + ball + "   Strike : " + strike);
    }

    public static void showStartGame() {
        System.out.println("숫자 야구 게임을 시작 합니다.");
    }

    public static void showEndGame() {
        System.out.println("게임을 끝 마칩니다.");
    }

    public static void showNewGameQuestion() {
        System.out.println("게임을 재실행 하려면 1을 누르세요 \n게임을 종료하시려면 2를 누르세요");
    }

    public static void showRountCount(int roundCount){
        System.out.println("현재 라운드 : " + roundCount);
    }
}
