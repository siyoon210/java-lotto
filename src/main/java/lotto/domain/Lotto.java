package lotto.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    public static final String INVALID_NUMBERS_SIZE_ERR_MSG = "로또 숫자의 개수가 유효하지 않습니다.";
    public static final int VALID_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(Collection<Integer> numbers) {
        this.numbers = Collections.unmodifiableSet(getLottoNumbersFrom(numbers));
        validateNumbersSize();
    }

    public Lotto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    private Set<LottoNumber> getLottoNumbersFrom(Collection<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private void validateNumbersSize() {
        if (numbers.size() != VALID_NUMBERS_SIZE) {
            throw new IllegalStateException(INVALID_NUMBERS_SIZE_ERR_MSG);
        }
    }

    public int getMatchedCountCompareTo(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
