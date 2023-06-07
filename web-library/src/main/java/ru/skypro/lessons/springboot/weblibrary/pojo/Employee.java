package ru.skypro.lessons.springboot.weblibrary.pojo;

public class Employee {
    private  int id;
    private String name;
    private int salary;

    private int idCreator = 1;

    public Employee(String name, int salary) {
        this.id = idCreator;
        idCreator ++;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
