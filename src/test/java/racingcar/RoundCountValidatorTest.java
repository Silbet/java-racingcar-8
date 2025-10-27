package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import org.junit.jupiter.api.Test;

public class RoundCountValidatorTest {
    @Test
    void 숫자를_입력하면_정상적으로_정수로_반환한다() {
        int result = RoundCountValidator.validate("5");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 입력값이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> RoundCountValidator.validate("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자만 입력할 수 있습니다.");
    }

    @Test
    void 입력값이_음수면_예외가_발생한다() {
        assertThatThrownBy(() -> RoundCountValidator.validate("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 입력값이_0이면_예외가_발생한다() {
        assertThatThrownBy(() -> RoundCountValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 입력값의_공백은_trim되어_정상적으로_처리된다() {
        int result = RoundCountValidator.validate("   2   ");
        assertThat(result).isEqualTo(2);
    }
}
