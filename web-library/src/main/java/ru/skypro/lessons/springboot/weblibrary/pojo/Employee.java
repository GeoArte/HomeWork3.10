package ru.skypro.lessons.springboot.weblibrary.pojo;

public class Employee {
    private  int id;
    private String name;
    private int salary;

    private int idCreator = 1;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.id = idCreator;
        idCreator ++;
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
