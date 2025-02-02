package calculator.model;

import java.util.ArrayList;

public class CalculatorModel {
    public int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.startsWith("//")) {
            return calculateCustomDelimiter(input);
        } else {
            return calculateBasicDelimiter(input);
        }
    }

    private int calculateCustomDelimiter(String input) {
        ArrayList<Integer> numberList = new ArrayList<>();
        splitCustom(input, numberList);
        return calculate(numberList);
    }

    private int calculateBasicDelimiter(String input) {
        ArrayList<Integer> numberList = new ArrayList<>();
        splitBasic(input, numberList);
        return calculate(numberList);
    }

    private void splitBasic(String inputValue, ArrayList<Integer> numbers) {
        String[] parts = inputValue.split("[,:]");

        for (String part : parts) {
            try {
                int number = Integer.parseInt(part.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값 입력");
            }
        }
    }

    private void splitCustom(String inputValue, ArrayList<Integer> numbers) {
        String customDelimiter = ",";
        String numbersPart = inputValue;

        // 커스텀 구분자 확인
        if (inputValue.startsWith("//") && inputValue.contains("\n")) {
            int lastDelimiter = inputValue.indexOf("\n");
            customDelimiter = inputValue.substring(2, lastDelimiter);
            numbersPart = inputValue.substring(lastDelimiter + 1);
        }

        String[] parts = numbersPart.split(customDelimiter);

        for (String part : parts) {
            try {
                int number = Integer.parseInt(part.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값 입력");
            }
        }
    }

    private int calculate(ArrayList<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}