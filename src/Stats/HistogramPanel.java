package Stats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 * 
 * @author Camickr
 * 
 *         Ce code est directement recupérer de StakcOverFlow :
 *         https://stackoverflow.com/questions/29708147/custom-graph-java-swing
 *         Code rédigié par Camickr et libre d'utilisation
 *
 */

public class HistogramPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int histogramHeight = 200;
	private int barWidth = 50;
	private int barGap = 10;

	private JPanel barPanel;
	private JPanel labelPanel;

	private List<Bar> bars = new ArrayList<Bar>();

	public HistogramPanel() {

		setPreferredSize(new Dimension(700, 500)); // choisir les dimension
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

}