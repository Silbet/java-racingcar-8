package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputViewTest {
    @ParameterizedTest
    @CsvSource({
            "'qwer,asd,zxcv', qwer|asd|zxcv",
            "'car 1,ca r2', car 1|ca r2",
            "'a,ab,abc,abcd', a|ab|abc|abcd"
    })
    void 자동차를_쉼표로_구분해_리스트로_반환한다(String input, String expectedJoined) {
        InputView inputView = new InputView();

        List<String> result = inputView.inputCars(input);
        List<String> expected = List.of(expectedJoined.split("\\|"));

        assertThat(result).containsExactlyElementsOf(expected);
    }
}
