package practice.view;

import practice.Car;
import java.util.List;

public class ConsoleView {
    public void raceResults(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }


}
