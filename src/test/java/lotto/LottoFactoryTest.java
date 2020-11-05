package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {
    private LottoFactory lottoFactory;

    @BeforeEach
    void init() {
        lottoFactory = new LottoFactory();
    }

    @Test
    @DisplayName("입력된 금액으로 구입할 수 있는 최대 갯수의 로또를 반환한다.")
    void buyLottoTest() {
        int amount = 10000;
        List<Lotto> lottos =  lottoFactory.buyLotto(amount);
        assertThat(lottos.size()).isEqualTo(10);
    }
}
