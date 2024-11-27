package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {
    @DisplayName("Round 객체가 올바르게 생성되는지 테스트한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2 ,3})
    void Round_객체_생성_테스트(int roundNumber) {
        // when
        Round round = Round.createFrom(roundNumber);

        // then
        Assertions.assertThat(round).isInstanceOf(Round.class);
    }

}