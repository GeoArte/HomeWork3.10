package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> showCounter() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/salary/sum")
    public int getSalarySum() {
        return employeeService.getSalarySum();
    }

    @GetMapping("/salary/min")
    public Employee getMinSalaryEmployee() {
        return employeeService.getMinSalaryEmployee();
    }

    @GetMapping("/salary/max")
    public Employee getMaxSalaryEmployee() {
        return employeeService.getMaxSalaryEmployee();
    }

    @GetMapping("/high-salary")
    public List<Employee> getHighSalaryEmployees() {
        return employeeService.getHighSalaryEmployees();
    }

}
