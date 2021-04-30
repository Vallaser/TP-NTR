package fr.uphf.RestServer.model;

public class CreateOperation {
	
	private char op;

    private Float valueOp;

    private String dateOp;
    
    private String type;
	
	private String emailClient;
	
	public CreateOperation() {
		super();
	}
	
	public CreateOperation(char op, Float valueOp, String dateOp, String type, String emailClient) {
		super();
		this.op = op;
		this.valueOp = valueOp;
		this.dateOp = dateOp;
		this.type = type;
		this.emailClient = emailClient;
	}

	public char getOp() {
		return op;
	}

	public void setOp(char op) {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	
}