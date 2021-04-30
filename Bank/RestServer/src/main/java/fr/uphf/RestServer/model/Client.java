package fr.uphf.RestServer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * Client : Classe du serveur Tomcat (Bank) 
 * Cette classe modele permet de representer un client
 * 
 * @author Quentin Colras
 * @param id L'identifiant unique
 * @param firsName Le prenom
 * @param lastName Le nom
 * @param balance Le solde
 * @param email L'email
 * @param address L'adresse
 * @param operations La liste d'operations
 */
@Entity
@Table(name = "clients")
@JacksonXmlRootElement(localName = "Client")
public class Client implements Serializable{
	
	private static final long serialVersionUID = 25L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdClient", nullable = false)
	@JacksonXmlProperty
	private Long id;
	
	@Column(name = "FirstName", nullable = false)
	@JacksonXmlProperty
	private String firstName;
	
	@Column(name = "LastName", nullable = false)
	@JacksonXmlProperty
	private String lastName;
	
	@Column(name = "Balance", nullable = false)
	@JacksonXmlProperty
	private Float balance;
	
	@Column(name = "Email", nullable = true)
	@JacksonXmlProperty
	private String email;
	
	@OneToOne
	@JoinColumn(name="IdAddress", nullable = true)
	@JacksonXmlProperty
	
	private Address address;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	@JacksonXmlProperty
	@JsonManagedReference
	private List<Operation> operations = new ArrayList<Operation>();
	
	/** Client : Constructeur par default*/
	public Client() {
		super();
	}

	/** Client : Constructeur avec parametre*/
	public Client(Long id, String firstName, String lastName, Float balance, String email, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.email = email;
		this.address = address;
	}
	
	/** addOperation Fonction qui retourne true si c'est possible
	 * d'ajouter l'operation dans le client (soldeClient > 0 après l'opération)
	 * Si vrai, alors on set le owner de l'operation*/
	public Boolean addOperation(Operation operation)
	{
		if (this.balance < operation.getValueOp() && operation.getOp() == '-')
			return false;
		operation.setOldBalance(this.balance);
		if (operation.getOp() == '-')
			this.balance -= operation.getValueOp();
		else if (operation.getOp() == '+')
			this.balance += operation.getValueOp();
		operation.setOwner(this);
		return true;
	}

	/** Getter/Setter de la classe Client*/
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
		String sreturn= "Client{" + "id=" + id + ", firstName=" + firstName + ", lastName=" 
        		+ lastName + ", balance=" + balance + ", email=" + email
        		+ ", address=" + address.toString();
		for(Operation op: operations)
			sreturn += " " + op.toString();
        return sreturn + + '}';
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
        final Client other = (Client) obj;
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
