package oncall.domain;

public class MonthAndDayOfWeek {

    private final Month month;
    private final DayOfWeek dayOfWeek;

    public MonthAndDayOfWeek(int month, String dayOfWeek) {
        this.month = Month.of(month);
        this.dayOfWeek = DayOfWeek.of(dayOfWeek);
    }

    public Month getMonth() {
        return month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
