package Stats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Controleur.Controleur_Modele;
import Entite.Membre;

public class HistogramPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int histogramHeight = 200;
	private int barWidth = 50;
	private int barGap = 10;

	private JPanel barPanel;
	private JPanel labelPanel;

	private List<Bar> bars = new ArrayList<Bar>();

	public HistogramPanel() {

		setPreferredSize(new Dimension(1150, 700)); // choisir les dimension

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());

		barPanel = new JPanel(new GridLayout(1, 0, barGap, 0));
		barPanel.setBackground(Color.BLACK);
		barPanel.setForeground(Color.WHITE);
		Border outer = new MatteBorder(1, 1, 1, 1, Color.BLACK);
		Border inner = new EmptyBorder(10, 10, 0, 10);
		Border compound = new CompoundBorder(outer, inner);
		barPanel.setBorder(compound);

		labelPanel = new JPanel(new GridLayout(1, 0, barGap, 0));
		labelPanel.setBackground(Color.BLACK);
		labelPanel.setForeground(Color.WHITE);

		labelPanel.setBorder(new EmptyBorder(5, 10, 0, 10));

		add(barPanel, BorderLayout.CENTER);
		add(labelPanel, BorderLayout.PAGE_END);
	}

	public void addHistogramColumn(String label, int value, Color color) {
		Bar bar = new Bar(label, value, color);
		bars.add(bar);
	}

	public void layoutHistogram() {
		barPanel.removeAll();
		labelPanel.removeAll();

		int maxValue = 0;

		for (Bar bar : bars)
			maxValue = Math.max(maxValue, bar.getValue());

		for (Bar bar : bars) {

			JLabel label = new JLabel(bar.getValue() + "");
			label.setForeground(Color.WHITE);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.TOP);
			label.setVerticalAlignment(JLabel.BOTTOM);
			int barHeight = (bar.getValue() * histogramHeight) / maxValue;
			Icon icon = new ColorIcon(bar.getColor(), barWidth, barHeight);
			label.setIcon(icon);
			barPanel.add(label);

			JLabel barLabel = new JLabel(bar.getLabel());
			barLabel.setForeground(Color.WHITE);
			barLabel.setHorizontalAlignment(JLabel.CENTER);
			labelPanel.add(barLabel);
		}
	}

	private static void afficher_statistiques_temps_visionnage(Vector<Membre> membres) {
		HistogramPanel panel = new HistogramPanel();
		for (int i = 0; i < membres.size(); i++) {
			if (membres.get(i).getAdmin() == false)
				panel.addHistogramColumn(membres.get(i).getPrenom(), membres.get(i).getTemps_visionnage(), Color.RED);
		}

		panel.layoutHistogram();

		JFrame frame = new JFrame("Statistique de temps visionnage");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setLocationByPlatform(true);
		frame.pack();
		frame.setVisible(true);
	}

	private static void afficher_statistiques_nb_contenus_vu(Vector<Membre> membres) {
		HistogramPanel panel = new HistogramPanel();
		for (int i = 0; i < membres.size(); i++) {
			if (membres.get(i).getAdmin() == false)
				panel.addHistogramColumn(membres.get(i).getPrenom(), membres.get(i).getNb_film_vu(), Color.RED);
		}

		panel.layoutHistogram();

		JFrame frame = new JFrame("Statistique du nombre de contenus vus");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setLocationByPlatform(true);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Controleur_Modele ctrl = new Controleur_Modele("root", "root", true);

				afficher_statistiques_temps_visionnage(ctrl.getMembres());
				afficher_statistiques_nb_contenus_vu(ctrl.getMembres());
			}
		});
	}
}