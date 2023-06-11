package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/salary/sum")
    public ResponseEntity<Integer> getSalarySum() {
        int salarySum = employeeService.getSalarySum();
        return ResponseEntity.ok(salarySum);
    }

    @GetMapping("/salary/min")
    public ResponseEntity<Employee> getMinSalaryEmployee() {
        Employee employee = employeeService.getMinSalaryEmployee();
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/salary/max")
    public ResponseEntity<Employee> getMaxSalaryEmployee() {
        Employee employee = employeeService.getMaxSalaryEmployee();
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/high-salary")
    public ResponseEntity<List<Employee>> getHighSalaryEmployees() {
        List<Employee> employees = employeeService.getHighSalaryEmployees();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Void> createEmployees(@RequestBody List<Employee> employees) {
        for (Employee employee : employees) {
            employeeService.addEmployee(employee);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        if (id != employee.getId()) {
            return ResponseEntity.badRequest().build();
        }
        if (employeeService.getEmployeeById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/salaryHigherThan")
    public ResponseEntity<List<Employee>> getEmployeesWithSalaryHigherThan(@RequestParam int salary) {
        List<Employee> employees = employeeService.getEmployeesWithSalaryHigherThan(salary);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/withHighestSalary")
    public List<Employee> getEmployeesWithHighestSalary() {
        return employeeService.getEmployeesWithHighestSalary();
    }

    @GetMapping
    public List<Employee> getEmployeesByPosition(@RequestParam(required = false) String position) {
        if (position != null && !position.isEmpty()) {
            return employeeService.getEmployeesByPosition(position);
        } else {
            return employeeService.findAllEmployees();
        }
    }

    @GetMapping("/{id}/fullInfo")
    public Employee getEmployeeFullInfo(@PathVariable int id) {
        return employeeService.getEmployeeFullInfo(id);
    }

    @GetMapping("/page")
    public List<Employee> getEmployeesByPage(@RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        return employeeService.getEmployeesByPage(page);
    }
}






