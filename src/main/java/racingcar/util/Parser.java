package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Round;

public class Parser {
    public static Cars parseCars(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        return Cars.createFromNames(carNames);
    }

    public static Round parseRound(String input) {
        return Round.createFrom(Integer.parseInt(input));
    }
}
