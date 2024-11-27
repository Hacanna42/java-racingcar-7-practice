package racingcar.domain;

public class Round {
    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round createFrom(int round) {
        validate(round);
        return new Round(round);
    }

    public boolean hasNextRound() {
        return round > 0;
    }

    public Round consumeRound() {
        return new Round(round - 1);
    }

    private static void validate(int round) {
        if (round < 0) {
            throw new IllegalArgumentException();
        }
    }
}
