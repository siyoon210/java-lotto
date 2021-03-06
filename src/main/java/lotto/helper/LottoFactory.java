package lotto.helper;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.ManualLottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final List<Integer> NUMBERS;

    static {
        NUMBERS = new ArrayList<>();
        for (int i = LottoNumber.VALID_MIN_NUMBER; i <= LottoNumber.VALID_MAX_NUMBER; i++) {
            NUMBERS.add(i);
        }
    }

    private LottoFactory() {
    }

    public static Lottos buyLottos(ManualLottoNumbers manualLottoNumbers, Amount amount) {
        List<Lotto> lottos = new ArrayList<>();

        manualLottoNumbers.addManualLottos(lottos, amount);

        while (amount.isOverLottoPrice()) {
            Collections.shuffle(NUMBERS);
            lottos.add(Lotto.of(NUMBERS.subList(0, Lotto.VALID_NUMBERS_SIZE)));
            amount.subtractOneLottoPrice();
        }

        return Lottos.of(lottos);
    }
}
