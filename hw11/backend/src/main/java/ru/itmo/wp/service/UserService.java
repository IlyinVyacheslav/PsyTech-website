package ru.itmo.wp.service;

import org.springframework.stereotype.Service;
import ru.itmo.wp.domain.*;
import ru.itmo.wp.form.PsychologistCredentials;
import ru.itmo.wp.form.UserCredentials;
import ru.itmo.wp.repository.ClientRepository;
import ru.itmo.wp.repository.PsychologistRepository;
import ru.itmo.wp.repository.RoleRepository;
import ru.itmo.wp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PsychologistRepository psychologistRepository;
    private final ClientRepository clientRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository, PsychologistRepository psychologistRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.psychologistRepository = psychologistRepository;
        this.clientRepository = clientRepository;
//        prepareRoles();
    }

//    private void prepareRoles() {
//        for (Role.Name name : Role.Name.values()) {
//            if (!roleRepository.existsByName(name)) {
//                Role role = new Role();
//                role.setName(name);
//                roleRepository.save(role);
//            }
//        }
//    }

    public User findByEmailAndPassword(String email, String password) {
        return email == null || password == null ? null : userRepository.findByEmailAndPassword(email, password);
    }

    public User findById(Long id) {
        return id == null ? null : userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    }

    public boolean isEmailVacant(String email) {
        return userRepository.countByEmail(email) == 0;
    }

    public boolean isDiplomaVacant(long diplomaNumber) {
        return psychologistRepository.countByDiplomaNumber(diplomaNumber) == 0;
    }

    public List<Psychologist> findAllPsychologistsByAgeRangeAndExperience(int ageStart, int ageEnd, int experienceMin) {
        return psychologistRepository.findPsychologistByAgeBetweenAndExperienceGreaterThan(ageStart, ageEnd, experienceMin);
    }
    public Psychologist getPsychologistInfo(User user) {
        return psychologistRepository.findById(user.getId()).orElse(null);
    }

    public Psychologist registerPsychologist(long userId, PsychologistCredentials psychologistCredentials) {
        Psychologist psychologist = new Psychologist();
        psychologist.setId(userId);
        psychologist.setAge(psychologistCredentials.getAge());
        psychologist.setExperience(psychologistCredentials.getExperience());
        psychologist.setDiplomaNumber(psychologistCredentials.getDiplomaNumber());
        psychologistRepository.save(psychologist);

        return psychologist;
    }

    public User register(UserCredentials userCredentials) {
        User user = new User();
        user.setEmail(userCredentials.getEmail().trim());
        user.setName(userCredentials.getName().trim());
        userRepository.save(user);
        userRepository.updatePasswordSha(user.getId(), userCredentials.getEmail(), userCredentials.getPassword());
        return user;
    }

    public void writePost(Post post, User user) {
        user.addPost(post);
        userRepository.save(user);
    }
}
