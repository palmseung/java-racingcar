package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Result;
import racingcar.model.Winners;
import racingcar.view.InputView;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingCar {
    private static int currentCount;
    private static int NUMBER_TO_STOP_RUNNING = 0;

    private Cars cars;
    private Result result;

    public RacingCar(Cars cars) {
        this.cars = cars;
    }

    public static RacingCar ready(InputView inputView) {
        Cars cars = inputView.getCarNames().stream()
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
        currentCount = inputView.getTryCount();
        return new RacingCar(cars);
    }

    public void start() {
        this.result = cars.moveOnce();
        this.currentCount--;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public List<Car> getWinners() {
        return findWinners().getWinners();
    }

    private Winners findWinners() {
        return new Winners(cars.findWinner());
    }

    public boolean isNotEnd() {
        return this.currentCount > NUMBER_TO_STOP_RUNNING;
    }
}