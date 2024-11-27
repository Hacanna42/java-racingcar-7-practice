package racingcar.domain;

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
        return new Car(this.name, this.position + 1);
    }

    private static void validate(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
