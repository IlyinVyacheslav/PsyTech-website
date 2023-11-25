package ru.itmo.wp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(indexes = {
        @Index(columnList = "diplomaNumber", unique = true)})
@DiscriminatorValue("Psychologist")
public class Psychologist extends AbstractUser {
    private int age;
    private int experience;
    @NotNull
    private long diplomaNumber;
    @Id
    private Long id;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public long getDiplomaNumber() {
        return diplomaNumber;
    }

    public void setDiplomaNumber(long diplomaNumber) {
        this.diplomaNumber = diplomaNumber;
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
