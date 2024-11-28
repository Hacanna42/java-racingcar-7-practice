package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {
    @DisplayName("Round 객체가 올바르게 생성되는지 테스트한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Round_객체_생성_테스트(int roundNumber) {
        // when
        Round round = Round.createFrom(roundNumber);

        // then
        Assertions.assertThat(round).isInstanceOf(Round.class);
    }

    @DisplayName("Round의 값이 0 미만이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void Round_객체_생성_예외_테스트(int roundNumber) {
        // when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Round.createFrom(roundNumber));
    }

    @DisplayName(".hasNextRound() 메서드가 의도대로 동작하는지 확인한다.")
    @Test
    void hasNextRound_메서드_테스트() {
        Assertions.assertThat(Round.createFrom(1).hasNextRound()).isTrue();
        Assertions.assertThat(Round.createFrom(0).hasNextRound()).isFalse();
    }

    @DisplayName(".consumeRound() 메서드가 의도대로 동작하는지 확인한다.")
    @Test
    void consumeRound_메서드_테스트() {
        Round round = Round.createFrom(1);
        Assertions.assertThat(round.consumeRound().hasNextRound()).isFalse();
    }
}