package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        Cars cars = getCars();
        Round round = getRound();
        playGame(cars, round);
    }

    private Cars getCars() {
        return Parser.parseCars(InputView.getCarNames());
    }

    private Round getRound() {
        return Parser.parseRound(InputView.getRounds());
    }

    private void playGame(Cars initCars, Round initRound) {
        Cars cars = initCars;
        Round round = initRound;

        while (round.hasNextRound()) {
            cars = cars.moveAllCar();
            OutputView.printGameStatus(cars.getCarStatuses());
            round = round.consumeRound();
        }
    }


}
