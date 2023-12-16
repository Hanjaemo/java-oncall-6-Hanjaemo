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
        return result;
    }
}
