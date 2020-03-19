package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("4이상의 랜덤한 숫자가 주어지면, 자동차는 이동여부를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"4:true", "1:false", "9:true", "0:false"}, delimiter = ':')
    void canRunTest(int input, boolean expected) {
        //given
        int randomNum = input;
        Car car = new Car();

        //when
        boolean canRun = car.canRun(randomNum);

        //then
        assertThat(canRun).isEqualTo(expected);
    }

    @DisplayName("canRun의 값이 true이면 자동차의 position 값에 1을 추가한다.")
    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"})
    void moveTest(boolean inputCanRun, int position) {
        //given
        Car car = new Car();
        boolean canRun = inputCanRun;

        //when
        car.move(canRun);

        //then
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
