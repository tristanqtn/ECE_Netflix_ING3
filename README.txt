********************************* PROJET FLOUFLIX *********************************
***********************************************************************************

Date : 16/04/2023
Professeur : Madame Palasi

Groupe : TD7 
Promotion : ING3

Numero de groupe : 

***********************************************************************************
********************************* AUTEURS *****************************************
***********************************************************************************
	
	- François BONNET
	- Clément BROT
	- Tristan QUERTON
	
***********************************************************************************
********************************* PRESENTATION ************************************
***********************************************************************************

Le but de ce projet est de développer une application de vidéo à la demande comme NETFLIX.

Notre application FLOUFLIX, répond aux attentes suivantes : 

	- connexion avec plusieurs comptes (administrateur / utilisateur)
	- visionnage de videos et de trailers
	- paramétrage des comptes utilisateurs (sous-titre / reprise des videos / qualite)
	- recherches par titres et genres
	- possibilité de note les films et sauver un visionnage en cours
	- pour administrateur : agir sur la BDD (afficher, recreer, supprimée) et generer des statistiques
	- l'utilisateur peut acceder à ses statistiques
	
	
***********************************************************************************
********************************* PRECAUTIONS *************************************
***********************************************************************************

Avant utlisation veuilliez à plusieurs choses : 

	- identifiants/mots de passe de l'instance locale MySQL (voir section TECHNOLOGIE)
	- la présence du dossier img dans le dossier bin (le dossier bin se regenere et donc supprimer parfois les images)

***********************************************************************************
********************************* TECHNOLOGIES ************************************
***********************************************************************************

Langage : JAVA
Environnement : SE17 / JDK17
Framework : JAVA SWING


Base de données : MySQL
Infomrations pour connexion réussi à l'instance locale MySQL : 

Pour assure le bon fonctionnment de l'application veillier à ce que le mot de passe de session de l'administateur (root) soit : "root"
Identifiant : root
Mot de passe : root
Une base de donnée dont les identifiants/mots de passes ne serait pas correcte bloquerai complement l'application.

***********************************************************************************
********************************* SOURCES *****************************************
***********************************************************************************

Plusieurs librairies open-source ont été utilsées dans le cadre de ce projet. 
L'utilisation des ces ressources a été autorisée par Mme Palasi. 

Sources : 	
	
	- Création de graphes avec SWING :
		https://stackoverflow.com/questions/29708147/custom-graph-java-swing
        Code rédigié par Camickr et libre d'utilisation
        Utilisé dans le cadre de présentation de graphes à l'adminnistrateur
        
    - Execution de scripts sql par une application JAVA : 
    	http://doc.sikuli.org/javadoc/org/sikuli/script/ScriptRunner.html
    	Code rédigé par Clinton Begin et libre de droits
    	Utilisé pour generer et remplir la base de données lors de la première execution 
    
    - Elements visuels amélioré
    	https://stackoverflow.com/questions/16373459/java-jscrollbar-design
    	https://stackoverflow.com/questions/8335997/how-can-i-add-a-space-in-between-two-buttons-in-a-boxlayout
    	https://www.tutorialspoint.com/how-to-left-align-components-vertically-using-boxlayout-with-java
    	https://www.digitalocean.com/community/tutorials/java-remove-character-string
   		Code rédigé par Philipp Danner et libre de droits