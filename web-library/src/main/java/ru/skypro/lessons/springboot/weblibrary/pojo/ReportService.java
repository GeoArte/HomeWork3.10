package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Long saveReport(ResponseEntity<String> report) {
        Report savedReport = reportRepository.save(report);
        return savedReport.getId();
    }
}
