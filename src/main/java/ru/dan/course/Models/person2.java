package ru.dan.course.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class person2 {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column (name = "role")
    @Enumerated (value = EnumType.STRING)
    private Role role;
    @Column (name = "status")
    @Enumerated (value = EnumType.STRING)
    private Status status;

}


