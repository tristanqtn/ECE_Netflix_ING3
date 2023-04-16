package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextField_arrondi;
import Entite.Membre;

/**
 * 
 * @author Clement BROT
 *
 *         Vue des paramètres d'un compte utilisateur et selection des
 *         sous-titres / qualité / reprise video
 *
 */

public class vue_page_compte {

	private JTextField_arrondi user_name;
	private JTextField textField_1;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblDsactiverLaReprises;
	private JLabel lblGrerLaQualit;
	private JButton_arrondi boutonEffacer;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JButton_arrondi btnNewButton_1_2;
	private JButton_arrondi btnNewButton_1_2_1;
	private JButton_arrondi btnNewButton_1_2_2;
	private JButton_arrondi btnNewButton_1_2_3;
	private JButton_arrondi btn_rndSauvegarderLesRglages;
	private JLabel lblNombreDeContenue;
	private JLabel lblNombreDeMinutes;
	private String qualite;
	private JButton_arrondi retour;
	private Membre membre;

	public vue_page_compte(Membre membre) {
		lblNewLabel = new JLabel("Activer les sous-titres");
		lblDsactiverLaReprises = new JLabel("Activer la reprise de vidéo");
		lblGrerLaQualit = new JLabel("Gérer la qualité");
		boutonEffacer = new JButton_arrondi("Effacer l'historique de visionnage");
		rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton_1 = new JRadioButton("");
		btnNewButton_1_2 = new JButton_arrondi("1080p");
		btnNewButton_1_2_1 = new JButton_arrondi("HD");
		btnNewButton_1_2_2 = new JButton_arrondi("360p");
		btnNewButton_1_2_3 = new JButton_arrondi("720p");
		btn_rndSauvegarderLesRglages = new JButton_arrondi("Sauvegarder les réglages");
		lblNombreDeContenue = new JLabel("Nombre de contenus visionnés");
		lblNombreDeMinutes = new JLabel("Nombre de minutes visionnées");
		textField_1 = new JTextField();
		textField = new JTextField();
		user_name = new JTextField_arrondi();
		qualite = "";
		retour = new JButton_arrondi();
		this.membre = membre;

		configure();
		setQualityListeners();
	}

	public void configure() {// on configure les éléments

		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		lblNewLabel.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.RED);

