package ru.skypro.lessons.springboot.weblibrary.pojo;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department")
    private String department;

    @Column(name = "employee_count")
    private int employeeCount;

    @Column(name = "max_salary")
    private BigDecimal maxSalary;

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "avg_salary")
    private BigDecimal avgSalary;

    @Column(name =  "file_path")
    private String filePath;


    public String getDepartment() {
        return department;
    }

    public BigDecimal getAvgSalary() {
        return avgSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public Long getId() {
        return id;
    }

    public void setAvgSalary(BigDecimal avgSalary) {
        this.avgSalary = avgSalary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
