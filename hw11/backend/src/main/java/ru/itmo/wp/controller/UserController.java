package ru.itmo.wp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.itmo.wp.domain.Psychologist;
import ru.itmo.wp.domain.User;
import ru.itmo.wp.exception.ValidationException;
import ru.itmo.wp.form.PsychologistCredentials;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.form.validator.PsychologistCredentialsRegisterValidator;
import ru.itmo.wp.form.validator.UserCredentialsRegisterValidator;
import ru.itmo.wp.service.JwtService;
import ru.itmo.wp.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/1/users")
public class UserController {
    private final JwtService jwtService;

    private final UserService userService;

    private final UserCredentialsRegisterValidator registerValidator;

    private final PsychologistCredentialsRegisterValidator psychologistRegisterValidator;

    public UserController(JwtService jwtService, UserService userService, UserCredentialsRegisterValidator registerValidator, PsychologistCredentialsRegisterValidator psychologistRegisterValidator) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.registerValidator = registerValidator;
        this.psychologistRegisterValidator = psychologistRegisterValidator;
    }

    @InitBinder("userCredentials")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(registerValidator);
    }

    @InitBinder("psychologistCredentials")
    public void initPsychologistBinder(WebDataBinder binder) {
        binder.addValidators(psychologistRegisterValidator);
    }


    @GetMapping("auth")
    public User findUserByJwt(@RequestParam String jwt) {
        return jwtService.find(jwt);
    }

    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("psychologists")
    public List<Psychologist> findPsychologistsByAgeRangeAndExperience(
            @RequestParam int ageStart,
            @RequestParam int ageEnd,
            @RequestParam int experienceMin) {
        return userService.findAllPsychologistsByAgeRangeAndExperience(ageStart, ageEnd, experienceMin);
    }

    @PostMapping("register")
    public String register(@Valid @RequestBody UserCredentials userCredentials,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }

        return jwtService.create(userService.register(userCredentials));
    }

    @PostMapping("registerPsychologist")
    public String registerPsychologist(@RequestParam long userId,
                           @Valid @ModelAttribute("psychologistCredentials") PsychologistCredentials psychologistCredentials,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        User existingUser = userService.findById(userId);
        if (existingUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        return jwtService.create(userService.registerPsychologist(userId, psychologistCredentials));
    }

}
