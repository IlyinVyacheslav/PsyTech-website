package ru.itmo.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.service.UserService;

@Component
public class UserCredentialsRegisterValidator implements Validator {
    private final UserService userService;

    public UserCredentialsRegisterValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> clazz) {
        return UserCredentials.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            UserCredentials userCredentials = (UserCredentials) target;
            if (!userCredentials.getPassword().equals(userCredentials.getPasswordConfirmation())) {
                errors.rejectValue("password", "password.is-different", "passwords must be equal");
            }
            if (!userService.isEmailVacant(userCredentials.getEmail())) {
                errors.rejectValue("email", "email.is-in-use", "email is in use already");
            }
        }
    }
}
