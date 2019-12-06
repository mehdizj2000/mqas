package au.com.mqas.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.data.domain.VerificationToken;

public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long> {

}
