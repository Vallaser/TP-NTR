package fr.uphf.service;

/**
 * 
 * OperationServiceProxy : Class qui impletement l'interface OperationService
 * Genere automatiquement par eclipse lorsque l'on
 * cree un Web Service Client a partir du fichier OperationService.wsdl
 * 
 * @author Quentin Colras
 */

public class OperationServiceProxy implements fr.uphf.service.OperationService {
  private String _endpoint = null;
  private fr.uphf.service.OperationService operationService = null;
  
  public OperationServiceProxy() {
    _initOperationServiceProxy();
  }
  
  public OperationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initOperationServiceProxy();
  }
  
  private void _initOperationServiceProxy() {
    try {
      operationService = (new fr.uphf.service.OperationServiceServiceLocator()).getOperationService();
      if (operationService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)operationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)operationService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (operationService != null)
      ((javax.xml.rpc.Stub)operationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uphf.service.OperationService getOperationService() {
    if (operationService == null)
      _initOperationServiceProxy();
    return operationService;
  }
  
  public java.lang.String postOperationForClient(java.lang.String emailClient, java.lang.String op, java.lang.String dateOp, java.lang.String type, float valueOp) throws java.rmi.RemoteException{
    if (operationService == null)
      _initOperationServiceProxy();
    return operationService.postOperationForClient(emailClient, op, dateOp, type, valueOp);
  }
  
  
}