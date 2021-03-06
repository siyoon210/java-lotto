package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;
import lotto.helper.ValidInputHelper;
import lotto.helper.WinningChecker;
import lotto.view.View;

public class StatisticPrinter {
    private final View view;

    public StatisticPrinter(View view) {
        this.view = view;
    }

    public void printStatistic(Lottos boughtLottos) {
        WinningNumber winningNumber = getWinningNumber();
        WinningStatistic winningStatistic = WinningChecker.getResult(winningNumber, boughtLottos);
        view.printWinningStatistic(winningStatistic);
    }

    private WinningNumber getWinningNumber() {
        Lotto winningLotto = ValidInputHelper.get(() -> getWinningLotto(), view::printInputError);
        BonusNumber bonusNumber = ValidInputHelper.get(() -> getBonusLottoNumber(winningLotto), view::printInputError);
        return new WinningNumber(winningLotto, bonusNumber);
    }

    private Lotto getWinningLotto() {
        return Lotto.of(view.getWinningNumbers());
    }

    private BonusNumber getBonusLottoNumber(Lotto winningLotto) {
        BonusNumber bonusNumber = BonusNumber.valueOf(view.getBonusNumber());
        bonusNumber.validateBonusNumber(winningLotto);
        return bonusNumber;
    }
}
