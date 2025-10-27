package racingcar;

import java.util.List;

public class OutputView {
    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getPositionBar(car.getPosition()));
        }
        System.out.println();
    }

    private String getPositionBar(int position) {
        return "-".repeat(position);
    }
}
