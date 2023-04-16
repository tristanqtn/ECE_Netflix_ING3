package Main;

/*
 * Sources : 	
	
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
 */
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Controleur.Controleur_General;

public class Main {

	public static void main(String[] args) {

		boolean reset_bdd = true; // garder à false
		JFrame frame = new JFrame("FLOU-FLIX"); // creation de la frame d'application

		// configurations
		frame.getContentPane().setForeground(new Color(64, 128, 128));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1150, 700);
		frame.setMinimumSize(new Dimension(1150, 700));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		@SuppressWarnings("unused")
		Controleur_General general = new Controleur_General(frame, reset_bdd); // lancement du controleur général
	}

}
