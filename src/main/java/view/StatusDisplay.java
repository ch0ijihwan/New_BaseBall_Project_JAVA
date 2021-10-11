package view;

public class StatusDisplay {
    private StatusDisplay() {

    }

    public static void showBallAndStrike(int ball, int strike) {
        if (ball > 0 || strike > 0)
            System.out.println("Ball : " + ball + "   Strike : " + strike);
        if(ball ==0 && strike ==0){
            System.out.println("Nothing");
        }
    }

    public static void showStartGame() {
        System.out.println("숫자 야구 게임을 시작 합니다.");
    }

    public static void showEndGame() {
        System.out.println("게임을 끝 마칩니다.");
    }

    public static void showNewGameQuestion() {
        System.out.println("게임을 재실행 하려면 1을 누르세요 \n 그렇지 않다면 아무키나 누르세요.");
    }
}
