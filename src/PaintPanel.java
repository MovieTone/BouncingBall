import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PaintPanel extends JPanel implements ActionListener {

	private int x;
	private int y;
	private int rWidth;
	private int rHeight;
	private int xChange;
	private int yChange;
	private Timer tm;

	private static final int X_BOUND = 10;
	private static final int Y_BOUND = 11;
	private static final int WIDTH_BOUND = 376;
	private static final int HEIGHT_BOUND = 383;

	public PaintPanel() {
		super();
		setBackground(Color.WHITE);
		setBounds(X_BOUND, Y_BOUND, WIDTH_BOUND, HEIGHT_BOUND);
		tm = new Timer(5, this);
		xChange = 1;
		yChange = 1;
		x = 185;
		y = 19;
		rWidth = 20;
		rHeight = 20;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		x += xChange;
		y += yChange;
		if (x - rWidth < X_BOUND) {
			xChange = -xChange;
			x = X_BOUND + rWidth;
		} else if (x + rWidth > X_BOUND + WIDTH_BOUND) {
			xChange = -xChange;
			x = X_BOUND + WIDTH_BOUND - rWidth;
		}
		if (y - rHeight < Y_BOUND) {
			yChange = -yChange;
			y = Y_BOUND + rHeight;
		} else if (y + rHeight > Y_BOUND + HEIGHT_BOUND) {
			yChange = -yChange;
			y = Y_BOUND + HEIGHT_BOUND - rHeight;
		}
		drawCircle((Graphics2D) g, x, y, rWidth, rHeight);
	}

	public void drawCircle(Graphics2D g, int x, int y, int width, int height) {
		x = x - (width / 2);
		y = y - (height / 2);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void start() {
		tm.start();
	}

	public void stop() {
		tm.stop();
	}

	public int getXChange() {
		return xChange;
	}

	public void setXChange(int xChange) {
		this.xChange = xChange;
	}

	public int getYChange() {
		return yChange;
	}

	public void setYChange(int yChange) {
		this.yChange = yChange;
	}

	public int getRWidth() {
		return rWidth;
	}

	public void setRWidth(int width) {
		this.rWidth = width;
	}

	public int getRHeight() {
		return rHeight;
	}

	public void setRHeight(int height) {
		this.rHeight = height;
	}

}
