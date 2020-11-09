package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.WinningRank.MATCHES_FIVE;
import static lotto.domain.WinningRank.MATCHES_FOUR;
import static lotto.domain.WinningRank.MATCHES_SIX;
import static lotto.domain.WinningRank.MATCHES_THREE;
import static lotto.domain.WinningRank.NONE;
import static lotto.domain.WinningRank.getWinningRank;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningRankTest {
    @Test
    @DisplayName("당첨번호와 구입한 로또번호로 당첨타입을 확인한다.")
    void winningRank_test() {
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertAll(
                () -> assertThat(getWinningRank(winningLotto, new Lotto(1, 2, 3, 4, 5, 6)))
                        .isEqualTo(MATCHES_SIX),
                () -> assertThat(getWinningRank(winningLotto, new Lotto(1, 2, 3, 4, 5, 7)))
                        .isEqualTo(MATCHES_FIVE),
                () -> assertThat(getWinningRank(winningLotto, new Lotto(1, 2, 3, 4, 7, 8)))
                        .isEqualTo(MATCHES_FOUR),
                () -> assertThat(getWinningRank(winningLotto, new Lotto(1, 2, 3, 7, 8, 9)))
                        .isEqualTo(MATCHES_THREE),
                () -> assertThat(getWinningRank(winningLotto, new Lotto(1, 2, 7, 8, 9, 10)))
                        .isEqualTo(NONE)
        );
    }
}
