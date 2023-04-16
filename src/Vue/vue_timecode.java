package Vue;

/**
 * @author Tristan Querton

 *
 * Cette vue est affichée lorsque l'utilisateur visionne un film / docu / episode
 * Elle permet de sauver le time code de visionnage et la note de l'utilisateur en BDD
 *
 */
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

import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextArea_arrondi;
import ElementsVisuels.JTextField_arrondi;
import Entite.ContenuCinematographique;

public class vue_timecode {

	private JTextField_arrondi time_code;
	private JTextField_arrondi note;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JRadioButton film_fini;
	private JTextArea_arrondi txtrTrisflix;
	private JButton_arrondi btn_rndSauvegarderLesRglages;
	private JButton_arrondi retour;
	private ContenuCinematographique contenu;

	// CONSTRUCTEUR - allocation des éléments visuels
	public vue_timecode(ContenuCinematographique contenu) {
		this.contenu = contenu;
		time_code = new JTextField_arrondi();
		note = new JTextField_arrondi();
		lblNewLabel = new JLabel("Time Code (mm:ss) : ");
		lblNewLabel_2 = new JLabel("Votre Note (/10) : ");
		film_fini = new JRadioButton("Film terminé");
		txtrTrisflix = new JTextArea_arrondi();
		btn_rndSauvegarderLesRglages = new JButton_arrondi();
		retour = new JButton_arrondi();
		configure();
	}
	
	public void configure() {//On configure les éléments

		time_code.setBackground(Color.BLACK);
		time_code.setForeground(Color.WHITE);
		time_code.setColumns(10);

		lblNewLabel.setForeground(Color.WHITE);

		lblNewLabel_2.setForeground(Color.WHITE);

		film_fini.setForeground(Color.WHITE);
		film_fini.setBackground(Color.BLACK);

		retour.setBackground(Color.BLACK);

		txtrTrisflix.setText(" FLOU-FLIX ");
		txtrTrisflix.setTabSize(20);
		txtrTrisflix.setForeground(Color.RED);
		txtrTrisflix.setFont(new Font("Dialog", Font.BOLD, 50));
		txtrTrisflix.setEditable(false);
		txtrTrisflix.setBackground(Color.BLACK);

		note.setBackground(Color.BLACK);
		note.setForeground(Color.WHITE);
		note.setColumns(10);

		retour.setBackground(Color.BLACK);

		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));
		retour.setBackground(new Color(0, 0, 0));

		btn_rndSauvegarderLesRglages.setText("Enregistrer");
		btn_rndSauvegarderLesRglages.setForeground(Color.WHITE);
		btn_rndSauvegarderLesRglages.setFont(new Font("Dialog", Font.PLAIN, 17));
		btn_rndSauvegarderLesRglages.setBackground(Color.RED);
	}

	// initialisation - placemement et configuration des éléments visuels
	public void initialize(JFrame frame) {

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(retour, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(431)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btn_rndSauvegarderLesRglages, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtrTrisflix, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))))
				.addContainerGap(412, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(473, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2))
						.addGap(38)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(note, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(time_code, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGap(443))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(529, Short.MAX_VALUE)
						.addComponent(film_fini).addGap(522)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(retour, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE).addGap(65)
				.addComponent(txtrTrisflix, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE).addGap(48)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						time_code, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(note, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
				.addGap(36).addComponent(film_fini).addGap(128)
				.addComponent(btn_rndSauvegarderLesRglages, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(131, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
		setListeners();
		repaint(frame);
	}

	// GETTERS
	public JButton_arrondi getRetour() {
		return retour;
	}

	public JTextField_arrondi get_note() {
		return this.note;
	}

	public JTextField_arrondi get_time_code() {
		return this.time_code;
	}

	public JButton_arrondi get_retour_catalogue() {
		return this.btn_rndSauvegarderLesRglages;
	}

	public JRadioButton get_film_fini() {
		return this.film_fini;
	}

	public ContenuCinematographique getContenu() {
		return this.contenu;
	}

	public int get_time_code_sec() {
		String split[] = get_time_code().getText().split(":");
		return (Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
	}

	// re-affichage des éléments graphiques
	public void repaint(JFrame frame) {
		this.retour.repaint();
		this.time_code.repaint();
		this.lblNewLabel.repaint();
		this.lblNewLabel_2.repaint();
		this.note.repaint();
		this.film_fini.repaint();
		this.btn_rndSauvegarderLesRglages.repaint();
		this.txtrTrisflix.repaint();

		frame.validate();
		frame.repaint();
	}

	// suppression des éléments visuels
	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.lblNewLabel_2);
		frame.getContentPane().remove(this.lblNewLabel);
		frame.getContentPane().remove(this.note);
		frame.getContentPane().remove(this.time_code);
		frame.getContentPane().remove(this.btn_rndSauvegarderLesRglages);
		frame.getContentPane().remove(this.film_fini);
		frame.getContentPane().remove(this.txtrTrisflix);

		repaint(frame);
	}

	// gestion des input
	public void setListeners() {
		this.film_fini.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (film_fini.isSelected()) {// si fin du film selection desactivation de l'entrée time code
					time_code.setEditable(false);
					time_code.setText("");
				} else {
					time_code.setEditable(true);
					time_code.setText("");
				}
			}

		});
	}

	// blindage de la note
	public boolean isNoteValid() {
		int noteInt;
		try {
			noteInt = Integer.parseInt(this.note.getText());
		} catch (Exception e) {
			return false;
		}
		if (noteInt < 0 || noteInt > 10) {
			return false;
		} else {
			return true;
		}
	}

	// blindage du time code
	public boolean isTimeCodeFormatValid() {
		if (this.time_code.getText().length() != 5) {
			return false;
		}
		char[] characters = this.time_code.getText().toCharArray();
		if (characters[0] > '9' || characters[0] < '0') {
			return false;
		}
		if (characters[1] > '9' || characters[1] < '0') {
			return false;
		}
		if (characters[3] > '9' || characters[3] < '0') {
			return false;
		}
		if (characters[4] > '9' || characters[4] < '0') {
			return false;
		}
		if (characters[2] != ':') {
			return false;
		}
		String minutes = "";
		minutes += characters[3];
		minutes += characters[4];
		int minutesInt;
		try {
			minutesInt = Integer.parseInt(minutes);
		} catch (Exception e) {
			return false;
		}
		if (minutesInt > 59 || minutesInt < 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isSauvegardable() {
		if (!film_fini.isSelected()) {
			return (isNoteValid() && isTimeCodeFormatValid());
		} else {
			return isNoteValid();
		}
	}
}