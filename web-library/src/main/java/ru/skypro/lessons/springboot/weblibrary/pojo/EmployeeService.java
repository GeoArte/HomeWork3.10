package ru.skypro.lessons.springboot.weblibrary.pojo;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    int getSalarySum();
    Employee getMinSalaryEmployee();
    Employee getMaxSalaryEmployee();
    List<Employee> getHighSalaryEmployees();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> getEmployeesWithSalaryHigherThan(int salary);
}
