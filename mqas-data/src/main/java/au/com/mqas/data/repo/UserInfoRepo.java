package au.com.mqas.data.repo;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByEmail(String email);
    
    Optional<UserInfo> findByEmailAndDateOfBirth(String email, LocalDate dateOfBirth);
    
    Optional<UserInfo> findByIdAndEmailAndSecurityAnswer(Long id, String email, String secAnswer);

}
