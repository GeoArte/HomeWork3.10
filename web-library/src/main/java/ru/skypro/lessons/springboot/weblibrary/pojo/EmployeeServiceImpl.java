package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public List<EmployeeDTO> getAllEmployees() {
        // Получаем список сотрудников из репозитория,
        // Преобразуем их в DTO и собираем в список
        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }
    public int getSalarySum() {
        int sum = 0;
        List<Employee> employees = employeeRepository.getAllEmployees();
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee getMinSalaryEmployee() {
        List<Employee> employees = employeeRepository.getAllEmployees();
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
        List<Employee> employees = employeeRepository.getAllEmployees();
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
        List<Employee> employees = employeeRepository.getAllEmployees();
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
        return employeeRepository.getEmployeesWithSalaryGreaterThan(salary);
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
}
