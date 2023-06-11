package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeInfo {

    @Value("#{target.name + ' ' + target.salary}")
    String getFullInfo();
}
