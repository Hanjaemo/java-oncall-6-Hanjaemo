package oncall.domain;

public class MonthAndDayOfWeek {

    private final Month month;
    private DayOfWeek dayOfWeek;

    public MonthAndDayOfWeek(int month, String dayOfWeek) {
        this.month = Month.of(month);
        this.dayOfWeek = DayOfWeek.of(dayOfWeek);
    }

    public boolean isHoliday(int day) {
        return dayOfWeek.isHoliday() || month.isHoliday(day);
    }

    public boolean isWeekDay(int day) {
        return !isHoliday(day);
    }

    public void shiftDayOfWeek() {
        if (dayOfWeek == DayOfWeek.SUNDAY) {
            dayOfWeek = DayOfWeek.MONDAY;
            return;
        }
        dayOfWeek = DayOfWeek.of(dayOfWeek.getOrdinal() + 1);
    }

    public int getLastDay() {
        return month.getLastDay();
    }

    public int getMonth() {
        return month.getMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
