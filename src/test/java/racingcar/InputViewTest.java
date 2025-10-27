package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputViewTest {
    @ParameterizedTest
    @CsvSource({
            "'qwer,asd,zxcv', qwer|asd|zxcv",
            "'car 1,ca r2', car 1|ca r2",
            "'a,ab,abc,abcd', a|ab|abc|abcd",
            "'a,b,', 'a|b|'",
            "'a,b, ', 'a|b| '"
    })
    void 자동차를_쉼표로_구분해_리스트로_반환한다(String input, String expectedJoined) {
        InputView inputView = new InputView();

        List<String> result = inputView.trimString(input);
        List<String> expected = List.of(expectedJoined.split("\\|", -1));

        assertThat(result).containsExactlyElementsOf(expected);
    }

    @Test
    void 입력값이_비어있으면_예외가_발생한다() {
        InputView inputView = new InputView();
        String input = "";
        assertThatThrownBy(() -> inputView.inputCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자를 입력하지 않았습니다.");
    }

    @Test
    void 입력값이_공백이면_예외가_발생한다() {
        InputView inputView = new InputView();
        String input = "  ";
        assertThatThrownBy(() -> inputView.inputCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백만 입력했습니다.");
    }
}
