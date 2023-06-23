package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}
