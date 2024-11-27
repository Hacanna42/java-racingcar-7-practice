package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatusDto;
import racingcar.dto.CarStatusDtos;

public class OutputView {
    /* TODO
     * 1. 레이싱 실행 결과 출력
     * 2. 우승자 결과 출력
     */
    public static void printGameStatus(CarStatusDtos carStatusDtos) {
        for (CarStatusDto carStatus : carStatusDtos.carStatusDtos()) {
            printCarStatus(carStatus.name(), carStatus.position());
        }
        System.out.println();
    }

    private static void printCarStatus(String name, int position) {
        System.out.println(name + " : " + "-".repeat(position));
    }
}
