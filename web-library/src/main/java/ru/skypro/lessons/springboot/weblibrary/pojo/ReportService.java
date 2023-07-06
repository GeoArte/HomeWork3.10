package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public ReportService(ReportRepository reportRepository) {
        logger.info("Was invoked method for report service ");
        this.reportRepository = reportRepository;
    }

    public void saveReport(Report report) {
        reportRepository.save(report);
    }
}
