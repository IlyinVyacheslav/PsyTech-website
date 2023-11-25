package ru.itmo.wp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("Client")
public class Client extends AbstractUser {
    private int age;
    private Subscription subscription;
    private String info;
    @Id
    private Long id;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long userId) {
        this.id = userId;
    }
}
