package ru.skypro.lessons.springboot.weblibrary.pojo;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
@Table(name = "auth_user")
public class AuthUser {

    // Создаем поле id для хранения идентификатора пользователя.
    @Id
    // Используем AUTO-генерацию идентификаторов.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Создаем поле username для хранения имени пользователя.
    // Устанавливаем ограничение на уникальность значения в колонке
    // и запрет на NULL.
    @Column(nullable = false, unique = true)
    private String username;

    // Создаем поле password для хранения пароля пользователя
    private String password;

    private Collection<GrantedAuthority> authority;

    // standard getters and setters

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthority() {
        return authority;
    }

    public void setAuthority(Collection<GrantedAuthority> authority) {
        this.authority = authority;
    }
}
