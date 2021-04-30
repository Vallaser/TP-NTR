package fr.uphf.RestClient.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Operation : Classe du client du serveur Tomcat (Bank) 
 * utilisée pour les services REST XML
 * Cette classe modele permet de representer une operation
 * 
 * @author Quentin Colras
 * @param id L'identifiant unique
 * @param op L'operateur + ou -
 * @param oldBalance Le solde du client avant d'avoir realiser l'operation courante
 * @param valueOp La valeur
 * @param dateOp La date
 * @param type Le type/description, exemple : Purchase Game
 */
@XmlRootElement(name = "Operation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Operation {
	
	private Long id;

    private char op;

    private Float oldBalance;

    private Float valueOp;

    private String dateOp;
    
    private String type;
    
    /** Operation : Constructeur par default*/
    public Operation() {
    	super();
    }

    /** Operation : Constructeur avec parametre*/
	public Operation(Long id, char op, Float oldBalance, Float valueOp, String dateOp, String type) {
		this.id = id;
		this.op = op;
		this.oldBalance = oldBalance;
		this.valueOp = valueOp;
		this.dateOp = dateOp;
		this.type = type;
	}

	/** Getter/Setter de la classe Operation*/
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
        		+ oldBalance + ", valueOp=" + valueOp + ", dateOp=" + dateOp + ", type=" + type + '}';
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
