package oncall.domain;

import java.util.Arrays;

public enum DayOfWeek {

    MONDAY("월", 1),
    TUESDAY("화", 2),
    WEDNESDAY("수", 3),
    THURSDAY("목", 4),
    FRIDAY("금", 5),
    SATURDAY("토", 6),
    SUNDAY("일", 7);

    private final String name;
    private final int ordinal;

    DayOfWeek(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public static DayOfWeek of(String input) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.name.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다.")); // TODO 예외처리
    }

    public static DayOfWeek of(int ordinal) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.ordinal == ordinal)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다.")); // TODO 예외처리
    }

    public boolean isHoliday() {
        return this == SATURDAY || this == SUNDAY;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public String getName() {
        return name;
    }
}
