package racingcar.domain;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.CarStatusDto;
import racingcar.dto.CarStatusDtos;
import racingcar.dto.WinnerCarsDto;
import racingcar.util.TestNumberGenerator;

class CarsTest {
    private static final int VALUE_THAT_MOVE = 4;
    private static final int VALUE_THAT_NOT_MOVE = 3;

    private Cars cars;

    static Stream<Arguments> provideCarNames() {
        return Stream.of(
                arguments(List.of("pobi", "woni")),
                arguments(List.of("hyun", "yeeun"))
        );
    }

    @BeforeEach
    void initCars() {
        cars = Cars.createFromNames(List.of("pobi", "woni"));
    }

    @DisplayName("Cars 객체 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideCarNames")
    void Cars_객체_생성_테스트(List<String> carNames) {
        // given
        Cars cars = Cars.createFromNames(carNames);

        // when & then
        Assertions.assertThat(cars).isInstanceOf(Cars.class);
    }

    @DisplayName(".moveAllCar()이 의도대로 동작하는지 테스트")
    @Test
    void moveAllCar_테스트() {
        Cars resultCars = cars.moveAllCars(new TestNumberGenerator(VALUE_THAT_MOVE));
        CarStatusDtos carStatusDtos = resultCars.getCarStatuses();
        for (CarStatusDto carStatus : carStatusDtos.carStatusDtos()) {
            Assertions.assertThat(carStatus.position()).isEqualTo(1);
        }
    }

    @DisplayName(".getCarStatuses()가 의도대로 동작하는지 테스트")
    @Test
    void getCarStatuses_테스트() {
        // given
        List<String> carNames = List.of("pobi", "woni");
        CarStatusDtos carStatusDtos = cars.getCarStatuses();

        // when & then
        Assertions.assertThat(carStatusDtos.carStatusDtos().getFirst().name()).isEqualTo(carNames.getFirst());
        Assertions.assertThat(carStatusDtos.carStatusDtos().getLast().name()).isEqualTo(carNames.getLast());
    }

    @DisplayName(".getWinnerCar()가 의도대로 동작하는지 테스트")
    @Test
    void getWinnerCar_테스트() {
        // given
        Car winningCar = Car.createFrom("pobi");
        Car LosingCar = Car.createFrom("woni");
        winningCar.move(new TestNumberGenerator(VALUE_THAT_MOVE));
        LosingCar.move(new TestNumberGenerator(VALUE_THAT_NOT_MOVE));
        Cars cars = Cars.createFromCars(List.of(winningCar, LosingCar));

        // when
        WinnerCarsDto winnerCarsDto = cars.getWinnerCars();

        // then
        Assertions.assertThat(winnerCarsDto.names().getFirst()).isEqualTo("pobi");
    }
}