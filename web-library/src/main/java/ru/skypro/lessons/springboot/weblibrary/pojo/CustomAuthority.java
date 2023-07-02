package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.security.core.GrantedAuthority;

public class CustomAuthority implements GrantedAuthority {
    private String authority;

    public CustomAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof CustomAuthority) {
            return authority.equals(((CustomAuthority) obj).authority);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return authority.hashCode();
    }
}
