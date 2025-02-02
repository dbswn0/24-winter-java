package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        String input = view.getInput();
        try {
            int result = model.calculator(input);
            view.displayResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값 입력");
        }
    }
}

