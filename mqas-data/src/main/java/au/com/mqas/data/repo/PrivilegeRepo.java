package au.com.mqas.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.Privilege;

public interface PrivilegeRepo extends JpaRepository<Privilege, Long> {

	Optional<Privilege> findByName(String name);

}
