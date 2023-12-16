package oncall.domain;

import java.util.Arrays;

public enum DayOfWeek {

    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String input;

    DayOfWeek(String input) {
        this.input = input;
    }

    public static DayOfWeek of(String input) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다.")); // TODO 예외처리
    }
}
