package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Round;

public class Parser {
    public static Cars parseCars(String input) {
        List<String> cars = Arrays.asList(input.split(","));
        return Cars.createFrom(cars);
    }

    public static Round parseRound(String input) {
        return Round.createFrom(Integer.parseInt(input));
    }
}
