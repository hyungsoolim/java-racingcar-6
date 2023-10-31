package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("자동차 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2"})
    public void create(String carName) {
        // when
        Car car = new Car(carName);

        // then
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "123456"})
    public void createFail(String carName) {
        //then
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}
