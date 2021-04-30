/**
 * OperationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uphf.service;

/**
 * 
 * OperationService : Interface 
 * Genere automatiquement par eclipse lorsque l'on
 * cree un Web Service Client a partir du fichier OperationService.wsdl
 * 
 * @author Quentin Colras
 */

public interface OperationService extends java.rmi.Remote {
    public java.lang.String postOperationForClient(java.lang.String emailClient, java.lang.String op, java.lang.String dateOp, java.lang.String type, float valueOp) throws java.rmi.RemoteException;
}
