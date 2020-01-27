package au.com.mqas.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
