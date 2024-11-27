package racingcar.domain;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarStatusDto;
import racingcar.util.TestNumberGenerator;

class CarTest {
    private static final int VALUE_THAT_MOVE = 4;
    private static final int VALUE_THAT_NOT_MOVE = 3;

    private Car car1;
    private Car car2;

    @BeforeEach
    void initCars() {
        car1 = Car.createFrom("pobi");
        car2 = Car.createFrom("woni");
    }

    @Nested
    class 객체_생성_테스트 {
        @DisplayName("Car 객체를 생성할 수 있다.")
        @ParameterizedTest
        @ValueSource(strings = {"pobi", "woni"})
        void 자동차_객체_생성_테스트(String name) {
            // when
            Car car = Car.createFrom(name);

            // then
            Assertions.assertThat(car).isInstanceOf(Car.class);
        }

        @DisplayName("자동차의 이름은 비어있거나 길이 5를 초과할 수 없다.")
        @ParameterizedTest
        @ValueSource(strings = {"pobipo", "woniwo", ""})
        void 자동차_길이_예외_생성_테스트(String name) {
            Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Car.createFrom(name));
        }
    }

    @Nested
    class 자동차_이동_테스트 {
        @DisplayName("자동차는 4 이상의 숫자에 대해 전진한다.")
        @Test
        void 자동차_전진_테스트() {
            // when
            Car resultCar = car1.move(new TestNumberGenerator(VALUE_THAT_MOVE));

            // then
            Assertions.assertThat(resultCar.isAheadOf(car2)).isTrue();
        }

        @DisplayName("자동차는 4 미만의 숫자에 대해 전진하지 않는다.")
        @Test
        void 자동차_정지_테스트() {
            // when
            Car resultCar = car1.move(new TestNumberGenerator(VALUE_THAT_NOT_MOVE));

            // then
            Assertions.assertThat(resultCar.isSamePositionWith(car2)).isTrue();
        }
    }

    @DisplayName(".isAheadOf()가 의도대로 동작하는지 테스트한다")
    @Test
    void isAheadOf_테스트() {
        // given
        Car resultCar = car1.move(new TestNumberGenerator(VALUE_THAT_MOVE));

        // when & then
        Assertions.assertThat(resultCar.isAheadOf(car2)).isTrue();
        Assertions.assertThat(car2.isAheadOf(resultCar)).isFalse();
    }

    @DisplayName(".isSamePosition()이 의도대로 동작하는지 테스트한다")
    @Test
    void isSamePosition_테스트() {
        // given
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(VALUE_THAT_MOVE);
        Car movedCar1 = car1.move(testNumberGenerator);
        Car movedCar2 = car2.move(testNumberGenerator);

        // when & then
        Assertions.assertThat(car1.isSamePositionWith(car2)).isTrue();
        Assertions.assertThat(movedCar1.isSamePositionWith(movedCar2)).isTrue();
        Assertions.assertThat(car1.isSamePositionWith(movedCar1)).isFalse();
    }

    @DisplayName(".getCarStatus() 가 의도대로 동작하는지 테스트한다")
    @Test
    void getCarStatus_테스트() {
        // when
        CarStatusDto carStatusDto = car1.getCarStatus();

        // then
        Assertions.assertThat(carStatusDto.name()).isEqualTo("pobi");
        Assertions.assertThat(carStatusDto.position()).isEqualTo(0);
    }
}