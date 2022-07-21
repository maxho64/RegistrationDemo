package com.example.registrationdemo.dto;

import com.example.registrationdemo.validation.EmailConstraint;
import com.example.registrationdemo.validation.FieldsValueMatch;
import com.example.registrationdemo.validation.PasswordConstraint;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Passwords do not match!"
        )
})
public class UserRegisterDto {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    @Size(min = 2, max = 30)
    private String login;
    @EmailConstraint
    private String email;
    @PasswordConstraint
    private String password;
    @PasswordConstraint
    private String repeatPassword;

    public UserRegisterDto() {
    }

    public UserRegisterDto(String name, String login, String email, String password, String repeatPassword) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
