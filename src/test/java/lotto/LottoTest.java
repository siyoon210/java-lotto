package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("Lotto는 지정된 범위내의 서로 다른 숫자를 size만큼 가진다.")
    void create() {
        int maxNum = 45;
        int size = 6;

        Lotto lotto = new Lotto(maxNum, size);
        assertThat(lotto.numbersSize()).isEqualTo(size);
    }
}
