package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
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
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> getEmployeesWithSalaryHigherThan(int salary) {
        return employeeRepository.getEmployeesWithSalaryHigherThan(salary);
    }
}
