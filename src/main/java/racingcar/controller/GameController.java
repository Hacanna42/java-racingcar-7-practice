package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.util.Parser;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void run() {
        Cars initCars = getCars();
        Round round = getRound();
        Cars updatedCars = playGame(initCars, round);
        OutputView.printGameResult(updatedCars.getWinnerCars());
    }

    private Cars getCars() {
        return Parser.parseCars(InputView.getCarNames());
    }

    private Round getRound() {
        return Parser.parseRound(InputView.getRounds());
    }

    private Cars playGame(Cars initCars, Round initRound) {
        Cars cars = initCars;
        Round round = initRound;

        while (round.hasNextRound()) {
            cars = cars.moveAllCars(new RandomNumberGenerator());
            OutputView.printGameStatus(cars.getCarStatuses());
            round = round.consumeRound();
        }

        return cars;
    }
}
