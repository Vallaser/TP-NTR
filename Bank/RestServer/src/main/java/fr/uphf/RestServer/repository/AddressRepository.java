package fr.uphf.RestServer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.uphf.RestServer.model.Address;

/**
 * AddressRepository : Interface qui implemente la couche d'accès aux données adresses
 * pour le serveur Tomcat (Bank)
 * @author Quentin Colras
 *
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
	
	Iterable<Address> findAllByCity(String city);
	
	Iterable<Address> findAllByStreet(String street);
	
	Iterable<Address> findAllByCountry(String country);
	
	Iterable<Address> findAllByCityAndStreet(String city, String street);
	
	Iterable<Address> findAllByCityAndCountry(String city, String country);
	
	Iterable<Address> findAllByStreetAndCountry(String street, String country);
	
	Iterable<Address> findAllByCityAndStreetAndCountry(String city, String street, String country);

}