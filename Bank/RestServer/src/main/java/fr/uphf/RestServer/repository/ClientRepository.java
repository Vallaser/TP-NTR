package fr.uphf.RestServer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.uphf.RestServer.model.Client;

/**
 * ClientRepository : Interface qui implemente la couche d'accès aux données clients
 * pour le serveur Tomcat (Bank)
 * @author Quentin Colras
 *
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	
	@Query(value = "SELECT * FROM Clients WHERE Clients.Id_address = :addressId", nativeQuery = true)
	Iterable<Client> findAllByAddressId(@Param("addressId") Long addressId);

	Optional<Client> findByEmail(String email);
}