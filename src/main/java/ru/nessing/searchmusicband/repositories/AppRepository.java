package ru.nessing.searchmusicband.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nessing.searchmusicband.entities.User;

@Repository
public interface AppRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findUserByNickname(String nickname);

    @Query(value = "SELECT users.id, email, password, nickname, name, city, type, search.searching, genre, description, states.state " +
            "FROM users " +
            "LEFT JOIN search ON users.searching = search.id " +
            "LEFT JOIN states ON users.state = states.id WHERE users.nickname = :nickname", nativeQuery = true)
    User getUserByNickname(@Param("nickname") String nickname);

}
