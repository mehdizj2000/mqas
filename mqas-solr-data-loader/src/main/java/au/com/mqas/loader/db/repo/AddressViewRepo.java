package au.com.mqas.loader.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.loader.db.domain.AddressInfo;

public interface AddressViewRepo extends JpaRepository<AddressInfo, String> {

}
