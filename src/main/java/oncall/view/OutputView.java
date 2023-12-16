package oncall.view;

import java.util.List;
import oncall.domain.Employee;
import oncall.domain.MonthAndDayOfWeek;
import oncall.domain.Result;

public class OutputView {

    private OutputView() {
    }

    public static void printResult(MonthAndDayOfWeek monthAndDayOfWeek, Result result) {
        List<Employee> employees = result.getEmployees();
        List<String> dayOfWeeks = result.getDayOfWeeks();
        for (int day = 1; day <= monthAndDayOfWeek.getLastDay(); day++) {
            String format = "%d월 %d일 %s %s%n";
            if (monthAndDayOfWeek.isHoliday(day) && monthAndDayOfWeek.isWeekDay(day)) {
                format = "%d월 %d일 %s(휴일) %s%n";
            }
            System.out.printf(format, monthAndDayOfWeek.getMonth(), day, dayOfWeeks.get(day - 1),
                    employees.get(day - 1).getName());
        }
    }
}
