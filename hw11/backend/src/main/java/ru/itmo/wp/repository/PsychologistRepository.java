package ru.itmo.wp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.wp.domain.Psychologist;

import java.util.List;

public interface PsychologistRepository extends JpaRepository<Psychologist, Long> {
    List<Psychologist> findPsychologistByAgeBetweenAndExperienceGreaterThan(int ageStart, int ageEnd, int experienceMin);
    int countByDiplomaNumber(long diplomaNumber);
}
