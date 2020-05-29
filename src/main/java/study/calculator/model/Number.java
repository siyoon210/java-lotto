package study.calculator.model;

public class Number {
    private int value;

    public Number(String str) {
        this.value = getIntFromString(str);
    }

    public int getValue() {
        return value;
    }

    private int getIntFromString(String str) {
        if(str.isEmpty()) {
            throw new IllegalArgumentException("빈 문자가 존재합니다.");
        }

        int number = Integer.parseInt(str);

        if(number < 0) {
            throw new IllegalArgumentException("음수는 입력 불가능 합니다.");
        }

        return number;
    }
}