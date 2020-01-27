package au.com.mqas.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByEmail(String email);

}
