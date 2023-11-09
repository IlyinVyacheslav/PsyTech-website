package wp.psyTech.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wp.psyTech.domain.User;
import wp.psyTech.form.UserCredentials;
import wp.psyTech.form.validator.UserCredentialsRegisterValidator;
import wp.psyTech.service.UserService;

@Controller
public class RegisterPage extends Page{

    private final UserService userService;
    private final UserCredentialsRegisterValidator userCredentialsRegisterValidator;

    public RegisterPage(UserService userService, UserCredentialsRegisterValidator userCredentialsRegisterValidator) {
        this.userService = userService;
        this.userCredentialsRegisterValidator = userCredentialsRegisterValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userCredentialsRegisterValidator);
    }

    @GetMapping({"/register"})
    public String registerGet(Model model){
        model.addAttribute("registerForm", new UserCredentials());
        return "RegisterPage";
    }

    @PostMapping({"/register"})
    public String registerPost(
            @Valid @ModelAttribute("registerForm") UserCredentials registerForm,
            BindingResult bindingResult,
            HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "RegisterPage";
        }
        User user = userService.register(registerForm);
        setUser(httpSession, user);
        setMessage(httpSession, "You have been registered successfully");
        return "redirect:/";
    }
}
