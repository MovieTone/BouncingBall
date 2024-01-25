import java.awt.SystemColor;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;

public class ControlPanel extends JPanel {

	private PaintPanel paintPanel;

	private JTextPane txtPaneXSpeed;
	private JTextPane txtPaneYSpeed;
	private JTextPane txtPaneWidth;
	private JTextPane txtPaneHeight;

	private JScrollBar scrollBarXSpeed;
	private JScrollBar scrollBarYSpeed;
	private JScrollBar scrollBarWidth;
	private JScrollBar scrollBarHeight;

	private static final String X_INCREMENT = "X Increment: ";
	private static final String Y_INCREMENT = "Y Increment: ";
	private static final String WIDTH_SIZE = "Width size: ";
	private static final String HEIGHT_SIZE = "Height size: ";

	private static final int X_INITIAL_VALUE = 1;
	private static final int Y_INITIAL_VALUE = 1;
	private static final int WIDTH_INITIAL_VALUE = 20;
	private static final int HEIGHT_INITIAL_VALUE = 20;

	private static final int TXT_PANE_X = 53;
	private static final int TXT_PANE_WIDTH = 93;
	private static final int TXT_PANE_HEIGHT = 20;

	private static final int SCROLL_BAR_X = 43;
	private static final int SCROLL_BAR_WIDTH = 108;
	private static final int SCROLL_BAR_HEIGHT = 17;
	private static final int SCROLL_BAR_MIN_VALUE = 1;
	private static final int SPEED_MAX_VALUE = 49;
	private static final int WIDTH_HEIGHT_MAX_VALUE = 99;

	public ControlPanel(final PaintPanel paintPanel) {
		this.paintPanel = paintPanel;

		setLayout(null);
		setBounds(392, 11, 189, 393);

		txtPaneXSpeed = addTextPane(X_INCREMENT + X_INITIAL_VALUE, TXT_PANE_X, 51,
				TXT_PANE_WIDTH, TXT_PANE_HEIGHT);
		txtPaneYSpeed = addTextPane(Y_INCREMENT + Y_INITIAL_VALUE, TXT_PANE_X, 145,
				TXT_PANE_WIDTH, TXT_PANE_HEIGHT);
		txtPaneWidth = addTextPane(WIDTH_SIZE + WIDTH_INITIAL_VALUE, TXT_PANE_X, 239,
				TXT_PANE_WIDTH, TXT_PANE_HEIGHT);
		txtPaneHeight = addTextPane(HEIGHT_SIZE + HEIGHT_INITIAL_VALUE, TXT_PANE_X, 326,
				TXT_PANE_WIDTH, TXT_PANE_HEIGHT);

		scrollBarXSpeed = addScrollBar(X_INITIAL_VALUE, X_INCREMENT, txtPaneXSpeed, SCROLL_BAR_MIN_VALUE,
				SPEED_MAX_VALUE, SCROLL_BAR_X, 23, SCROLL_BAR_WIDTH, SCROLL_BAR_HEIGHT);
		scrollBarYSpeed = addScrollBar(Y_INITIAL_VALUE, Y_INCREMENT, txtPaneYSpeed, SCROLL_BAR_MIN_VALUE,
				SPEED_MAX_VALUE, SCROLL_BAR_X, 117, SCROLL_BAR_WIDTH, SCROLL_BAR_HEIGHT);
		scrollBarWidth = addScrollBar(WIDTH_INITIAL_VALUE, WIDTH_SIZE, txtPaneWidth, SCROLL_BAR_MIN_VALUE,
				WIDTH_HEIGHT_MAX_VALUE, SCROLL_BAR_X, 211, SCROLL_BAR_WIDTH, SCROLL_BAR_HEIGHT);
		scrollBarHeight = addScrollBar(HEIGHT_INITIAL_VALUE, HEIGHT_SIZE, txtPaneHeight, SCROLL_BAR_MIN_VALUE,
				WIDTH_HEIGHT_MAX_VALUE, SCROLL_BAR_X, 305, SCROLL_BAR_WIDTH, SCROLL_BAR_HEIGHT);
	}

	private JScrollBar addScrollBar(int initValue, String text, JTextPane txtPane, int minValue,
			int maxValue, int x, int y, int width, int height) {
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setValue(initValue);
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
				int value = adjustmentEvent.getValue();

				switch (text) {
				case X_INCREMENT -> paintPanel.setXChange(value);
				case Y_INCREMENT -> paintPanel.setYChange(value);
				case WIDTH_SIZE -> paintPanel.setRWidth(value);
				case HEIGHT_SIZE -> paintPanel.setRHeight(value);
				}

				txtPane.setText(text + value);
			}
		});
		scrollBar.setMinimum(minValue);
		scrollBar.setMaximum(maxValue);
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar.setBounds(x, y, width, height);
		add(scrollBar);

		return scrollBar;
	}

	private JTextPane addTextPane(String text, int x, int y, int width, int height) {
		final JTextPane txtPane = new JTextPane();
		txtPane.setBackground(SystemColor.menu);
		txtPane.setText(text);
		txtPane.setBounds(x, y, width, height);
		txtPane.setEditable(false);
		add(txtPane);

		return txtPane;
	}

}
