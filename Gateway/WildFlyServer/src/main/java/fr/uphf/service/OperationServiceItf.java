package fr.uphf.service;

/**
 * 
 * OperationServiceItf : Interface du service OperationService
 * 
 * @author Quentin Colras
 */

public interface OperationServiceItf {

	public String postOperationForClient(String emailClient, String op, String dateOp, String type, Float valueOp);
}
