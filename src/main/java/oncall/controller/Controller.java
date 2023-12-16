package oncall.controller;

import java.util.List;
import java.util.stream.Collectors;
import oncall.domain.Employee;
import oncall.domain.MonthAndDayOfWeek;
import oncall.domain.WeekdayEmployees;
import oncall.view.InputView;

public class Controller {

    public void run() {
        List<String> inputMonthAndDayOfWeek = InputView.readMonthAndDayOfWeek();
        MonthAndDayOfWeek monthAndDayOfWeek = new MonthAndDayOfWeek(
                Integer.parseInt(inputMonthAndDayOfWeek.get(0)),
                inputMonthAndDayOfWeek.get(1));

        WeekdayEmployees weekdayEmployees = new WeekdayEmployees(InputView.readEmployees().stream()
                .map(Employee::new)
                .collect(Collectors.toList()));
    }
}
