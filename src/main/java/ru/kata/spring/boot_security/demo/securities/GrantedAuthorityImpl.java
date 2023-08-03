package ru.kata.spring.boot_security.demo.securities;

import ru.kata.spring.boot_security.demo.models.Role;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {
    private final Role role;

    public GrantedAuthorityImpl(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}