package wp.psyTech.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPage extends Page{
    @GetMapping({"", "/"})
    public String index(){
        return "IndexPage";
    }

    @GetMapping({"/logout"})
    public String logout(HttpSession httpSession){
        unsetUser(httpSession);
        setMessage(httpSession, "You logged out successfully");
        return "IndexPage";
    }
}
