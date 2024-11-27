package racingcar.domain;

import racingcar.dto.CarStatusDto;
import racingcar.util.NumberGenerator;

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

    public Car move(NumberGenerator numberGenerator) {
        if (canMove(numberGenerator)) {
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

    private boolean canMove(NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= 4;
    }

    private static void validate(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
