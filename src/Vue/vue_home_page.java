package Vue;

/*import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controleur.Controleur_Modele;
import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextArea_arrondi;
import Entite.ContenuCinematographique;
import Entite.Documentaire;
import Entite.Episode;
import Entite.Film;
import Entite.Membre;
import Entite.Visionnage;

public class Vue_home_page {

	private JTextArea_arrondi txtrTrisflix;
	private JButton_arrondi boutonCompte;
	private JButton_arrondi boutonAction;
	private JButton_arrondi boutonThriller;
	private JButton_arrondi boutonAmour;
	private JButton_arrondi boutonComedie;
	private JButton_arrondi boutonDocumentaire;
	private ArrayList<ArrayList<ContenuCinematographique>> contenus;
	private ArrayList<String> categories;
	private ArrayList<ArrayList<JButton_arrondi>> recomendations;
	private ArrayList<JPanel> panels;
	private JLabel label_2;
	private JLabel label_1;
	private JButton_arrondi boutonRecherche;
	private JButton_arrondi retour;
	private Controleur_Modele modele;
	private Membre user;

	public Vue_home_page(Membre user) {
		this.user=user;

		modele = new Controleur_Modele("root", "root", false);
		txtrTrisflix = new JTextArea_arrondi();
		boutonCompte = new JButton_arrondi("");
		boutonAction = new JButton_arrondi("ACTION");
		boutonThriller = new JButton_arrondi("THRILLER");
		boutonAmour = new JButton_arrondi("AMOUR");
		boutonComedie = new JButton_arrondi("COMEDIE");
		boutonDocumentaire = new JButton_arrondi("DOCUMENTAIRE");
		label_1 = new JLabel("Recommendations");
		label_2 = new JLabel("Recommendations");
		boutonRecherche = new JButton_arrondi("Recherche");

		retour = new JButton_arrondi();

		recomendations = new ArrayList<ArrayList<JButton_arrondi>>();
		contenus = new ArrayList<ArrayList<ContenuCinematographique>>();
		categories = new ArrayList<String>();

	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame("FLOU-FLIX");

					ArrayList<String> prefe = new ArrayList<String>();
					prefe.add("Dessins animes");
					prefe.add("Combat");
					prefe.add("Japon");

					// ne sauvera jamais un nouvel admin

					frame.getContentPane().setForeground(new Color(64, 128, 128));
					frame.getContentPane().setBackground(new Color(0, 0, 0));
					frame.setBounds(100, 100, 1150, 700);
					frame.setMinimumSize(new Dimension(1150, 700));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Membre user = new Membre(1, "Denson", "Sarujan", "sarujan@gmail.com", 1123456789,
							"1234567891234567", prefe, "saruLEbg!", true, 2383, 30);
					Vue_home_page vue = new Vue_home_page(user);

					vue.initialize(frame);
					frame.setVisible(true);
					Vector<ContenuCinematographique> en_cours = vue.findFilms(user);
					System.out.println(en_cours.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ArrayList<ArrayList<ContenuCinematographique>> getRecomendations() {
		return contenus;
	}

	public ContenuCinematographique getRecomendation(int j, int i) {
		return contenus.get(j).get(i);
	}
	
	public void setRecomandations() {
		int listeSize = 2;
		ArrayList<JButton_arrondi> liste;
		ArrayList<ContenuCinematographique> listeContenus;
		Vector<ContenuCinematographique> vu = findFilms(user);

		ArrayList<Integer> listesSizes = new ArrayList<Integer>();
		listesSizes.add(vu.size());
		listesSizes.add(5);

		for (int j = 0; j < listeSize; j++) {
			liste = new ArrayList<JButton_arrondi>();
			listeContenus = new ArrayList<ContenuCinematographique>();
			categories.add("Films");
			if(j==0) {
				for (int i = 0; i < listesSizes.get(j); i++) {
					liste.add(new JButton_arrondi(""));
					listeContenus.add(vu.get(i));
					System.out.println(vu.get(i).getAffiche());
					liste.get(i).setIcon(new ImageIcon(vu.get(i).getAffiche()));
				}
			}else {
				for (int i = 0; i < listesSizes.get(j); i++) {
					liste.add(new JButton_arrondi(""));
					listeContenus.add(modele.getFilms().get(i));
					System.out.println(modele.getFilms().get(i).getAffiche());
					liste.get(i).setIcon(new ImageIcon(modele.getFilms().get(i).getAffiche()));
				}
			}
			
			recomendations.add(liste);
			contenus.add(listeContenus);
		}

		panels = new ArrayList<JPanel>();
		for (int j = 0; j < listeSize; j++) {
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(Color.BLACK);
			panels.add(panel);
		}
	}

	public Vector<ContenuCinematographique> findFilms(Membre user) {// On va déterminer ici les films contenus dans les
																	// JPanels et les noms de
		// catégories proposées
		Vector<Visionnage> visio = modele.getVisionnages();
		Vector<Documentaire> docu = modele.getDocumentaires();
		Vector<Film> films = modele.getFilms();
		Vector<Episode> episodes = modele.getEpisodes();

		Vector<ContenuCinematographique> en_cours = new Vector<ContenuCinematographique>();
		for (int i = 0; i < visio.size(); i++) {
			if (visio.get(i).getID_membre() == user.getID() && visio.get(i).getTime_code() > 0) {
				if (visio.get(i).getID_documentaire() != 0) {
					for (int j = 0; j < docu.size(); j++) {
						if (docu.get(j).getID() == visio.get(i).getID_documentaire()) {
							en_cours.add(docu.get(j));
						}
					}
				}
				if (visio.get(i).getID_film() != 0) {
					for (int j = 0; j < films.size(); j++) {
						if (films.get(j).getID() == visio.get(i).getID_film()) {
							en_cours.add(films.get(j));
						}
					}
				}
				if (visio.get(i).getID_episode() != 0 && visio.get(i).getID_saison() != 0
						&& visio.get(i).getID_serie() != 0) {
					for (int j = 0; j < episodes.size(); j++) {
						if (episodes.get(j).getID() == visio.get(i).getID_episode()
								&& episodes.get(j).getID_saison() == visio.get(i).getID_saison()
								&& episodes.get(j).getID_serie() == visio.get(i).getID_serie()) {
							en_cours.add(episodes.get(j));
						}
					}
				}
			}
		}
		return en_cours;

	}

	public JButton_arrondi getCompte() {
		return this.boutonCompte;
	}

	public JButton_arrondi getAction() {
		return this.boutonAction;
	}

	public JButton_arrondi getThriller() {
		return this.boutonThriller;
	}

	public JButton_arrondi getAmour() {
		return this.boutonAmour;
	}

	public JButton_arrondi getComedie() {
		return this.boutonComedie;
	}

	public JButton_arrondi getDocumentaire() {
		return this.boutonDocumentaire;
	}

	public ArrayList<ArrayList<JButton_arrondi>> getFilms() {
		return this.recomendations;
	}

	public JButton getRetour() {
		return retour;
	}

	public JButton_arrondi getRecherche() {
		return boutonRecherche;
	}

	
	public void initialize(JFrame frame) {

		
		setRecomandations();

		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath());
		retour.setIcon(icon);
		retour.setBackground(new Color(0, 0, 0));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap(188, Short.MAX_VALUE)
								.addComponent(panels.get(1), GroupLayout.PREFERRED_SIZE, 1116,
										GroupLayout.PREFERRED_SIZE)
								.addGap(161))
						.addGroup(groupLayout.createSequentialGroup().addGap(43).addComponent(label_2)
								.addContainerGap(1016, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(44)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(1015, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING).addComponent(retour)
												.addGroup(groupLayout.createSequentialGroup().addGap(101)
														.addComponent(boutonAction).addGap(90)
														.addComponent(boutonThriller, GroupLayout.PREFERRED_SIZE, 110,
																GroupLayout.PREFERRED_SIZE)
														.addGap(108)
														.addComponent(boutonAmour, GroupLayout.PREFERRED_SIZE, 83,
																GroupLayout.PREFERRED_SIZE)
														.addGap(117)
														.addComponent(boutonComedie, GroupLayout.PREFERRED_SIZE, 103,
																GroupLayout.PREFERRED_SIZE)
														.addGap(82).addComponent(boutonDocumentaire,
																GroupLayout.PREFERRED_SIZE, 167,
																GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap(419, Short.MAX_VALUE)
												.addComponent(txtrTrisflix, GroupLayout.PREFERRED_SIZE, 285,
														GroupLayout.PREFERRED_SIZE)
												.addGap(33).addComponent(boutonRecherche).addGap(237)))
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(boutonCompte))
								.addGroup(Alignment.LEADING,
										groupLayout.createSequentialGroup().addGap(20).addComponent(panels.get(0),
												GroupLayout.PREFERRED_SIZE, 1116, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
						groupLayout
								.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(retour)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(txtrTrisflix, GroupLayout.PREFERRED_SIZE, 67,
														GroupLayout.PREFERRED_SIZE)
												.addGap(36))
										.addGroup(groupLayout.createSequentialGroup().addGap(49)
												.addComponent(boutonRecherche)
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(boutonAction).addComponent(boutonThriller,
														GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(boutonComedie, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(boutonDocumentaire, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(boutonAmour, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))
								.addGap(15).addComponent(label_1))
						.addComponent(boutonCompte))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(panels.get(0), GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(34).addComponent(panels.get(1),
								GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(label_2)))
				.addGap(109)));
		frame.getContentPane().setLayout(groupLayout);
		for (int j = 0; j < panels.size(); j++) {
			panels.get(j).setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}

		txtrTrisflix.setTabSize(20);
		txtrTrisflix.setForeground(Color.RED);
		this.txtrTrisflix.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD, 50));
		this.txtrTrisflix.setTabSize(20);
		this.txtrTrisflix.setText(" FLOU-FLIX ");
		txtrTrisflix.setEditable(false);
		txtrTrisflix.setBackground(Color.BLACK);
		GridBagConstraints gbc_txtrTrisflix = new GridBagConstraints();
		gbc_txtrTrisflix.gridheight = 2;
		gbc_txtrTrisflix.gridwidth = 5;
		gbc_txtrTrisflix.insets = new Insets(0, 0, 5, 5);
		gbc_txtrTrisflix.fill = GridBagConstraints.VERTICAL;
		gbc_txtrTrisflix.gridx = 9;
		gbc_txtrTrisflix.gridy = 3;
		frame.getContentPane().add(txtrTrisflix, gbc_txtrTrisflix);

		retour.setBackground(new Color(0, 0, 0));

		boutonCompte.setBackground(Color.DARK_GRAY);
		boutonCompte.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/profil.png").getPath()));

		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridheight = 2;
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 20;
		gbc_btnNewButton_4.gridy = 3;
		frame.getContentPane().add(boutonCompte, gbc_btnNewButton_4);

		boutonAction.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
		boutonAction.setForeground(Color.WHITE);
		boutonAction.setBackground(Color.RED);
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.gridwidth = 2;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 3;
		gbc_btnNewButton_5.gridy = 5;
		frame.getContentPane().add(boutonAction, gbc_btnNewButton_5);

		boutonThriller.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
		boutonThriller.setForeground(Color.WHITE);
		boutonThriller.setBackground(Color.RED);
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.gridwidth = 4;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 6;
		gbc_btnNewButton_6.gridy = 5;
		frame.getContentPane().add(boutonThriller, gbc_btnNewButton_6);

		boutonAmour.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
		boutonAmour.setForeground(Color.WHITE);
		boutonAmour.setBackground(Color.RED);
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.gridwidth = 2;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 11;
		gbc_btnNewButton_7.gridy = 5;
		frame.getContentPane().add(boutonAmour, gbc_btnNewButton_7);

		boutonComedie.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
		boutonComedie.setForeground(Color.WHITE);
		boutonComedie.setBackground(Color.RED);
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.gridwidth = 4;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 13;
		gbc_btnNewButton_8.gridy = 5;
		frame.getContentPane().add(boutonComedie, gbc_btnNewButton_8);

		boutonDocumentaire.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));

		boutonDocumentaire.setForeground(Color.WHITE);
		boutonDocumentaire.setBackground(Color.RED);
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.gridwidth = 3;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_9.gridx = 17;
		gbc_btnNewButton_9.gridy = 5;
		frame.getContentPane().add(boutonDocumentaire, gbc_btnNewButton_9);

		label_2.setForeground(Color.WHITE);

		label_1.setForeground(Color.WHITE);

		boutonRecherche.setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 14));
		boutonRecherche.setForeground(Color.WHITE);
		boutonRecherche.setBackground(Color.RED);

		for (int j = 0; j < recomendations.size(); j++) {
			for (int i = 0; i < recomendations.get(j).size(); i++) {
				recomendations.get(j).get(i).setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
				recomendations.get(j).get(i).setBackground(Color.BLACK);
				panels.get(j).add(recomendations.get(j).get(i));
			}
		}

		frame.getContentPane().setLayout(groupLayout);

		repaint(frame);

	}

	public void delete(JFrame frame) {

		frame.getContentPane().remove(this.txtrTrisflix);
		frame.getContentPane().remove(this.boutonCompte);
		frame.getContentPane().remove(this.boutonAction);
		frame.getContentPane().remove(this.boutonThriller);
		frame.getContentPane().remove(this.boutonAmour);
		frame.getContentPane().remove(this.boutonComedie);
		frame.getContentPane().remove(this.boutonDocumentaire);
		for (int j = 0; j < panels.size(); j++) {
			frame.getContentPane().remove(this.panels.get(j));
		}
		frame.getContentPane().remove(this.boutonRecherche);
		frame.getContentPane().remove(this.label_1);
		frame.getContentPane().remove(this.label_2);
		frame.getContentPane().remove(this.retour);

		repaint(frame);
	}

	public void repaint(JFrame frame) {
		this.txtrTrisflix.repaint();
		this.boutonCompte.repaint();
		this.boutonAction.repaint();
		this.boutonThriller.repaint();
		this.boutonAmour.repaint();
		this.boutonComedie.repaint();
		this.boutonDocumentaire.repaint();
		for (int j = 0; j < panels.size(); j++) {
			this.panels.get(j).repaint();
		}
		this.boutonRecherche.repaint();
		this.label_1.repaint();
		this.label_2.repaint();
		this.retour.repaint();

		frame.validate();
		frame.repaint();
	}

}*/

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Controleur.Controleur_Modele;
import ElementsVisuels.JButton_arrondi;
import ElementsVisuels.JTextArea_arrondi;
import Entite.ContenuCinematographique;
import Entite.Documentaire;
import Entite.Episode;
import Entite.Film;
import Entite.Membre;
import Entite.Visionnage;

