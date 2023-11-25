package ru.itmo.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.form.PsychologistCredentials;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.service.UserService;

@Component
public class PsychologistCredentialsRegisterValidator implements Validator {
    private final UserService userService;

    public PsychologistCredentialsRegisterValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> clazz) {
        return PsychologistCredentials.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            PsychologistCredentials psychologistCredentials = (PsychologistCredentials) target;
            if (!userService.isDiplomaVacant(psychologistCredentials.getDiplomaNumber())) {
                errors.rejectValue("diplomaNumber", "diploma.is-in-use", "diploma is in use already");
            }
        }
    }
}
