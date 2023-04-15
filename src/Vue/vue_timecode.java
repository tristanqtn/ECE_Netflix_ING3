package Vue;

/**
 * @author Tristan Querton
 *
 */
import java.awt.Color;
import java.awt.Font;

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

	/**
	 * Create the application.
	 */
	public vue_timecode(ContenuCinematographique contenu) {
		this.contenu = contenu;
		time_code = new JTextField_arrondi();
		note = new JTextField_arrondi();
		lblNewLabel = new JLabel("Time Code (min:sec) : ");
		lblNewLabel_2 = new JLabel("Votre Note (/10) : ");
		film_fini = new JRadioButton("Film terminé");
		txtrTrisflix = new JTextArea_arrondi();
		btn_rndSauvegarderLesRglages = new JButton_arrondi();
		retour = new JButton_arrondi();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(JFrame frame) {

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

	}

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

	public ContenuCinematographique getContenu() {
		return this.contenu;
	}
}