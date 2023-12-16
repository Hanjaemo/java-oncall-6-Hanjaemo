package oncall.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Set;

public class Employees {

    private final List<Employee> employees;
    private int turnNumber;
    private Deque<Employee> waitingEmployees = new ArrayDeque<>();

    public Employees(List<Employee> employees) {
        if (employees.size() < 5 || employees.size() > 35) {
            throw new IllegalArgumentException("직원은 5명 이상 35명 이하로 입력해주세요."); // TODO 예외처리
        }
        if (Set.copyOf(employees).size() != employees.size()) {
            throw new IllegalArgumentException("직원 이름은 중복되지 않게 입력해주세요."); // TODO 예외처리
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
