package lotto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public static final int PRICE_OF_ONE_LOTTO = 1000;

    public List<Lotto> buyLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (; amount >= PRICE_OF_ONE_LOTTO; amount -= PRICE_OF_ONE_LOTTO) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
