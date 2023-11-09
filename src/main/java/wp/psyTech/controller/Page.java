package wp.psyTech.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import wp.psyTech.domain.User;
import wp.psyTech.service.UserService;

public class Page {
    private static final String USER_ID_SESSION_KEY = "userId";
    private static final String MESSAGE_SESSION_KEY = "messa";
    @Autowired
    private UserService userService;

    void setUser(HttpSession httpSession, User user) {
        httpSession.setAttribute(USER_ID_SESSION_KEY, user.getId());
    }

    void unsetUser(HttpSession httpSession) {
        httpSession.removeAttribute(USER_ID_SESSION_KEY);
    }

    @ModelAttribute("user")
    public User getUser(HttpSession httpSession) {
        Long id = (Long) httpSession.getAttribute(USER_ID_SESSION_KEY);
        return id == null ? null : userService.findById(id);
    }

    void setMessage(HttpSession httpSession, String message) {
        httpSession.setAttribute(MESSAGE_SESSION_KEY, message);
    }

    @ModelAttribute("message")
    public String getMessage(HttpSession httpSession) {
        String message = (String) httpSession.getAttribute(MESSAGE_SESSION_KEY);
        httpSession.removeAttribute(MESSAGE_SESSION_KEY);
        return message;
    }
}
