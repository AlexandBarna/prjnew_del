package com.example.tstr1.security;

import com.example.tstr1.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class PersonDetails implements UserDetails {
    private final Person person;

    @Autowired
    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole())); // Возвращает лист из одного элемента
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getLogin();
    }

    // Аккаунт действителей
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Акаунт не заблокирован
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Пароль являеться действительным
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Аккаунт активен
    @Override
    public boolean isEnabled() {
        return true;
    }

    // Получить объект пользователя
    public Person getPerson() {
        return this.person;
    }
}
