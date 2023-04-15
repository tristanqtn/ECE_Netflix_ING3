package Stats;

import java.awt.Color;

/**
 * 
 * @author Camickr
 * 
 *         Ce code est directement recupérer de StakcOverFlow :
 *         https://stackoverflow.com/questions/29708147/custom-graph-java-swing
 *         Code rédigié par Camickr et libre d'utilisation
 *
 */

public class Bar {
	private String label;
	private int value;
	private Color color;

	public Bar(String label, int value, Color color) {
		this.label = label;
		this.value = value;
		this.color = color;
	}

	public String getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}
}