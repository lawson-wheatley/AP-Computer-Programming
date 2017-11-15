package window;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class windowRun extends JPanel {
	private static final long serialVersionUID = 1L;
	public void paint (Graphics g) {
		g.setColor(Color.BLACK);
		g.draw3DRect (25, 10, 50, 75, true);
	    g.draw3DRect (25, 110, 50, 75, false);
	    g.fill3DRect (100, 10, 50, 75, true);
	    g.fill3DRect (100, 110, 50, 75, false);
	}
	public static void j (int numplayers) {
		JFrame f = new JFrame("Yahtzee");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(20,20,500,500);
		while (true) {
		f.add(new windowRun());
		f.pack();
		f.setVisible(true);}
	}

}
