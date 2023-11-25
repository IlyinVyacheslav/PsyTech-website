package ru.itmo.wp.form;

import javax.validation.constraints.*;

public class UserCredentials {

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-z]+\\.[a-z]{2,}$", message = "Incorrect email address")
    private String email;

//    @NotBlank
//    @Pattern(regexp = "[a-zA-Z\\s]{30}", message = "Name should contain only latin letters")
    private String name;

    @NotBlank
    @Size(min = 3, max = 60)
    private String password;

//    @NotBlank
//    @Size(min = 3, max = 60)
    private String passwordConfirmation;


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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
