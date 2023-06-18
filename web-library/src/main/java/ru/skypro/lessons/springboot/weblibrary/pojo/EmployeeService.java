package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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

    Report getEmployeeReportById(int id);

    List<DepartmentStatistics> getDepartmentStatistics();
    String generateReportJson();

    saveReportToFile(String reportJson) throws IOException;

    public Long saveReport(Report report);

    public String readFileContent(String filePath);

    public String getReportFilePathById(Long id);
}