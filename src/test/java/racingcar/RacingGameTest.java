package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

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
}
