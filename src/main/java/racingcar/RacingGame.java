package racingcar;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {
    private List<Car> cars;
    private static final int MOVE_FORWARD_STANDARD = 4;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void playRacingGame() {
        runRound();
    }

    private void runRound() {
        for (Car car : this.cars) {
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

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int max = -1;

        for (Car car : this.cars) {
            int p = car.getPosition();
            if (p > max) {
                max = p;
                winners.clear();
                winners.add(car.getName());
            } else if (p == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
