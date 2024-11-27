package racingcar.domain;

public class Car {
    private final String name;
    private final int position;

    private Car(String name) {
        this.name = name;
        position = 0;
    }

    public static Car createFrom(String name) {
        validate(name);
        return new Car(name);
    }

    private static void validate(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
