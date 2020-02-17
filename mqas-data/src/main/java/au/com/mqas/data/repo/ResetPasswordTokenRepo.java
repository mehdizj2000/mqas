package au.com.mqas.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.ResetPasswordToken;
import au.com.mqas.db.data.model.VerificationToken;

public interface ResetPasswordTokenRepo extends JpaRepository<ResetPasswordToken, Long> {
    
    Optional<ResetPasswordToken> findByToken(String token);

}
