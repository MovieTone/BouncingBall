import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BouncingBall extends JFrame {

	private JPanel contentPane;
	private PaintPanel paintPanel;
	private JButton btnStart;
	private JButton btnStop;

	public BouncingBall() {
		setTitle("Bouncing Ball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 965);
		setResizable(false);

		createPaintPanel();
		createContentPane();
		contentPane.add(paintPanel);

		createStartBtn();
		contentPane.add(btnStart);

		createStopBtn();
		contentPane.add(btnStop);

		ControlPanel ctrlPanel = new ControlPanel(paintPanel);
		ctrlPanel.setLocation(579, 11);
		contentPane.add(ctrlPanel);
		setVisible(true);
	}

	private void createPaintPanel() {
		paintPanel = new PaintPanel();
		paintPanel.setLocation(183, 11);
	}

	private void createContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void createStartBtn() {
		btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 1) {
					paintPanel.start();
				}
			}
		});
		btnStart.setBounds(240, 426, 66, 23);
	}

	private void createStopBtn() {
		btnStop = new JButton("Stop");
		btnStop.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 1) {
					paintPanel.stop();
				}
			}
		});
		btnStop.setBounds(316, 426, 66, 23);
	}

}
