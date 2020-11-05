package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoFactory {
    public List<Lotto> buyLotto(int amount) {
        return Arrays.asList(new Lotto(), new Lotto(), new Lotto(), new Lotto(), new Lotto(), new Lotto(), new Lotto(), new Lotto(), new Lotto(), new Lotto());
    }
}
