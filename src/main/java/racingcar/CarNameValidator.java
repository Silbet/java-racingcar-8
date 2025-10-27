package racingcar;

import java.util.List;

public class CarNameValidator {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public static void validate(List<String> names) {
        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다");
            }
        }
    }
}
