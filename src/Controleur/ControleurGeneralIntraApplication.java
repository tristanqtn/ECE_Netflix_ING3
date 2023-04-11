/**
 * 
 */
package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import Vue.Vue_home_page;
import Vue.vue_previsualisation_2;

/**
 * @author Francois BONNET
 * 
 * 
 *
 */
public class ControleurGeneralIntraApplication {

	private vue_previsualisation_2 informations;
	private Vue_home_page pageDAcceuil;
	private JFrame frame;

	public ControleurGeneralIntraApplication(JFrame frame) {
		this.setFrame(frame);
		pageDAcceuil = new Vue_home_page();
		pageDAcceuil.initialize(frame);
		setPageDAcceuilListeners(frame);
	}

	private void setPageDAcceuilListeners(JFrame frame) {
		pageDAcceuil.getCompte().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Compte");

			}

		});

		pageDAcceuil.getAction().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action");

			}

		});

		pageDAcceuil.getThriller().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("thriller");

			}

		});

		pageDAcceuil.getDocumentaire().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Documentaire");

			}

		});

		pageDAcceuil.getAmour().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Amour");

			}

		});

		pageDAcceuil.getComedie().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Comédie");

			}

		});

		ArrayList<ArrayList<JButton>> liste = pageDAcceuil.getFilms();
		for (int j = 0; j < liste.size(); j++) {
			for (int i = 0; i < liste.get(j).size(); i++) {
				liste.get(j).get(i).addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Film");
						informations = new vue_previsualisation_2();
						pageDAcceuil.delete(frame);
						informations.initialize(frame);
						setPrevisualisationListeners(frame);
					}

				});
			}
		}
	}

	private void setPrevisualisationListeners(JFrame frame) {
		informations.getVisionner().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Visionner");

			}

		});

		informations.getTrailer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Trailer");

			}

		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
