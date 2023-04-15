/**
 * 
 */
package ElementsVisuels;

/**
* @author François BONNET 
*/

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class JTextField_arrondi extends JTextField {///Classe donnant une JTextField à bords ronds
	
	private static final long serialVersionUID = 1L;
	private Shape shape;
	
	public JTextField_arrondi(int size) {
		super(size);
		setOpaque(false);
	}
	
	public JTextField_arrondi(String word) {
		super(word);
		setOpaque(false);
	}
	
	public JTextField_arrondi() {
		super();
		setOpaque(false);
	}
	
	protected void paintComponent(Graphics g) {///On dessine la zone de texte
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 7, 7);
		super.paintComponent(g);
	}
	
	protected void paintBorder(Graphics g) {//On dessine la bordure de la zone de texte
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 7, 7);
	}
	
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
		  shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 7, 7);
		}
		return shape.contains(x, y);
	}
}