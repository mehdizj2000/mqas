package au.com.mqas.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Optional<Role> findByName(String name);

}
