package lotto.domain;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private final Random random = new Random();
    private final Set<Integer> numbers;

    public Lotto() {
        numbers = new TreeSet<>();
    }

    public Lotto(int maxNum, int size) {
        numbers = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            while (numbers.size() <= i) {
                numbers.add(random.nextInt(maxNum + 1));
            }
        }
    }

    public int numbersSize() {
        return numbers.size();
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
