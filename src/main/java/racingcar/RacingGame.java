package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private List<Car> Cars;
    private static final int MOVE_FORWARD_STANDARD = 4;

    private void runRound() {
        for (Car car : this.Cars) {
            moveCarRandomly(car);
        }
    }

    // TODO: 차를 랜덤값에 이동시키는 것이 어디 클래스에 있는게 좋을까?
    private void moveCarRandomly(Car car) {
        if (getRandomNumber()) {
            car.moveForward();
        }
    }

    private boolean getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_FORWARD_STANDARD;
    }
}
