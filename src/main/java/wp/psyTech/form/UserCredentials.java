package wp.psyTech.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserCredentials {

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[a-zA-z0-9]+", message = "Only latin letters and numbers expected")
    private String login;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 64)
    private String password;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-z]+\\.[a-z]{2,}$", message = "Incorrect email address")
    private String email;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[+7|8][0-9]{10}", message = "Incorrect phone number")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
