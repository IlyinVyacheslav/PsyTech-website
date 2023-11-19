package ru.itmo.wp.form;

import javax.validation.constraints.*;

public class PsychologistCredentials {
    @Min(value = 25, message = "Age must be at least 25")
    @Max(value = 100)
    @NotNull
    private int age;

    @NotNull
    @Max(value = 60)
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
