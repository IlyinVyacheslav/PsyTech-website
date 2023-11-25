package ru.itmo.wp.form;

import ru.itmo.wp.form.validator.ValidAge;

import javax.validation.constraints.*;


public class PsychologistCredentials {
    @ValidAge
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
        System.out.println("FFFFFFFFFFFFFFFFFFFF");
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
