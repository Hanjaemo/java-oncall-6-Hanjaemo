package oncall.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import oncall.exception.ErrorMessage;

public class Employees {

    private static final int MIN_EMPLOYEES_SIZE = 5;
    private static final int MAX_EMPLOYEES_SIZE = 35;

    private final List<Employee> employees;
    private final Deque<Employee> waitingEmployees = new ArrayDeque<>();
    private int turnNumber;

    public Employees(List<Employee> employees) {
        if (employees.size() < MIN_EMPLOYEES_SIZE || employees.size() > MAX_EMPLOYEES_SIZE) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_EMPLOYEES_BY_SIZE.getMessage(),
                            MIN_EMPLOYEES_SIZE, MAX_EMPLOYEES_SIZE));
        }
        if (Set.copyOf(employees).size() != employees.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_EMPLOYEES_BY_DUPLICATED.getMessage());
        }
        this.employees = employees;
        this.turnNumber = 0;
    }

    public Employee findNextEmployee() {
        if (waitingEmployees.size() > 0) {
            initTurnNumberIfFull();
            turnNumber++;
            return waitingEmployees.poll();
        }
        initTurnNumberIfFull();
        return employees.get(turnNumber++);
    }

    private void initTurnNumberIfFull() {
        if (turnNumber == employees.size()) {
            turnNumber = 0;
        }
    }

    public Employee findTempEmployee(Employee employee) {
        waitingEmployees.add(employee);
        return employees.get(turnNumber);
    }
}
