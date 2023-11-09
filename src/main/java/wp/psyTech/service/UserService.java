package wp.psyTech.service;

import org.springframework.stereotype.Service;
import wp.psyTech.domain.User;
import wp.psyTech.form.UserCredentials;
import wp.psyTech.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(UserCredentials registerForm) {
        User user = new User();
        user.setLogin(registerForm.getLogin());
        userRepository.save(user);
        userRepository.updatePassword(user.getId(), registerForm.getPassword());
        return user;
    }

    public boolean isLoginVacant(String login) {
        return userRepository.countByLogin(login) == 0;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User login(UserCredentials loginForm) {
        User user = userRepository.getUserByLoginAndPassword(loginForm.getLogin(), loginForm.getPassword());
        return user;
    }
}
