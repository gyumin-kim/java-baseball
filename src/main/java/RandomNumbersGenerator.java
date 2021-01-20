import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 이 예제에서는 getRandomNumbers가 1 ~ 10까지라는 사실을 이미 알고 있기에 결과가 10개이고 1 ~ 10사이 수임을 검증하면 되지만,
 * 멱등성이 보장되지 않는 (random.nextInt 등) 요소는 테스트하기 어려울 수 있음.
 * scanner.nextInt, localDateTime.now 등이 유사한 문제를 안고 있습니다.
 * 가급적이면 주입받을 수 있도록 변경해보세요.
 */
public class RandomNumbersGenerator {

    private static final Random random = new Random();
    private static final int NUMBERS_REQUIRED_SIZE = 3;

    private RandomNumbersGenerator() {
    }

    public static Numbers generate() {
        return new Numbers(getRandomNumbers());
    }

    private static List<Integer> getRandomNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < NUMBERS_REQUIRED_SIZE) {
            int number = random.nextInt(9) + 1;
            numbers.add(number);
        }

        return List.copyOf(numbers);
    }
}
