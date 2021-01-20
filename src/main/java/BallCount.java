import java.util.List;

public class BallCount {

    private static final String EMPTY_STRING = "";

    private final int balls;
    private final int strikes;

    public BallCount(Numbers numbers1, Numbers numbers2) {
        List<Integer> answerNumbers = numbers1.getNumbers();
        List<Integer> anotherNumbers = numbers2.getNumbers();

        /*
         * 이 아래로는 stream으로 변환할 수 있는 구간이네요.
         * 2depth 해결이라던가 balls = 0에서 0은 작성자가 아닌 타인이 볼 때 보자마자 정확하게 의도를 파악하기는 어려운 정수값인데요,
         * (여기는 간단한 예제라 초기화값이라고 바로 이해할 수 있긴 합니다)
         * stream으로 변환하면 위의 문제들을 해결해줄 수 있겠죠.
         */
        int balls = 0;
        int strikes = 0;
        int count = answerNumbers.size();
        for (int i = 0; i < count; i++) {
            if (answerNumbers.get(i).equals(anotherNumbers.get(i))) {
                strikes++;
            } else if (anotherNumbers.contains(answerNumbers.get(i))) {
                balls++;
            }
        }

        this.balls = balls;
        this.strikes = strikes;
    }

    public void printDetailedCountMessage() {
        System.out.println(createBallCountMessage(this.balls, this.strikes));
    }

    private String createBallCountMessage(int balls, int strikes) {
        if (isNoCount(balls, strikes)) {
            return BallCountMessage.NOTHING.toString();
        }
        String ballString = createBallString(balls);
        String strikeString = createStrikeString(strikes);
        return (ballString + " " + strikeString).trim();
    }

    private boolean isNoCount(int balls, int strikes) {
        return balls == 0 && strikes == 0;
    }

    private String createBallString(int balls) {
        if (balls <= 0) {
            return EMPTY_STRING;
        }
        return balls + BallCountMessage.BALL.toString();
    }

    private String createStrikeString(int strikes) {
        if (strikes <= 0) {
            return EMPTY_STRING;
        }
        return strikes + BallCountMessage.STRIKE.toString();
    }

    public boolean isThreeStrikes() {
        return this.strikes == 3;
    }
}
