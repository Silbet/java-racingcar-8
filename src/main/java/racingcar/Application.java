package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = inputView.inputCars(inputView.readCars());
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        // 라운드 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        int roundCount = inputView.inputRoundCount((inputView.readRoundCount()));

        RacingGame racingGame = new RacingGame(cars);

        // 라운드 진행
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundCount; i++) {
            racingGame.playOneRound();
            outputView.printRoundResult(cars);
        }

        // 최종 우승자 출력
        List<String> winners = racingGame.getWinner();
        outputView.printWinners(winners);
    }
}
