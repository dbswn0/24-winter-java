package calculator.view;

import java.util.Scanner;

public class CalculatorView {
    private final Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return scanner.nextLine(); // 한 줄 입력 받기
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void closeScanner() {
        scanner.close();
    }
}
