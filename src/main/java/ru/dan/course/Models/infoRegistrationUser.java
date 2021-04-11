package ru.dan.course.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class infoRegistrationUser {
    private String email;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String passwordReturn;
    public infoRegistrationUser checkClass(infoRegistrationUser check){
        if (check.getPassword().equals("") || check.getLogin().equals("") ||
            check.getFirstname().equals("") || check.getLastname().equals("") ||
            check.getEmail().equals("")){
            return null;
        }
        return check;
    }
}