public class vue_home_page {

	private JButton_arrondi recherche;
	private JLabel labelRecommendations;
	private JLabel lblEnCours;
	private JButton_arrondi retour;
	private JButton_arrondi compte;
	private ArrayList<ArrayList<ContenuCinematographique>> contenus;
	private ArrayList<String> categories;
	private ArrayList<ArrayList<JButton_arrondi>> recomendations;
	private ArrayList<JPanel> panels;
	private JTextArea_arrondi titre;

	private Controleur_Modele modele;
	private Membre user;

	/**
	 * Create the application.
	 */
	public vue_home_page(Membre user) {
		this.user = user;
		modele = new Controleur_Modele("root", "root", false);

		recherche = new JButton_arrondi("Recherche");
		recherche.setBackground(Color.RED);
		recherche.setForeground(Color.WHITE);
		labelRecommendations = new JLabel("Recommendations");
		retour = new JButton_arrondi("New button");
		retour.setText("");

		lblEnCours = new JLabel("En cours");
		compte = new JButton_arrondi("");
		recomendations = new ArrayList<ArrayList<JButton_arrondi>>();
		contenus = new ArrayList<ArrayList<ContenuCinematographique>>();
		categories = new ArrayList<String>();
		panels = new ArrayList<JPanel>();
		titre = new JTextArea_arrondi();

	}

