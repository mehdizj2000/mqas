package au.com.mqas.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.UserUpdateToken;

public interface UserUpdateTokenRepo extends JpaRepository<UserUpdateToken, Long> {

    Optional<UserUpdateToken> findByToken(String token);

}
