package fr.uphf.RestClient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * ClientJson : Classe du client du serveur Tomcat (Bank) 
 * utilisée pour les services REST JSON
 * Cette classe modele permet de representer un client
 * 
 * @author Quentin Colras
 * @param id L'identifiant unique
 * @param firsName Le prenom
 * @param lastName Le nom
 * @param balance Le solde
 * @param email L'email
 * @param address L'adresse
 */

@XmlRootElement(name = "clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientJson {

	private Long id;

	private String firstName;

	private String lastName;

	private Float balance;

	private String email;

	private Address address;

	private List<Operation> operations = new ArrayList<Operation>();
	
	/** ClientJson : Constructeur par default*/
	public ClientJson() {
		super();
	}

	/** ClientJson : Constructeur avec parametre*/
	public ClientJson(Long id, String firstName, String lastName, Float balance, String email, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.email = email;
		this.address = address;
	}

	/** Getter/Setter de la classe ClientJson*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	/** toString : Renvoie une chaine de caractere correspondant a l'image
	 * d'un client*/
	@Override
    public String toString() {
        return "ClientJson{" + "id=" + id + ", firstName=" + firstName + ", lastName=" 
        		+ lastName + ", balance=" + balance + ", email=" + email
        		+ ", address=" + address.toString() + '}';
    }

	/** equals : Test l'egalite avec un autre client*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientJson other = (ClientJson) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }
	
}
