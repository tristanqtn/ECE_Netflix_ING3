package Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Controleur.Controleur_General;

public class Main {

	public static void main(String[] args) {

		boolean reset_bdd = false;
		JFrame frame = new JFrame("FLOU-FLIX");

		frame.getContentPane().setForeground(new Color(64, 128, 128));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1150, 700);
		frame.setMinimumSize(new Dimension(1150, 700));
		frame.setResizable(false);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Controleur_General general = new Controleur_General(frame, reset_bdd);

		general.toString();
	}

}
