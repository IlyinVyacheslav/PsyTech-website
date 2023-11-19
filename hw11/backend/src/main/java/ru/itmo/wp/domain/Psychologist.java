package ru.itmo.wp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(indexes = {
        @Index(columnList = "diplomaNumber", unique = true)})
@DiscriminatorValue("Psychologist")
public class Psychologist extends User {
    private int age;
    private int experience;
    @NotNull
    private long diplomaNumber;

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
}
