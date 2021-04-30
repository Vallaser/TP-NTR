package fr.uphf.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * CreateOperation : Classe du serveur Wildfly (Gateway) 
 * utilisee pour les services SOAP
 * Cette classe modele permet de representer une operation a inserer
 * dans la liste d'operations d'un client
 * 
 * @author Quentin Colras
 * @param op L'operateur + ou -
 * @param valueOp La valeur
 * @param dateOp La date
 * @param type Le type/description, exemple : Purchase Game
 * @param emailClient L'email du client
 */
@XmlRootElement(name = "CreateOperation")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateOperation {
	
	private String op;

    private Float valueOp;

    private String dateOp;
    
    private String type;
	
	private String emailClient;

	
	public CreateOperation() {
		super();
	}
	
	public CreateOperation(String op, Float valueOp, String dateOp, String type, String emailClient) {
		super();
		this.op = op;
		this.valueOp = valueOp;
		this.dateOp = dateOp;
		this.type = type;
		this.emailClient = emailClient;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
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

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	@Override
    public String toString() {
        return "CreateOperation{ op=" + op + ", valueOp=" + valueOp + ", dateOp=" + 
        		dateOp + ", emailClient=" + emailClient + '}';
    }
	
}
