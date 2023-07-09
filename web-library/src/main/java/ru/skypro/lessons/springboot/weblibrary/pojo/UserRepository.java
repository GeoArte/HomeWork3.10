package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Создаем метод findByUsername
    // для поиска пользователя по имени пользователя
    User findByUsername(String username);
}

