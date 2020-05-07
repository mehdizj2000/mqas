package au.com.mqas.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.AccessLevel;

public interface AccessLevelRepo extends JpaRepository<AccessLevel, Long> {

}
