package Main;

import java.awt.Color;

import javax.swing.JFrame;

import Controleur.Controleur_General;

public class Main {

	public static void main(String[] args) {

		JFrame frame=new JFrame();
		frame.getContentPane().setForeground(new Color(64, 128, 128));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1150, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Controleur_General general=new Controleur_General(frame);
	}

}
