package ru.skypro.lessons.springboot.weblibrary.pojo;

import java.math.BigDecimal;

public class DepartmentStatistics {
    private String departmentName;
    private int employeeCount;
    private BigDecimal maxSalary;
    private BigDecimal minSalary;
    private BigDecimal avgSalary;

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public BigDecimal getAvgSalary() {
        return avgSalary;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setAvgSalary(BigDecimal avgSalary) {
        this.avgSalary = avgSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
