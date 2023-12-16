package oncall.domain;

import java.util.List;
import java.util.Set;

public abstract class Employees {

    protected List<Employee> employees;

    public Employees(List<Employee> employees) {
        if (employees.size() < 5 || employees.size() > 35) {
            throw new IllegalArgumentException("직원은 5명 이상 35명 이하로 입력해주세요."); // TODO 예외처리
        }
        if (Set.copyOf(employees).size() != employees.size()) {
            throw new IllegalArgumentException("직원 이름은 중복되지 않게 입력해주세요."); // TODO 예외처리
        }
        this.employees = employees;
    }
}
