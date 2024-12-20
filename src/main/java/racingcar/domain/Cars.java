package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarStatusDtos;
import racingcar.dto.WinnerCarsDto;
import racingcar.util.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars createFromNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.createFrom(carName));
        }
        return new Cars(cars);
    }

    public static Cars createFromCars(List<Car> cars) {
        return new Cars(cars);
    }

    public Cars moveAllCars(NumberGenerator numberGenerator) {
        List<Car> movedCars = cars.stream().map(car -> car.move(numberGenerator)).toList();
        return new Cars(movedCars);
    }

    public CarStatusDtos getCarStatuses() {
        return new CarStatusDtos(cars.stream()
                .map(Car::getCarStatus)
                .toList());
    }

    public WinnerCarsDto getWinnerCars() {
        Car firstPlaceCar = getFirstPlaceCar();
        List<String> winnerCarNames = cars.stream()
                .filter(firstPlaceCar::isSamePositionWith)
                .map(Car::getName)
                .toList();

        return new WinnerCarsDto(winnerCarNames);
    }

    private Car getFirstPlaceCar() {
        return cars.stream().reduce(cars.getFirst(), this::chooseAheadCar);
    }

    private Car chooseAheadCar(Car car1, Car car2) {
        if (car1.isAheadOf(car2)) {
            return car1;
        }
        return car2;
    }
}
