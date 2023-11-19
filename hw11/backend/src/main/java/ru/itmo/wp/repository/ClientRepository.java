package ru.itmo.wp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmo.wp.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
