package ElementsVisuels;

/**
 * 
 * @author Philipp Danner
 *
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ModernScrollBarUI extends BasicScrollBarUI {

	private static final int SCROLL_BAR_ALPHA_ROLLOVER = 100;
	private static final int SCROLL_BAR_ALPHA = 50;
	private static final int THUMB_SIZE = 8;
	private static final int SB_SIZE = 10;
	private static final Color THUMB_COLOR = Color.black;

	private JScrollPane sp;

	public ModernScrollBarUI(ModernScrollPane sp) {
		this.sp = sp;
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return new InvisibleScrollBarButton();
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return new InvisibleScrollBarButton();
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		@SuppressWarnings("unused")
		int alpha = isThumbRollover() ? SCROLL_BAR_ALPHA_ROLLOVER : SCROLL_BAR_ALPHA;
		int orientation = scrollbar.getOrientation();
		int x = thumbBounds.x;
		int y = thumbBounds.y;

		int width = orientation == JScrollBar.VERTICAL ? THUMB_SIZE : thumbBounds.width;
		width = Math.max(width, THUMB_SIZE);

		int height = orientation == JScrollBar.VERTICAL ? thumbBounds.height : THUMB_SIZE;
		height = Math.max(height, THUMB_SIZE);

		Graphics2D graphics2D = (Graphics2D) g.create();
		graphics2D.setColor(
				new Color(255 - THUMB_COLOR.getRed(), 255 - THUMB_COLOR.getGreen(), 255 - THUMB_COLOR.getBlue()));
		graphics2D.fillRect(x, y, width, height);
		graphics2D.dispose();
	}

	@Override
	protected void setThumbBounds(int x, int y, int width, int height) {
		super.setThumbBounds(x, y, width, height);
		sp.repaint();
	}

	public static int getSbSize() {
		return SB_SIZE;
	}

	/**
	 * Invisible Buttons, to hide scroll bar buttons
	 */
	private static class InvisibleScrollBarButton extends JButton {

		private static final long serialVersionUID = 1552427919226628689L;

		private InvisibleScrollBarButton() {
			setOpaque(false);
			setFocusable(false);
			setFocusPainted(false);
			setBorderPainted(false);
			setBorder(BorderFactory.createEmptyBorder());
		}
	}
}