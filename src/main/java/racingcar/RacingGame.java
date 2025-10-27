package racingcar;

import java.util.List;


public class RacingGame {
    private List<Car> Cars;
    private static final int MOVE_FORWARD_STANDARD = 4;

    public void playRacingGame() {
        runRound();
    }

    private void runRound() {
        for (Car car : this.Cars) {
            int randomNumber = Random.getNumber();
            moveCarRandomly(car,randomNumber);
        }
    }

    // TODO: 차를 랜덤값에 이동시키는 것이 어디 클래스에 있는게 좋을까?
    void moveCarRandomly(Car car, int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_STANDARD) {
            car.moveForward();
        }
    }


}
