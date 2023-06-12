package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    int getSalarySum();
    Employee getMinSalaryEmployee();
    Employee getMaxSalaryEmployee();
    List<Employee> getHighSalaryEmployees();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(int id);
    List<Employee> getEmployeesWithSalaryGreaterThan(int salary);

    List<Employee> getEmployeesWithHighestSalary();

    List<Employee> getEmployeesByPosition(String position);

    Employee getEmployeeFullInfo(int id);


    List<Employee> getEmployeesByPage(int page);
}