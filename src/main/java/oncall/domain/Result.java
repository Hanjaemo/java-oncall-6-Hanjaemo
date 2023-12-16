package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final List<Employee> employees = new ArrayList<>();
    private final List<DayOfWeek> dayOfWeeks = new ArrayList<>();

    public void addEmployee(Employee employee, DayOfWeek dayOfWeek, Employees dayEmployees) {
        if (employees.isEmpty()) {
            employees.add(employee);
            dayOfWeeks.add(dayOfWeek);
            return;
        }
        if (employees.get(employees.size() - 1).equals(employee)) {
            employees.add(dayEmployees.findTempEmployee(employee));
            dayOfWeeks.add(dayOfWeek);
            return;
        }
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
