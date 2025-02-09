package practice.controller;

import camp.nextstep.edu.missionutils.Console;

public class RaceController {
    public void userInput() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");

        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");
    }
}
