package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCheckerTest {
    @Test
    @DisplayName("구매한 로또들과 지난 주 당첨 번호로, 등수별 당첨 여부와 수익이 얼마나 되는지 계산한다.")
    void winningAndStatisticTest() {
        List<Lotto> boughtLottos = new ArrayList<>();
        boughtLottos.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)));
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningChecker winningChecker = new WinningChecker();
        WinningStatistic winningStatistic = winningChecker.getResult(winningNumbers, boughtLottos);

        assertThat(winningStatistic.getEarningsRate()).isEqualTo(0);

        List<Lotto> boughtLottos2 = new ArrayList<>();
        boughtLottos2.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        WinningStatistic winningStatistic2 = winningChecker.getResult(winningNumbers, boughtLottos2);

        assertThat(winningStatistic2.getEarningsRate()).isEqualTo((double) WinningRank.MATCHES_SIX.winningAmount / LottoFactory.PRICE_OF_ONE_LOTTO);
    }
}
