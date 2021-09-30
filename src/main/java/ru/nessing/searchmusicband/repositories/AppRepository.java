package ru.nessing.searchmusicband.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.searchmusicband.entities.User;

@Repository
public interface AppRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
