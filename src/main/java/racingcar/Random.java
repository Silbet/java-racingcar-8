package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    private static final int MIN = 0;
    private static final int MAX = 9;

    public static int getNumber() {
            return Randoms.pickNumberInRange(MIN, MAX);
    }
}
