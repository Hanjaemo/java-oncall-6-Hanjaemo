package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import oncall.domain.Employee;
import oncall.domain.Employees;
import oncall.domain.MonthAndDayOfWeek;
import oncall.domain.Result;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Controller {

    public void run() {
        List<String> inputMonthAndDayOfWeek = InputView.readMonthAndDayOfWeek();
        MonthAndDayOfWeek monthAndDayOfWeek = new MonthAndDayOfWeek(
                Integer.parseInt(inputMonthAndDayOfWeek.get(0)),
                inputMonthAndDayOfWeek.get(1));

        Employees weekdayEmployees = new Employees(InputView.readEmployees("평일").stream()
                .map(Employee::new)
                .collect(Collectors.toList()));

        Employees holidayEmployees = new Employees(InputView.readEmployees("휴일").stream()
                .map(Employee::new)
                .collect(Collectors.toList()));

        Result result = new Result();
        for (int day = 1; day <= monthAndDayOfWeek.getLastDay(); day++) {
            Employee nextEmployee;
            if (monthAndDayOfWeek.isHoliday(day)) {
                nextEmployee = holidayEmployees.findNextEmployee();
                result.addEmployee(nextEmployee, monthAndDayOfWeek.getDayOfWeek(), holidayEmployees);
                monthAndDayOfWeek.shiftDayOfWeek();
                continue;
            }
            nextEmployee = weekdayEmployees.findNextEmployee();
            result.addEmployee(nextEmployee, monthAndDayOfWeek.getDayOfWeek(), weekdayEmployees);
            monthAndDayOfWeek.shiftDayOfWeek();
        }
        OutputView.printResult(monthAndDayOfWeek, result);
    }
}
