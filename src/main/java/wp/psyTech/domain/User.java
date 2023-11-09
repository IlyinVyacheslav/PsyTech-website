package wp.psyTech.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(indexes = {@Index(columnList = "creationTime"), @Index(columnList = "login", unique = true)})
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[a-zA-z0-9]+", message = "Only latin letters and numbers expected")
    private String login;

    @CreationTimestamp
    private Date creationTime;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
