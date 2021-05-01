# NTR2021

## SITE E-COMMERCE

/e-commerce
Suivre les instructions du README.md présentes dans ce dossier.
Si un problème survient à cause de ESLint faire dans la console : npm remove @vue/cli-plugin-eslint

## CLIENT SOAP

/Gateway/WildflyClient

Si il y a un problème au niveau des librairies, alors importer les lib présent dans le dossier lib
Pour ce faire clique droit sur le projet => Properties => Java Build Path => Libraires => Add External Jars..

Pour lancer l'execution des test du client SOAP, executer en tant que java application la class MyOperationClient.java dans le dossier scr/main/java, package: fr.uphf.RestServer.test

## SERVER SOAP 

/Gateway/WildflyServer

Contract service (WSDL created automatically by Eclipse from class OperationService.java)

Pour le lancer le serveur, clique droit sur le projet => run as => Run on Server => Select Wildfly 23 (server)


## CLIENT REST

/Bank/RestClient

Pour lancer l'execution des test du client Rest, executer en tant que java application la class JUnitMain.java dans le dossier scr/main/java, package: fr.uphf.main


## SERVER REST

/Bank/RestServer

Pour lancer le serveur Rest, executer en tant que java application la class RestServerApplication.java dans le dossier scr/main/java, package: fr.uphf.RestServer

