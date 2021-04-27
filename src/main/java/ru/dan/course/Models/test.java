package ru.dan.course.Models;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Data
public class test {
    @Column(name = "email")
    @NotEmpty(message = "email не может быть пустым")
    @Email(message = "Введите корректный email")
    private String email;
    @Column(name = "first_name")
    @NotEmpty(message = "Это поле не может быть пустым")
    private String firstname;
    @Column(name = "last_name")
    @NotEmpty(message = "Это поле не может быть пустым")
    private String lastname;
    @Column(name = "login")
    @NotEmpty(message = "Это поле не может быть пустым")
    private String login;
    @Column(name = "password")
    @NotEmpty(message = "Это поле не может быть пустым")
    @Size(min = 5, max = 50, message = "Минимальный размер должен составлять больше 5 символов")
    private String password;
    private String passwordReturn;
}
