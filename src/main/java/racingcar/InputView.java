package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";

    public List<String> inputCars() {
        String input = Console.readLine();
        return trimString(input);
    }

    private List<String> trimString(String string) {
        String[] parts = string.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(parts));
    }
}
