package wp.psyTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wp.psyTech.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "UPDATE user SET passwordSha=SHA1(CONCAT('1174f9d7bc21e00e9a5fd0a783a44c9a9f73413c', ?2)) WHERE id=?1", nativeQuery = true)
    void updatePassword(Long id, String password);

    long countByLogin(String login);

    @Query(value = "SELECT * FROM user WHERE login=?1 AND passwordSha=SHA1(CONCAT('1174f9d7bc21e00e9a5fd0a783a44c9a9f73413c', ?2))", nativeQuery = true)
    User getUserByLoginAndPassword(String login, String password);
}
