package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;
import lotto.service.helper.LottoFactory;
import lotto.service.helper.WinningChecker;

import java.util.Collection;
import java.util.List;

public class LottoServiceImpl implements LottoService {
    @Override
    public List<Lotto> buyLottos(int amount) {
        return LottoFactory.buyLottos(amount);
    }

    @Override
    public WinningStatistic getResult(WinningNumber winningNumber, Collection<Lotto> boughtLottos) {
        return WinningChecker.getResult(winningNumber, boughtLottos);
    }
}
