package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoFactoryTest {
    private LottoFactory lottoFactory;

    @BeforeEach
    void init() {
        lottoFactory = new LottoFactory();
    }

    @Test
    @DisplayName("입력된 금액으로 구입할 수 있는 최대 갯수의 로또를 반환한다.")
    void buyLottoTest() {
        assertAll(
                () -> assertThat(lottoFactory.buyLotto(-1).size()).isEqualTo(0),
                () -> assertThat(lottoFactory.buyLotto(0).size()).isEqualTo(0),
                () -> assertThat(lottoFactory.buyLotto(999).size()).isEqualTo(0),
                () -> assertThat(lottoFactory.buyLotto(1000).size()).isEqualTo(1),
                () -> assertThat(lottoFactory.buyLotto(10000).size()).isEqualTo(10),
                () -> assertThat(lottoFactory.buyLotto(10500).size()).isEqualTo(10)
        );
    }
}
