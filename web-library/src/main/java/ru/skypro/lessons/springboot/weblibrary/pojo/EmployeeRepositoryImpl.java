package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository  {

    // Коллекция для имитации данных
    private final List<Position> positionList = List.of(
            new Position(1, "Рядовой сотрудник")
    );
    private final List<Employee> employeeList = List.of(
            new Employee(1,"Катя", 90_000, positionList.get(1)),
            new Employee(2, "Дима", 102_000, positionList.get(1)),
            new Employee(3, "Олег", 80_000, positionList.get(1)),
            new Employee(4, "Вика", 165_000, positionList.get(1)));

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

    @Override
    public <S extends Employee> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Employee> findAll() {
        return null;
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }


}
