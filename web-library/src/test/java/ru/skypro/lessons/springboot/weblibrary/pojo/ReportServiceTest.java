package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private ReportRepository reportRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveReport() {
        // Создание тестовых данных
        Report report = new Report();

        // Вызываем метод, который мы тестируем
        employeeService.saveReport(report);

        // Проверяем, что метод reportRepository.save() был вызван один раз с аргументом report
        verify(reportRepository).save(report);
    }
}