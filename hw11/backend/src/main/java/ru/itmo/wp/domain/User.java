package ru.itmo.wp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(indexes = {@Index(columnList = "creationTime"),
        @Index(columnList = "email", unique = true)})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User extends AbstractUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
//    private Set<Role> roles;
    @Column(nullable = false)
    private boolean admin = false;  // Добавлено новое поле с значением по умолчанию

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-z]+\\.[a-z]{2,}$", message = "Incorrect email address")
    private String email;

    @NotBlank
    @Size(min = 5, max = 30)
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\s]+$", message = "Name should contain only latin letters")
    private String name;

    @CreationTimestamp
    private Date creationTime;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OrderBy("creationTime desc")
    private List<Post> posts;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long userId) {
        this.id = userId;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        getPosts().add(post);
        post.setUser(this);
    }
}
