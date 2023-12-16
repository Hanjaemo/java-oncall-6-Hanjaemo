package oncall.domain;

public class EmployeeAssigner {

    private final Employees weekdayEmployees;
    private final Employees holidayEmployees;

    public EmployeeAssigner(Employees weekdayEmployees, Employees holidayEmployees) {
        this.weekdayEmployees = weekdayEmployees;
        this.holidayEmployees = holidayEmployees;
    }

    public Result assignWorkers(MonthAndDayOfWeek monthAndDayOfWeek) {
        Result result = new Result();
        for (int day = 1; day <= monthAndDayOfWeek.getLastDay(); day++) {
            if (monthAndDayOfWeek.isHoliday(day)) {
                addEmployeeToResult(monthAndDayOfWeek, holidayEmployees, result);
                continue;
            }
            addEmployeeToResult(monthAndDayOfWeek, weekdayEmployees, result);
        }
        return result;
    }

    private void addEmployeeToResult(MonthAndDayOfWeek monthAndDayOfWeek, Employees employees, Result result) {
        result.addEmployee(employees.findNextEmployee(), monthAndDayOfWeek.getDayOfWeek(), employees);
        monthAndDayOfWeek.shiftDayOfWeek();
    }
}
