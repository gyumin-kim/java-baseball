package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumbersTest {

    @DisplayName("null로 생성 시 exception 발생")
    @Test
    void nullParameterThrowsException() {
        assertThrows(NullPointerException.class,
                () -> new Numbers(null));
    }

    @DisplayName("3자리가 아닌 수로 생성 시 exception 발생")
    @Test
    void numbersSizeMustBeThree() {
        // given
        List<Integer> numbersList = List.of(1, 2, 3, 4);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Numbers(numbersList));
        assertThat(exception.getMessage()).isEqualTo("숫자는 3자리로 구성되어야 합니다.");
    }

    @DisplayName("숫자로 구성된 문자열로 객체 생성")
    @Test
    void of() {
        // given
        String numbersString = "731";

        // when
        Numbers numbers = Numbers.of(numbersString);

        // then
        assertThat(numbers).isNotNull();
        assertThat(numbers.toString()).isEqualTo(numbersString);
    }

    @DisplayName("numbers의 자릿수를 리턴")
    @Test
    void numberOfDigits() {
        // given
        List<Integer> numbersList = List.of(3, 6, 9);
        Numbers numbers = new Numbers(numbersList);

        // when
        int size = numbers.numberOfDigits();

        // then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("toString() 호출 시 문자열 형태로 리턴")
    @Test
    void testToString() {
        // given
        List<Integer> numbersList = List.of(3, 6, 9);
        Numbers numbers = new Numbers(numbersList);

        // when
        String toString = numbers.toString();

        // then
        assertThat(toString).isEqualTo("369");
    }

    @DisplayName("특정 위치의 수가 다른 Numbers의 동일한 위치에도 존재하는지 판단")
    @Test
    void existsSameNumberAt() {
        // given
        Numbers numbers1 = new Numbers(List.of(3, 6, 9));
        Numbers numbers2 = new Numbers(List.of(3, 2, 1));

        // when
        boolean existsAt0 = numbers1.existsSameNumberAt(0, numbers2);
        boolean existsAt1 = numbers1.existsSameNumberAt(1, numbers2);
        boolean existsAt2 = numbers1.existsSameNumberAt(2, numbers2);

        // then
        assertThat(existsAt0).isTrue();
        assertThat(existsAt1).isFalse();
        assertThat(existsAt2).isFalse();
    }

    @DisplayName("특정 위치의 수가 다른 Numbers에도 포함되어 있는지 판단(index 고려하지 않음)")
    @Test
    void contains() {
        // given
        Numbers numbers1 = new Numbers(List.of(3, 6, 9));
        Numbers numbers2 = new Numbers(List.of(9, 2, 1));

        // when
        boolean containsAt0 = numbers1.contains(0, numbers2);
        boolean containsAt1 = numbers1.contains(1, numbers2);
        boolean containsAt2 = numbers1.contains(2, numbers2);

        // then
        assertThat(containsAt0).isFalse();
        assertThat(containsAt1).isFalse();
        assertThat(containsAt2).isTrue();
    }
}