	public void setRecomandations() {
		int listeSize = 2;
		ArrayList<JButton_arrondi> liste;
		ArrayList<ContenuCinematographique> listeContenus;
		Vector<ContenuCinematographique> vu = findFilms(user);

		ArrayList<Integer> listesSizes = new ArrayList<Integer>();
		listesSizes.add(vu.size());
		listesSizes.add(5);

		for (int j = 0; j < listeSize; j++) {
			liste = new ArrayList<JButton_arrondi>();
			listeContenus = new ArrayList<ContenuCinematographique>();
			categories.add("Films");
			if (j == 0) {
				for (int i = 0; i < listesSizes.get(j); i++) {
					liste.add(new JButton_arrondi(""));
					listeContenus.add(vu.get(i));
					System.out.println(vu.get(i).getAffiche());
					liste.get(i).setIcon(new ImageIcon(vu.get(i).getAffiche()));
				}
			} else {
				for (int i = 0; i < listesSizes.get(j); i++) {
					liste.add(new JButton_arrondi(""));
					listeContenus.add(modele.getFilms().get(i));
					System.out.println(modele.getFilms().get(i).getAffiche());
					liste.get(i).setIcon(new ImageIcon(modele.getFilms().get(i).getAffiche()));
				}
			}
			recomendations.add(liste);
			contenus.add(listeContenus);
		}

		panels = new ArrayList<JPanel>();
		for (int j = 0; j < listeSize; j++) {
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(Color.BLACK);
			panels.add(panel);
		}
	}

