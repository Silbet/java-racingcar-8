package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"qwer,", "qwer, ", "qwer,asd,"})
    void 자동차_이름이_공백이면_예외가_발생한다(String csv) {
        List<String> names = Arrays.asList(csv.split(",", -1));
        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"qwer,abcdef", "q w e r", "qwert,qwerty"})
    void 자동차_이름이_5자를_초과하면_예외가_발생한다(String csv) {
        List<String> names = Arrays.asList(csv.split(",", -1));
        assertThatThrownBy(() -> CarNameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"qwer,asd,zxcv", "q,qw,qwe,qwer", "q w,q w e"})
    void 자동차_이름이_정상이라면_예외가_발생하지_않는다(String csv) {
        List<String> names = Arrays.asList(csv.split(","));
        assertThatCode(() -> CarNameValidator.validate(names))
                .doesNotThrowAnyException();
    }
}
