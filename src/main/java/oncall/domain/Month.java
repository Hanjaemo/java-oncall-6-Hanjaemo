package oncall.domain;

import java.util.Arrays;
import java.util.List;

public enum Month {

    JANUARY(1, 31, List.of(1)),
    FEBRUARY(2, 28, List.of(0)),
    MARCH(3, 31, List.of(1)),
    APRIL(4, 30, List.of(0)),
    MAY(5, 31, List.of(5)),
    JUNE(6, 30, List.of(6)),
    JULY(7, 31, List.of(0)),
    AUGUST(8, 31, List.of(15)),
    SEPTEMBER(9, 30, List.of(0)),
    OCTOBER(10, 31, List.of(3, 9)),
    NOVEMBER(11, 30, List.of(0)),
    DECEMBER(12, 31, List.of(25));

    private final int month;
    private final int lastDay;
    private final List<Integer> holidays;

    Month(int month, int lastDay, List<Integer> holidays) {
        this.month = month;
        this.lastDay = lastDay;
        this.holidays = holidays;
    }

    public static Month of(int input) {
        return Arrays.stream(Month.values())
                .filter(month -> month.month == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다.")); // TODO 예외처리
    }

    public boolean isHoliday(int day) {
        return holidays.contains(day);
    }

    public int getLastDay() {
        return lastDay;
    }

    public int getMonth() {
        return month;
    }
}
