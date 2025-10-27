package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";

    public List<String> inputCars(String input) {
        List<String> names = trimString(input);
        CarNameValidator.validate(names);
        return names;
    }

    private List<String> trimString(String string) {
        if (string.trim().isEmpty()) {
            throw new IllegalArgumentException("문자를 입력하지 않았습니다.");
        }

        String[] parts = string.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(parts));
    }
}