	public Vector<ContenuCinematographique> findFilms(Membre user) {// On va déterminer ici les films contenus dans les
																	// JPanels et les noms de
		// catégories proposées
		Vector<Visionnage> visio = modele.getVisionnages();
		Vector<Documentaire> docu = modele.getDocumentaires();
		Vector<Film> films = modele.getFilms();
		Vector<Episode> episodes = modele.getEpisodes();

		Vector<ContenuCinematographique> en_cours = new Vector<ContenuCinematographique>();
		for (int i = 0; i < visio.size(); i++) {
			if (visio.get(i).getID_membre() == user.getID() && visio.get(i).getTime_code() > 0) {
				if (visio.get(i).getID_documentaire() != 0) {
					for (int j = 0; j < docu.size(); j++) {
						if (docu.get(j).getID() == visio.get(i).getID_documentaire()) {
							en_cours.add(docu.get(j));
						}
					}
				}
				if (visio.get(i).getID_film() != 0) {
					for (int j = 0; j < films.size(); j++) {
						if (films.get(j).getID() == visio.get(i).getID_film()) {
							en_cours.add(films.get(j));
						}
					}
				}
				if (visio.get(i).getID_episode() != 0 && visio.get(i).getID_saison() != 0
						&& visio.get(i).getID_serie() != 0) {
					for (int j = 0; j < episodes.size(); j++) {
						if (episodes.get(j).getID() == visio.get(i).getID_episode()
								&& episodes.get(j).getID_saison() == visio.get(i).getID_saison()
								&& episodes.get(j).getID_serie() == visio.get(i).getID_serie()) {
							en_cours.add(episodes.get(j));
						}
					}
				}
			}
		}
		return en_cours;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(JFrame frame) {
		modele = new Controleur_Modele("root", "root", false);
		retour.setBackground(Color.BLACK);
		retour.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/retour2.png").getPath()));

		setRecomandations();

		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).setBorder(null);
			panels.get(i).setBackground(Color.BLACK);
		}

