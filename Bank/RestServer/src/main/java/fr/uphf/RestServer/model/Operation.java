package fr.uphf.RestServer.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * Operation : Classe du serveur Tomcat (Bank) 
 * Cette classe modele permet de representer une operation
 * 
 * @author Quentin Colras
 * @param id L'identifiant unique
 * @param op L'operateur + ou -
 * @param oldBalance Le solde du client avant d'avoir realiser l'operation courante
 * @param valueOp La valeur
 * @param dateOp La date
 * @param type Le type/description, exemple : Purchase Game
 * @param owner Le client a qui l'operation appartient
 */
@Entity
@Table(name = "operations")
@JacksonXmlRootElement(localName = "Operation")
public class Operation implements Serializable{
	
	private static final long serialVersionUID = 23L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
	@JacksonXmlProperty
	private Long id;
 
    @Column(name = "Op", nullable = false)
    @JacksonXmlProperty
    private char op;
    
    @Column(name = "OldBalance", nullable = false)
    @JacksonXmlProperty
    private Float oldBalance;
    
    @Column(name = "ValueOp", nullable = false)
    @JacksonXmlProperty
    private Float valueOp;
    
    @Column(name = "DateOp", nullable = false)
    @JacksonXmlProperty
    private String dateOp;
    
    @Column(name = "Type")
    @JacksonXmlProperty
    private String type;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Id_Client")
    private Client owner;
    
    /** Operation : Constructeur par default*/
    public Operation() {
    	super();
    }
    
    public Operation(CreateOperation operation) {
    	super();
    	this.op = operation.getOp();
		this.valueOp = operation.getValueOp();
		this.dateOp = operation.getDateOp();
		this.type = operation.getType();
    }

    /** Operation : Constructeur avec parametre*/
    public Operation(Long id, char op, Float oldBalance, Float valueOp, String DateOp, String type) {
		this.id = id;
		this.op = op;
		this.oldBalance = oldBalance;
		this.valueOp = valueOp;
		this.dateOp = DateOp;
		this.type = type;
	}
    
    /** Getter/Setter de la classe Operation*/
	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getOp() {
		return op;
	}

	public void setOp(char op) {
		this.op = op;
	}

	public Float getOldBalance() {
		return oldBalance;
	}

	public void setOldBalance(Float oldBalance) {
		this.oldBalance = oldBalance;
	}

	public Float getValueOp() {
		return valueOp;
	}

	public void setValueOp(Float valueOp) {
		this.valueOp = valueOp;
	}

	public String getDateOp() {
		return dateOp;
	}

	public void setDateOp(String dateOp) {
		this.dateOp = dateOp;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/** toString : Renvoie une chaine de caractere correspondant a l'image
	 * d'une operation*/
	@Override
    public String toString() {
        return "Operation{" + "id=" + id + ", op=" + this.op + ", oldBalance=" 
        		+ oldBalance + ", valueOp=" + valueOp + ", dateOp=" + dateOp + ", type=" + type +'}';
    }

	/** equals : Test l'egalite avec une autre operation*/
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
        final Operation other = (Operation) obj;
        if (!Objects.equals(this.op, other.op)) {
            return false;
        }
        if (!Objects.equals(this.oldBalance, other.oldBalance)) {
            return false;
        }
        if (!Objects.equals(this.valueOp, other.valueOp)) {
            return false;
        }
        if (!Objects.equals(this.dateOp, other.dateOp)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }
    
}
