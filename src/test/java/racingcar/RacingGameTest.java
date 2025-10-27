package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void 랜덤숫자가_4이상이면_전진한다() {
        Car car = new Car("qwer");
        RacingGame game = new RacingGame(List.of(car));
        int randomNumber = 4;

        game.moveCarRandomly(car, randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤숫자가_4미만이면_정지한다() {
        Car car = new Car("qwer");
        RacingGame game = new RacingGame(List.of(car));
        int randomNumber = 3;

        game.moveCarRandomly(car, randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 가장_멀리_간_자동차가_우승한다() {
        Car car1 = new Car("qwer");
        Car car2 = new Car("asd");
        Car car3 = new Car("zxcv");

        car1.moveForward();
        car1.moveForward();
        car2.moveForward();
        // car1 2칸, car2 1칸, car3 0칸

        RacingGame game = new RacingGame(List.of(car1, car2, car3));

        List<String> winners = game.getWinner();

        assertThat(winners).containsExactly("qwer");
    }

    @Test
    void 가장_멀리_간_자동차가_여러_명이면_공동_우승한다() {
        Car car1 = new Car("qwer");
        Car car2 = new Car("asd");
        Car car3 = new Car("zxcv");

        car1.moveForward();
        car2.moveForward();
        // car1 1칸, car2 1칸, car3 0칸

        RacingGame game = new RacingGame(List.of(car1, car2, car3));

        List<String> winners = game.getWinner();

        assertThat(winners).containsExactlyInAnyOrder("qwer", "asd");
    }
}
