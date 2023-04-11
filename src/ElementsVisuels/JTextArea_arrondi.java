/**
 * 
 */
package ElementsVisuels;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextArea;

/**
 * @author Francois BONNET
 *
 */
public class JTextArea_arrondi extends JTextArea{

	private static final long serialVersionUID = 1L;
	private Shape shape;
	
	public JTextArea_arrondi() {
		super();
		setOpaque(false);
		setBorder(null);
	}
	public JTextArea_arrondi(String content) {
		super(content);
		setOpaque(false);
		setBorder(null);
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