		lblDsactiverLaReprises.setForeground(Color.RED);
		lblDsactiverLaReprises.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 17));

		lblGrerLaQualit.setForeground(Color.RED);
		lblGrerLaQualit.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 17));

		boutonEffacer.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 17));
		boutonEffacer.setForeground(Color.WHITE);
		boutonEffacer.setBackground(Color.RED);

		rdbtnNewRadioButton.setBackground(Color.BLACK);
		rdbtnNewRadioButton.setForeground(Color.WHITE);

		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setBackground(Color.BLACK);

		btnNewButton_1_2.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setBackground(Color.RED);

		btnNewButton_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_2_1.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
		btnNewButton_1_2_1.setBackground(Color.RED);

		btnNewButton_1_2_2.setForeground(Color.WHITE);
		btnNewButton_1_2_2.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
		btnNewButton_1_2_2.setBackground(Color.RED);

		btnNewButton_1_2_3.setForeground(Color.WHITE);
		btnNewButton_1_2_3.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
		btnNewButton_1_2_3.setBackground(Color.RED);

		user_name.setEditable(false);
		user_name.setBackground(Color.BLACK);
		user_name.setForeground(Color.WHITE);
		user_name.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 20));
		user_name.setColumns(10);

		btn_rndSauvegarderLesRglages.setText("sauvegarder les réglages");
		btn_rndSauvegarderLesRglages.setForeground(Color.WHITE);
		btn_rndSauvegarderLesRglages.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 17));
		btn_rndSauvegarderLesRglages.setBackground(Color.RED);

		lblNombreDeContenue.setForeground(Color.RED);
		lblNombreDeContenue.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 17));

		lblNombreDeMinutes.setForeground(Color.RED);
		lblNombreDeMinutes.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 17));

		textField_1.setEditable(false);
		textField_1.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 15));
		textField_1.setColumns(10);

		textField.setEditable(false);
		textField.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 15));
		textField.setColumns(10);

		retour.setBackground(Color.BLACK);
		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));
		retour.setBackground(new Color(0, 0, 0));
	}

	private void afficher_donnee() {// on affiche les données de l'utilisateur
		this.user_name.setText("  " + this.membre.getPrenom() + " " + this.membre.getNom());
		this.textField.setText("" + this.membre.getNb_film_vu());
		this.textField_1.setText("" + (this.membre.getTemps_visionnage() / 60));

	}

	private void setQualityListeners() {// On ajoute les listeners sur les boutons qualité

		this.btnNewButton_1_2_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qualite = "360p";
			}
		});

		this.btnNewButton_1_2_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qualite = "720p";
			}
		});

		this.btnNewButton_1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qualite = "1080p";
			}
		});

		this.btnNewButton_1_2_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qualite = "HD";
			}
		});

	}

	public JButton_arrondi getEffacer() {
		return this.boutonEffacer;
	}

	public boolean getReprise() {
		return this.rdbtnNewRadioButton_1.isSelected();
	}

	public boolean getSousTitres() {
		return this.rdbtnNewRadioButton.isSelected();
	}

	public JButton_arrondi getSauvegarder() {
		return this.btn_rndSauvegarderLesRglages;
	}

	public String getQuality() {
		return this.qualite;
	}

	public JButton_arrondi getRetour() {
		return retour;
	}

	public void initialize(JFrame frame) {// On affiche les éléments

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(162, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblGrerLaQualit, GroupLayout.PREFERRED_SIZE, 187,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(boutonEffacer, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNombreDeContenue, GroupLayout.PREFERRED_SIZE, 368,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 228,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblDsactiverLaReprises, GroupLayout.PREFERRED_SIZE, 347,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNombreDeMinutes, GroupLayout.DEFAULT_SIZE, 356,
														Short.MAX_VALUE))
										.addGap(12))))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(73)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewButton_1_2_2, GroupLayout.PREFERRED_SIZE, 77,
												GroupLayout.PREFERRED_SIZE)
										.addGap(51)
										.addComponent(btnNewButton_1_2_3, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(40)
										.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(48).addComponent(btnNewButton_1_2_1, GroupLayout.PREFERRED_SIZE, 65,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(128).addComponent(
								btn_rndSauvegarderLesRglages, GroupLayout.PREFERRED_SIZE, 344,
								GroupLayout.PREFERRED_SIZE)))
				.addGap(105))
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(retour, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE).addGap(269)
						.addComponent(user_name, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(406, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(50)
						.addComponent(user_name, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE).addGap(68)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreDeContenue, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombreDeMinutes, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE))
						.addGap(34)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(rdbtnNewRadioButton)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDsactiverLaReprises, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton_1))
						.addGap(28)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1_2_2, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_2_3, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_2_1, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGrerLaQualit, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE))
						.addGap(85)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_rndSauvegarderLesRglages, GroupLayout.PREFERRED_SIZE, 43,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(boutonEffacer, GroupLayout.PREFERRED_SIZE, 43,
										GroupLayout.PREFERRED_SIZE)))
						.addComponent(retour, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(91, Short.MAX_VALUE)));

		frame.getContentPane().setLayout(groupLayout);
		afficher_donnee();
		repaint(frame);
	}

	public void delete(JFrame frame) {// On enlève les éléments de frame

		frame.getContentPane().remove(this.user_name);
		frame.getContentPane().remove(this.textField);
		frame.getContentPane().remove(this.textField_1);
		frame.getContentPane().remove(this.lblNewLabel);
		frame.getContentPane().remove(this.lblDsactiverLaReprises);
		frame.getContentPane().remove(this.lblGrerLaQualit);
		frame.getContentPane().remove(this.boutonEffacer);
		frame.getContentPane().remove(this.rdbtnNewRadioButton);
		frame.getContentPane().remove(this.rdbtnNewRadioButton_1);
		frame.getContentPane().remove(this.boutonEffacer);
		frame.getContentPane().remove(this.btnNewButton_1_2);
		frame.getContentPane().remove(this.btnNewButton_1_2_1);
		frame.getContentPane().remove(this.btnNewButton_1_2_2);
		frame.getContentPane().remove(this.btnNewButton_1_2_3);
		frame.getContentPane().remove(this.btn_rndSauvegarderLesRglages);
		frame.getContentPane().remove(this.lblNombreDeContenue);
		frame.getContentPane().remove(this.lblNombreDeMinutes);
		frame.getContentPane().remove(this.retour);

		repaint(frame);

	}

	public void repaint(JFrame frame) {// On rafraichit la frame

		this.user_name.repaint();
		this.textField.repaint();
		this.textField_1.repaint();
		this.lblNewLabel.repaint();
		this.lblDsactiverLaReprises.repaint();
		this.lblGrerLaQualit.repaint();
		this.boutonEffacer.repaint();
		this.rdbtnNewRadioButton.repaint();
		this.rdbtnNewRadioButton_1.repaint();
		this.boutonEffacer.repaint();
		this.btnNewButton_1_2.repaint();
		this.btnNewButton_1_2_1.repaint();
		this.btnNewButton_1_2_2.repaint();
		this.btnNewButton_1_2_3.repaint();
		this.btn_rndSauvegarderLesRglages.repaint();
		this.lblNombreDeContenue.repaint();
		this.lblNombreDeMinutes.repaint();
		this.retour.repaint();

		frame.validate();
		frame.repaint();

	}
}