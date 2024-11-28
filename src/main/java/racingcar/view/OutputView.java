package racingcar.view;

import racingcar.dto.CarStatusDto;
import racingcar.dto.CarStatusDtos;
import racingcar.dto.WinnerCarsDto;

public class OutputView {

    public static void printGameStatus(CarStatusDtos carStatusDtos) {
        for (CarStatusDto carStatus : carStatusDtos.carStatusDtos()) {
            printCarStatus(carStatus.name(), carStatus.position());
        }
        System.out.println();
    }

    public static void printGameResult(WinnerCarsDto winnerCarsDto) {
        if (winnerCarsDto.names().size() == 1) {
            printWinnerCar(winnerCarsDto);
            return;
        }

        printWinnerCars(winnerCarsDto);
    }

    private static void printWinnerCar(WinnerCarsDto winnerCarsDto) {
        System.out.println("최종 우승자 : " + winnerCarsDto.names().getFirst());
    }

    private static void printWinnerCars(WinnerCarsDto winnerCarsDto) {
        String winnerCarNames = String.join(", ", winnerCarsDto.names());
        System.out.println("최종 우승자 : " + winnerCarNames);
    }

    private static void printCarStatus(String name, int position) {
        System.out.println(name + " : " + "-".repeat(position));
    }
}
