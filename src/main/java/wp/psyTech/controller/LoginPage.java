package wp.psyTech.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wp.psyTech.domain.User;
import wp.psyTech.form.AuthentificationCredentials;
import wp.psyTech.service.UserService;

@Controller
public class LoginPage extends Page {
    private final UserService userService;

    public LoginPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/login"})
    public String loginGet(Model model) {
        model.addAttribute("loginForm", new AuthentificationCredentials());
        return "LoginPage";
    }


    @PostMapping({"/login"})
    public String loginPost(
            @Valid @ModelAttribute("loginForm") AuthentificationCredentials loginForm,
            BindingResult bindingResult,
            HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "LoginPage";
        }
        User user = userService.login(loginForm);
        setUser(httpSession, user);
        setMessage(httpSession, "You have logged in successfully");
        return "redirect:/";
    }
}
