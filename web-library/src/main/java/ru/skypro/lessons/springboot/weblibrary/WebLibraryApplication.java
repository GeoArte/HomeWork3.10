package ru.skypro.lessons.springboot.weblibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.skypro.lessons.springboot.weblibrary.pojo.EmployeeController;

@SpringBootApplication
public class WebLibraryApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebLibraryApplication.class, args);
    }


}
