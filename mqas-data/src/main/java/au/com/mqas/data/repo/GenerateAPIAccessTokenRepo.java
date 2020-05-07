package au.com.mqas.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.GenerateAPIAccessToken;

public interface GenerateAPIAccessTokenRepo extends JpaRepository<GenerateAPIAccessToken, Long> {

	Optional<GenerateAPIAccessToken> findByToken(String token);

}
