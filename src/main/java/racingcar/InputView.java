package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";

    public String readCars() {
        return Console.readLine();
    }

    public List<String> inputCars(String input) {
        List<String> names = trimString(input);
        CarNameValidator.validate(names);
        return names;
    }

    List<String> trimString(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("문자를 입력하지 않았습니다.");
        }
        if (string.trim().isEmpty()) {
            throw new IllegalArgumentException("공백만 입력했습니다.");
        }

        String[] parts = string.split(DELIMITER, -1);
        return new ArrayList<>(Arrays.asList(parts));
    }

    public String readRoundCount() {
        return Console.readLine();
    }

    public int inputRoundCount(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("문자를 입력하지 않았습니다.");
        }
        RoundCountValidator.validate(input);
        return Integer.parseInt(input);
    }
}
