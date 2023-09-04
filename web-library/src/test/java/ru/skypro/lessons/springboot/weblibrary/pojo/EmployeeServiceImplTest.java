package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ReportRepository reportRepository;

    @Test
    public void testGetSalarySum() {
        // Создание тестовых данных
        Employee employee1 = new Employee();
        employee1.setSalary(100);
        Employee employee2 = new Employee();
        employee2.setSalary(200);

        // Мокируем вызовы к employeeRepository.findAllEmployees()
        when(employeeRepository.findAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        // Вызываем метод, который мы тестируем
        int result = employeeService.getSalarySum();

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(300, result);
    }

    @Test
    public void testGetMinSalaryEmployee() {
        // Создание тестовых данных
        Employee employee1 = new Employee();
        employee1.setSalary(100);
        Employee employee2 = new Employee();
        employee2.setSalary(200);

        // Мокируем вызовы к employeeRepository.findAllEmployees()
        when(employeeRepository.findAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        // Вызываем метод, который мы тестируем
        Employee result = employeeService.getMinSalaryEmployee();

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(employee1, result);
    }

    @Test
    public void testGetMaxSalaryEmployee() {
        // Создание тестовых данных
        Employee employee1 = new Employee();
        employee1.setSalary(100);
        Employee employee2 = new Employee();
        employee2.setSalary(200);

        // Мокируем вызовы к employeeRepository.findAllEmployees()
        when(employeeRepository.findAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        // Вызываем метод, который мы тестируем
        Employee result = employeeService.getMaxSalaryEmployee();

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(employee2, result);
    }

    @Test
    public void testGetHighSalaryEmployees() {
        // Создание тестовых данных
        Employee employee1 = new Employee();
        employee1.setSalary(100);
        Employee employee2 = new Employee();
        employee2.setSalary(200);
        Employee employee3 = new Employee();
        employee3.setSalary(300);

        // Мокируем вызовы к employeeRepository.findAllEmployees()
        when(employeeRepository.findAllEmployees()).thenReturn(Arrays.asList(employee1, employee2, employee3));

        // Вызываем метод, который мы тестируем
        List<Employee> result = employeeService.getHighSalaryEmployees();

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(1, result.size()); // Ожидаем, что один сотрудник имеет зарплату выше средней
        assertEquals(employee3, result.get(0));
    }

    @Test
    public void testGetEmployeeById() {
        // Создание тестовых данных
        Employee employee = new Employee();
        employee.setId(1);

        // Мокируем вызовы к employeeRepository.findById()
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        // Вызываем метод, который мы тестируем
        Employee result = employeeService.getEmployeeById(1);

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(employee, result);
    }

    @Test
    public void testAddEmployee() {
        // Создание тестовых данных
        Employee employee = new Employee();

        // Вызываем метод, который мы тестируем
        employeeService.addEmployee(employee);

        // Проверяем, что метод employeeRepository.save() был вызван один раз
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void testUpdateEmployee() {
        // Создание тестовых данных
        Employee employee = new Employee();

        // Вызываем метод, который мы тестируем
        employeeService.updateEmployee(employee);

        // Проверяем, что метод employeeRepository.save() был вызван один раз
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void testDeleteEmployeeById() {
        // Вызываем метод, который мы тестируем
        employeeService.deleteEmployeeById(1);

        // Проверяем, что метод employeeRepository.deleteById() был вызван один раз с аргументом 1
        verify(employeeRepository, times(1)).deleteById(1);
    }

    @Test
    public void testGetEmployeesWithSalaryGreaterThan() {
        // Создание тестовых данных
        Employee employee1 = new Employee();
        employee1.setSalary(100);
        Employee employee2 = new Employee();
        employee2.setSalary(200);

        // Мокируем вызовы к employeeRepository.getEmployeesBySalaryGreaterThan()
        when(employeeRepository.getEmployeesBySalaryGreaterThan(150)).thenReturn(Arrays.asList(employee2));

        // Вызываем метод, который мы тестируем
        List<Employee> result = employeeService.getEmployeesWithSalaryGreaterThan(150);

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(1, result.size()); // Ожидаем, что один сотрудник имеет зарплату больше 150
        assertEquals(employee2, result.get(0));
    }

    @Test
    public void testGetEmployeesWithHighestSalary() {
        // Создание тестовых данных
        Employee employee1 = new Employee();
        employee1.setSalary(100);
        Employee employee2 = new Employee();
        employee2.setSalary(200);

        // Мокируем вызовы к employeeRepository.findEmployeesWithHighestSalary()
        when(employeeRepository.findEmployeesWithHighestSalary()).thenReturn(Arrays.asList(employee2));

        // Вызываем метод, который мы тестируем
        List<Employee> result = employeeService.getEmployeesWithHighestSalary();

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(1, result.size()); // Ожидаем, что один сотрудник имеет максимальную зарплату
        assertEquals(employee2, result.get(0));
    }

    @Test
    public void testGetEmployeesByPosition() {
        // Создание тестовых данных
        String positionName = "Engineer"; // Название должности (просто строка)

        // Создаем экземпляр класса Position
        Position position = new Position();
        position.setName(positionName);

        Employee employee1 = new Employee();
        employee1.setPosition(position);
        Employee employee2 = new Employee();
        employee2.setPosition(new Position()); // Другой объект Position

        // Мокируем вызовы к employeeRepository.findEmployeesByPosition()
        when(employeeRepository.findEmployeesByPosition(position.getName())).thenReturn(Arrays.asList(employee1));

        // Вызываем метод, который мы тестируем
        List<Employee> result = employeeService.getEmployeesByPosition(position.getName());

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(1, result.size()); // Ожидаем, что один сотрудник имеет позицию "Engineer"
        assertEquals(employee1, result.get(0));
    }

    @Test
    public void testGetEmployeeFullInfo() {
        // Создание тестовых данных
        int employeeId = 1;
        Employee employee = new Employee();
        employee.setId(employeeId);

        // Мокируем вызовы к employeeRepository.findById()
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        // Вызываем метод, который мы тестируем
        Employee result = employeeService.getEmployeeFullInfo(employeeId);

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(employee, result);
    }

    @Test
    public void testGetEmployeesByPage() {
        // Создание тестовых данных
        int page = 1;
        int pageSize = 10;
        int offset = page * pageSize;

        Employee employee1 = new Employee();
        employee1.setId(1);
        Employee employee2 = new Employee();
        employee2.setId(2);
        Employee employee3 = new Employee();
        employee3.setId(3);

        // Мокируем вызовы к employeeRepository.findEmployeesByPage()
        when(employeeRepository.findEmployeesByPage(offset, pageSize)).thenReturn(Arrays.asList(employee1, employee2, employee3));

        // Вызываем метод, который мы тестируем
        List<Employee> result = employeeService.getEmployeesByPage(page);

        // Проверяем, что результат соответствует ожиданиям
        assertEquals(3, result.size()); // Ожидаем, что вернется 3 сотрудника
        assertEquals(employee1, result.get(0));
        assertEquals(employee2, result.get(1));
        assertEquals(employee3, result.get(2));
    }

    @Test
    public void testGetEmployeeReportById() {
        // Создание тестовых данных
        int reportId = 1;
        Report report = new Report();
        report.setFilePath("/path/to/report.json");

        // Мокируем вызовы к reportRepository.findById()
        when(reportRepository.findById(reportId)).thenReturn(Optional.of(report));

        // Вызываем метод, который мы тестируем
        File result = employeeService.getEmployeeReportById(reportId);

        // Проверяем, что результат соответствует ожиданиям
        assertNotNull(result); // Ожидаем, что результат не равен null
    }

    @Test
    public void testSaveReportToFile() throws IOException {
        // Создание тестовых данных
        String jsonContent = "{\"department\": \"HR\", \"employeeCount\": 5}";

        // Мокируем вызовы к reportRepository.saveReportToFile()
        when(employeeService.saveReportToFile(jsonContent)).thenReturn("/path/to/save/directory/report.json");

        // Вызываем метод, который мы тестируем
        String result = employeeService.saveReportToFile(jsonContent);

        // Проверяем, что результат соответствует ожиданиям
        assertNotNull(result); // Ожидаем, что результат не равен null
    }

    @Test
    public void testSaveReport() {
        // Создание тестовых данных
        Report report = new Report();

        // Мокируем вызовы к reportRepository.save()
        when(reportRepository.save(report)).thenReturn(report);

        // Вызываем метод, который мы тестируем
        Long result = employeeService.saveReport(report);

        // Проверяем, что результат соответствует ожиданиям
        assertNotNull(result); // Ожидаем, что результат не равен null
    }

    @Test
    public void testReadFileContent() throws IOException {
        // Создание тестовых данных
        String filePath = "/path/to/save/directory/report.json";

        // Мокируем вызовы к employeeService.readFileContent()
        when(employeeService.readFileContent(filePath)).thenReturn("{\"department\": \"HR\", \"employeeCount\": 5}");

        // Вызываем метод, который мы тестируем
        String result = employeeService.readFileContent(filePath);

        // Проверяем, что результат соответствует ожиданиям
        assertNotNull(result); // Ожидаем, что результат не равен null
    }

    @Test
    public void testGetReportFilePathById() {
        // Создание тестовых данных
        int reportId = 1;
        Report report = new Report();
        report.setFilePath("/path/to/report.json");

        // Мокируем вызовы к reportRepository.findById()
        when(reportRepository.findById(reportId)).thenReturn(Optional.of(report));

        // Вызываем метод, который мы тестируем
        String result = employeeService.getReportFilePathById(reportId);

        // Проверяем, что результат соответствует ожиданиям
        assertNotNull(result); // Ожидаем, что результат не равен null
    }
}