package ru.skypro.lessons.springboot.weblibrary.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class Position {

    // Идентификатор должности, генерируется автоматически
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Название должности
    private String name;

    public Position(){}

    public Position(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