		compte.setBackground(Color.DARK_GRAY);
		compte.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/profil.png").getPath()));

		labelRecommendations.setForeground(Color.RED);

		lblEnCours.setForeground(Color.RED);

		titre.setText(" FLOU-FLIX ");
		titre.setTabSize(20);
		titre.setForeground(Color.RED);
		titre.setFont(new Font("Dialog", Font.BOLD, 50));
		titre.setEditable(false);
		titre.setBackground(Color.BLACK);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup().addGap(43)
										.addComponent(labelRecommendations, GroupLayout.PREFERRED_SIZE, 107,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(984, Short.MAX_VALUE))
						.addComponent(panels.get(1), GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE)
						.addComponent(panels.get(0), GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(42)
										.addComponent(lblEnCours, GroupLayout.PREFERRED_SIZE, 122,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 787, Short.MAX_VALUE)
										.addComponent(recherche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(17))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
										.addComponent(titre, GroupLayout.PREFERRED_SIZE, 291,
												GroupLayout.PREFERRED_SIZE)
										.addGap(336)))
								.addGap(10).addComponent(compte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(retour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(compte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(37)
								.addComponent(titre, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(recherche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)))
				.addComponent(panels.get(0), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(44)
				.addComponent(labelRecommendations, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				.addGap(1).addComponent(panels.get(1), GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
				.addGap(75))
				.addGroup(Alignment.LEADING,
						groupLayout.createSequentialGroup().addGap(147)
								.addComponent(lblEnCours, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(508, Short.MAX_VALUE)));

		for (int j = 0; j < recomendations.size(); j++) {
			for (int i = 0; i < recomendations.get(j).size(); i++) {
				recomendations.get(j).get(i).setFont(new Font("Rockwell Nova Extra Bold", Font.PLAIN, 10));
				recomendations.get(j).get(i).setBackground(Color.BLACK);
				panels.get(j).add(recomendations.get(j).get(i));
			}
		}
		for (int j = 0; j < panels.size(); j++) {
			panels.get(j).setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		}
		frame.getContentPane().setLayout(groupLayout);
	}

	public JButton_arrondi getRetour() {
		return retour;
	}

	public JButton_arrondi getRecherche() {
		return this.recherche;
	}

	public JButton_arrondi getCompte() {
		return this.compte;
	}

	public ArrayList<ArrayList<JButton_arrondi>> getFilms() {
		return this.recomendations;
	}

	public ContenuCinematographique getRecomandation(int i, int j) {
		return this.contenus.get(i).get(j);
	}

	public void repaint(JFrame frame) {
		this.retour.repaint();
		this.recherche.repaint();
		this.labelRecommendations.repaint();
		this.lblEnCours.repaint();
		this.compte.repaint();
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).repaint();
		}
		this.titre.repaint();

		frame.validate();
		frame.repaint();
	}

	public void delete(JFrame frame) {
		frame.getContentPane().remove(this.retour);
		frame.getContentPane().remove(this.recherche);
		frame.getContentPane().remove(this.labelRecommendations);
		frame.getContentPane().remove(this.lblEnCours);
		frame.getContentPane().remove(this.compte);
		for (int i = 0; i < panels.size(); i++) {
			frame.getContentPane().remove(panels.get(i));
		}
		frame.getContentPane().remove(this.titre);

		repaint(frame);
	}
}
