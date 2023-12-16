package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<Employee> employees = new ArrayList<>();
    private final List<DayOfWeek> dayOfWeeks = new ArrayList<>();

    public void addEmployee(Employee employee, DayOfWeek dayOfWeek, Employees dayEmployees) {
        if (employees.isEmpty()) {
            addEmployeeAndDayOfWeek(employee, dayOfWeek);
            return;
        }
        if (employees.get(employees.size() - 1).equals(employee)) {
            addEmployeeAndDayOfWeek(dayEmployees.findNextEmployee(), dayOfWeek);
            return;
        }
        addEmployeeAndDayOfWeek(employee, dayOfWeek);
    }

    private void addEmployeeAndDayOfWeek(Employee employee, DayOfWeek dayOfWeek) {
        employees.add(employee);
        dayOfWeeks.add(dayOfWeek);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<String> getDayOfWeeks() {
        return dayOfWeeks.stream().map(DayOfWeek::getName).toList();
    }
}
