package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    // Коллекция для имитации данных
    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 90_000),
            new Employee("Дима", 102_000),
            new Employee("Олег", 80_000),
            new Employee("Вика", 165_000));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
    @Override
    public Employee getEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == employee.getId()) {
                employeeList.set(i, employee);
                return;
            }
        }
    }

    @Override
    public void deleteEmployee(int id) {
        employeeList.removeIf(employee -> employee.getId() == id);
    }

    @Override
    public List<Employee> getEmployeesWithSalaryHigherThan(int salary) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getSalary() > salary) {
                result.add(employee);
            }
        }
        return result;
    }
}
