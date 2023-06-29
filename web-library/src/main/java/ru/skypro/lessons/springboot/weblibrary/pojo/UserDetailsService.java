package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    UserDetails loadUserByUsername(String username);
}
