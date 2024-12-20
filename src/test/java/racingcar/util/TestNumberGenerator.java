package racingcar.util;

public class TestNumberGenerator implements NumberGenerator {
    private final int number;

    public TestNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
