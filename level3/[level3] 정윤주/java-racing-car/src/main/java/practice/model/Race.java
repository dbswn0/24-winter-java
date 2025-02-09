package practice.model;

import practice.Car;
import practice.view.ConsoleView;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int attempts;

    public Race(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void startRace(ConsoleView consoleView) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
            }
            consoleView.raceResults(cars);
        }
    }
}
