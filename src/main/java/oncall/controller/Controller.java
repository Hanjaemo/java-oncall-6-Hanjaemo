package oncall.controller;

import java.util.List;
import java.util.stream.Collectors;
import oncall.Constants;
import oncall.domain.DayOfWeek;
import oncall.domain.Employee;
import oncall.domain.EmployeeAssigner;
import oncall.domain.Employees;
import oncall.domain.Month;
import oncall.domain.MonthAndDayOfWeek;
import oncall.domain.Result;
import oncall.exception.ExceptionHandler;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Controller {

    public void run() {
        MonthAndDayOfWeek monthAndDayOfWeek = ExceptionHandler.handleSupplier(
                () -> createMonthAndDayOfWeek(InputView.readMonthAndDayOfWeek()));
        
        Employees weekdayEmployees = ExceptionHandler.handleSupplier(() -> createEmployees(Constants.WEEKDAY));
        Employees holidayEmployees = ExceptionHandler.handleSupplier(() -> createEmployees(Constants.HOLIDAY));

        EmployeeAssigner employeeAssigner = new EmployeeAssigner(weekdayEmployees, holidayEmployees);
        Result result = employeeAssigner.assignWorkers(monthAndDayOfWeek);
        OutputView.printResult(monthAndDayOfWeek, result);
    }

    private MonthAndDayOfWeek createMonthAndDayOfWeek(List<String> inputMonthAndDayOfWeek) {
        return new MonthAndDayOfWeek(
                Month.of(Integer.parseInt(inputMonthAndDayOfWeek.get(0))),
                DayOfWeek.of(inputMonthAndDayOfWeek.get(1)));
    }

    private Employees createEmployees(String weekdayOrHoliday) {
        return new Employees(InputView.readEmployees(weekdayOrHoliday).stream()
                .map(Employee::new)
                .collect(Collectors.toList()));
    }
}
