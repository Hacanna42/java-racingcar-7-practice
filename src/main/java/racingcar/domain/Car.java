package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarStatusDto;

public class Car {
    private final String name;
    private final int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car createFrom(String name) {
        validate(name);
        return new Car(name, 0);
    }

    public Car move() {
        if (canMove()) {
            return new Car(this.name, this.position + 1);
        }
        return this;
    }

    public boolean isAheadOf(Car other) {
        return this.position > other.position;
    }

    public boolean isSamePositionWith(Car other) {
        return this.position == other.position;
    }

    public CarStatusDto getCarStatus() {
        return new CarStatusDto(name, position);
    }

    public String getName() {
        return name;
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private static void validate(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
