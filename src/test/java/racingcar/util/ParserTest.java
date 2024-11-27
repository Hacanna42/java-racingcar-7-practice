package racingcar.util;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Round;

class ParserTest {

    @DisplayName(".parseCars() 메서드가 의도대로 동작하는지 테스트")
    @Test
    void parseCars() {
        // when
        Cars cars = Parser.parseCars("pobi,woni");

        // then
        Assertions.assertThat(cars).isInstanceOf(Cars.class);
        Assertions.assertThat(cars.getCarStatuses().carStatusDtos().getFirst().name()).isEqualTo("pobi");
        Assertions.assertThat(cars.getCarStatuses().carStatusDtos().getLast().name()).isEqualTo("woni");
    }

    @DisplayName(".parseRound() 메서드가 의도대로 동작하는지 테스트")
    @Test
    void parseRound() {
        // given
        String roundNumber = "1";

        // when
        Round round = Parser.parseRound(roundNumber);

        // then
        Assertions.assertThat(round).isInstanceOf(Round.class);
    }
}