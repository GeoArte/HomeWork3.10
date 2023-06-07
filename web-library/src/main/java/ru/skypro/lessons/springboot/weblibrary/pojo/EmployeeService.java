package ru.skypro.lessons.springboot.weblibrary.pojo;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    int getSalarySum();
    Employee getMinSalaryEmployee();
    Employee getMaxSalaryEmployee();
    List<Employee> getHighSalaryEmployees();
}
