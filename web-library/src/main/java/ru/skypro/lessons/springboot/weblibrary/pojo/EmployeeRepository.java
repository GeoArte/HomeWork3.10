package ru.skypro.lessons.springboot.weblibrary.pojo;

import java.util.List;

public interface EmployeeRepository {

    public List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> getEmployeesWithSalaryHigherThan(int salary);
}
