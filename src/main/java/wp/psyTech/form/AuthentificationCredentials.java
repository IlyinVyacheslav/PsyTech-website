package wp.psyTech.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AuthentificationCredentials {

    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
