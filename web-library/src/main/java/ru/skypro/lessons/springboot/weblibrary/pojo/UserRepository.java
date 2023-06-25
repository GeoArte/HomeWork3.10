package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<AuthUser, Long> {

    // Создаем метод findByUsername
    // для поиска пользователя по имени пользователя
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    AuthUser findByUsername(String username);
}
