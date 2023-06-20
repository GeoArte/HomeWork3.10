package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ReportRepository reportRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ReportRepository reportRepository) {
        this.employeeRepository = employeeRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    public List<EmployeeDTO> getAllEmployees() {
        // Получаем список сотрудников из репозитория,
        // Преобразуем их в DTO и собираем в список
        return employeeRepository.findAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }
    public int getSalarySum() {
        int sum = 0;
        List<Employee> employees = employeeRepository.findAllEmployees();
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee getMinSalaryEmployee() {
        List<Employee> employees = employeeRepository.findAllEmployees();
        if (employees.isEmpty()) {
            return null;
        }
        Employee minSalaryEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee getMaxSalaryEmployee() {
        List<Employee> employees = employeeRepository.findAllEmployees();
        if (employees.isEmpty()) {
            return null;
        }
        Employee maxSalaryEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public List<Employee> getHighSalaryEmployees() {
        List<Employee> employees = employeeRepository.findAllEmployees();
        int averageSalary = getSalarySum() / employees.size();
        List<Employee> highSalaryEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() > averageSalary) {
                highSalaryEmployees.add(employee);
            }
        }
        return highSalaryEmployees;
    }
    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesWithSalaryGreaterThan(int salary) {
        return employeeRepository.getEmployeesBySalaryGreaterThan(salary);
    }
    public List<Employee> getEmployeesWithHighestSalary() {
        return employeeRepository.findEmployeesWithHighestSalary();
    }

    public List<Employee> getEmployeesByPosition(String position) {
        return employeeRepository.findEmployeesByPosition(position);
    }
    public Employee getEmployeeFullInfo(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployeesByPage(int page) {
        int pageSize = 10;
        int offset = page * pageSize;
        return employeeRepository.findEmployeesByPage(offset, pageSize);
    }

    public Report getEmployeeReportById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            // Получение отчета сотрудника
            Report report = reportRepository.findByEmployee(employee);
            return report;
        } else {
            return null;
        }
    }

    public List<DepartmentStatistics> getDepartmentStatistics() {
        return employeeRepository.getDepartmentStatistics();
    }

        private String generateUniqueFileName() {
        // Генерация уникального имени файла, например, на основе текущей даты и времени
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "report_" + timestamp + ".json";
    }

    private void saveFile(String content, String fileName) {
        // Логика сохранения файла в файловой системе на вашем компьютере
        // Например, можно использовать FileOutputStream
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String generateReportJson() {
        List<DepartmentStatistics> departmentStatistics = employeeRepository.getDepartmentStatistics();

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"report\": [");

        for (int i = 0; i < departmentStatistics.size(); i++) {
            DepartmentStatistics stats = departmentStatistics.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"department\": \"").append(stats.getDepartmentName()).append("\",");
            jsonBuilder.append("\"employeeCount\": ").append(stats.getEmployeeCount()).append(",");
            jsonBuilder.append("\"maxSalary\": ").append(stats.getMaxSalary()).append(",");
            jsonBuilder.append("\"minSalary\": ").append(stats.getMinSalary()).append(",");
            jsonBuilder.append("\"avgSalary\": ").append(stats.getAvgSalary());
            jsonBuilder.append("}");

            if (i < departmentStatistics.size() - 1) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("]");
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }

    public String saveReportToFile(String jsonContent) throws IOException {
        String fileName = UUID.randomUUID().toString() + ".json";
        String filePath = "/path/to/save/directory/" + fileName;

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonContent);
        }

        return filePath;
    }

    public Long saveReport(Report report) {
        Report savedReport = reportRepository.save(report);
        return savedReport.getId();
    }

    public String readFileContent(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            // Обработка ошибки чтения файла
            e.printStackTrace();
            return null;
        }
    }

    public String getReportFilePathById(Long id) {
        Optional<Report> reportOptional = reportRepository.findById(id);

        if (reportOptional.isPresent()) {
            Report report = reportOptional.get();
            return report.getFilePath();
        }

        return null;
    }
}
