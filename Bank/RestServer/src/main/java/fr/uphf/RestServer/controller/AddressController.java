package fr.uphf.RestServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.uphf.RestServer.model.Address;
import fr.uphf.RestServer.model.Addresses;
import fr.uphf.RestServer.service.ItfAddressService;
import fr.uphf.RestServer.service.ItfClientService;


/**
 * AddressController : Class qui met en libre acces selon des chemins d'acces, les methodes
 * du service AddressService pour le serveur Tomcat (Bank)
 * @author Quentin Colras
 * @param addressService Service des adresses
 * @parma clientService Service des clients
 *
 */
@RestController
@RequestMapping("/rest")
public class AddressController {
	
	@Autowired
	private ItfAddressService addressService;
	@Autowired
	private ItfClientService clientService;
	
	/** findAddresses Retourne la liste des adresses */
	@GetMapping(value="/addresses", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public Addresses findAddresses() {

        return addressService.findAll();
    }

	/** findAddress Retourne l'adresse ayant l'adressId */
    @GetMapping(value="/addresses/{addressId}", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public Address findAddress(@PathVariable Long addressId) {

        return addressService.findById(addressId);
    }
    
    /** getAddressWithParameters Retourne les adresses ayant un ou plusieurs parametres
     * parametre : City, Street, Country */
    @GetMapping(value="/address", produces= {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Addresses> getAddressWithParameters(@RequestParam(value="city", required = false) String city,
			@RequestParam(value="street", required = false) String street,
			@RequestParam(value="country", required = false) String country) {
    	Addresses addresses = fonctionTri(city, street, country);
		if (addresses.getAddresses().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Addresses>(addresses, HttpStatus.OK);
	}
    
    /** deleteAddress Supprime l'adresse ayant l'adressId */
    @DeleteMapping(value="/addresses/{addressId}", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> deleteAddress(@PathVariable Long addressId)
	{
    	Address address = addressService.findById(addressId);
    	if (address == null)
    		return new ResponseEntity<>("Unable to delete. Address with id " + addressId + " not found.",
					HttpStatus.NO_CONTENT);
    	if(!clientService.findAllByAddressId(address.getId()).getClients().isEmpty())
    		return new ResponseEntity<>("Unable to delete. Address with id " + addressId + " because of foreign constraint.",
				HttpStatus.NOT_FOUND);
    	addressService.deleteById(addressId);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    
    /** createAddress Ajoute une adresse*/
    @PostMapping(value="/addresses", consumes= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
    	Address currentAddress = addressService.findById(address.getId());
		if (currentAddress != null) {
			return new ResponseEntity<>("Unable to create. Address with id " + 
					address.getId() + " already exist.",HttpStatus.CONFLICT);
		}
		addressService.save(address);
		return new ResponseEntity<Address>(address, HttpStatus.CREATED);
	}
    
    /** updateAddress Modifie l'adresse */
    @PutMapping(value = "/addresses", consumes= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateAddress(@RequestBody Address address) {
    	Address currentAddress = addressService.findById(address.getId());

		if (currentAddress == null) {
			return new ResponseEntity<>("Unable to update. Address with id " + address.getId() + " not found.",
					HttpStatus.NOT_FOUND);
		}	
		addressService.save(address);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

    /** fonctionTri Fonction qui retourne la liste des adresses ayant les parametres
     * non null, fonction a part afin d'eviter d'avoir directement dans la methode 
     * RequestMapping beaucoup de if */
	private Addresses fonctionTri(String city, String street, String country)
	{
		Addresses addresses = null;
		if (city != null) {
			if (street != null)
			{
				if (country != null) {
					addresses = addressService.findAllByCityAndStreetAndCountry(city, street, country);
				}
				else addresses = addressService.findAllByCityAndStreet(city, street);
			}
			else if (country != null) {
				addresses = addressService.findAllByCityAndCountry(city, country);
			}
			else addresses = addressService.findAllByCity(city);
		}
		else if (street != null) {
			if (country != null) {
				addresses = addressService.findAllByStreetAndCountry(street, country);
			}
			else addresses = addressService.findAllByStreet(street);
		}
		else if (country != null) {
			addresses = addressService.findAllByCountry(country);
		}
		return addresses;
	}
}
