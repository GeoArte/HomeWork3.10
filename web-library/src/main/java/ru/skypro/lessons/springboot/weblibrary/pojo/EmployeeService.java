package ru.skypro.lessons.springboot.weblibrary.pojo;

import java.io.IOException;
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

    Report getEmployeeReportById(int id);

    List<DepartmentStatistics> getDepartmentStatistics();
    String generateReportJson();

    String saveReportToFile(String reportJson) throws IOException;

    public Long saveReport(Report report);

    public String readFileContent(String filePath);

    public String getReportFilePathById(Long id);
}