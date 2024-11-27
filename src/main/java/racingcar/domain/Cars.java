package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars createFrom(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.createFrom(carName));
        }
        return new Cars(cars);
    }

    public Cars moveAllCar() {
        List<Car> movedCars = cars.stream().map(Car::move).toList();
        return new Cars(movedCars);
    }
}
