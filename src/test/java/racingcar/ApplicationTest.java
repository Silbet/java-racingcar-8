package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤숫자가_4이상이면_전진한다() {
        Car car = new Car("qwer");
        RacingGame game = new RacingGame();
        int randomNumber = 4;

        game.moveCarRandomly(car, randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤숫자가_4미만이면_정지한다() {
        Car car = new Car("qwer");
        RacingGame game = new RacingGame();
        int randomNumber = 3;

        game.moveCarRandomly(car, randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
