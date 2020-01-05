package au.com.mqas.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.domain.model.UserUpdateToken;

public interface UserUpdateTokenRepo extends JpaRepository<UserUpdateToken, Long> {

}
