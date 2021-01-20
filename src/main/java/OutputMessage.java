/**
 * 취향차가 조금 있는 부분이지만, toString을 위해 존재하는 enum type은 호출할 때마다 .toString()을 항상 붙여줘야 해서 좋아보이지는 않아요.
 * 차라리 static String 필드를 다수 갖고 있는 클래스가 어떨까 합니다.
 * 다시 한번 말씀드리지만 이건 취향 차이에요.
 */
public enum OutputMessage {

    GAME_FINISHED("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    PLEASE_ENTER_NUMBER("숫자를 입력해 주세요 : "),
    PLEASE_ENTER_AGAIN(" 다시 입력해 주세요 : "),
    PLAY_A_NEW_GAME_OR_NOT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. "),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return this.message;
    }
}
