package oncall.domain;

import java.util.Objects;

public class Employee {

    private final String name;

    public Employee(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하로 입력해주세요."); // TODO 예외처리
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
