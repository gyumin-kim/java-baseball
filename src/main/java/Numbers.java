import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {

    private static final int NUMBERS_REQUIRED_SIZE = 3;

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Numbers(String numbersString) {
        validate(numbersString);
        this.numbers = convertStringToCollectionOfIntegers(numbersString);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() < NUMBERS_REQUIRED_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_ENOUGH_ELEMENTS.toString());
        }

        // numbersString은 스트림으로 바꾸면 더 보기 좋을 것 같습니다.
        StringBuilder numbersString = new StringBuilder();
        for (int num : numbers) {
            numbersString.append(num);
        }

        validate(numbersString.toString());
    }

    /*
     * 2depth 이상이 존재하네요.
     * 메소드명이 validate라 어떤 기능이 포함되는지 전반적으로 파악하기 힘들어요.
     * 하위 내용을 메소드로 빼내어 명칭화를 한다면 이해하기 쉬울거라 생각합니다.
     */
    private void validate(String numbersString) {
        if (!isNumeric(numbersString)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_A_NUMBER.toString());
        }
        if (numbersString.length() != NUMBERS_REQUIRED_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_THREE_DIGITS_NUMBER.toString());
        }
        Set<Integer> argNumbers = new LinkedHashSet<>();

        for (int i = 0; i < numbersString.length(); i++) {
            // 한 글자만 보려고 하는 의도겠으나 substring으로 새 String이 생성될 수도 있겠네요.
            String digitString = numbersString.substring(i, i + 1);
            Integer digit = Integer.valueOf(digitString);
            if (digit == 0) {
                throw new IllegalArgumentException(ExceptionMessage.ZERO_INCLUDED.toString());
            }
            if (argNumbers.contains(digit)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_DIGITS.toString());
            }
            argNumbers.add(digit);
        }
    }

    private boolean isNumeric(String numericFormatString) {
        if (numericFormatString == null) {
            return false;
        }

        try {
            /*
             * double로 변환할 필요는 없는 것 같습니다...
             * char 하나씩 빼내서 0 ~ 9 사이인지만 봐도 충분하다고 생각해요.
             * 그럼 try문이 없어져도 되겠죠.
             * 게다가 stream으로 바꿔줄 수도 있겠네요.
             */
            Double.parseDouble(numericFormatString);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    private List<Integer> convertStringToCollectionOfIntegers(String numbersString) {
        List<Integer> numbers = new ArrayList<>();
        // 여기도 stream으로 바꾸어 봅시다. 익숙해져야죠.
        for (int i = 0; i < numbersString.length(); i++) {
            numbers.add(Integer.valueOf(numbersString.substring(i, i + 1)));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
