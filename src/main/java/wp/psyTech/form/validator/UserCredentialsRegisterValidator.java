package wp.psyTech.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import wp.psyTech.form.UserCredentials;
import wp.psyTech.service.UserService;

@Component
public class UserCredentialsRegisterValidator implements Validator {
    private final UserService userService;

    public UserCredentialsRegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCredentials.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            UserCredentials userCredentials = (UserCredentials) target;
            if (!userService.isLoginVacant(userCredentials.getLogin())) {
                errors.rejectValue("login", "login-in-use", "Login is already in use" );
            }
        }
    }
}
