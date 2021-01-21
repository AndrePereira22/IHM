package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class teste extends JPanel {
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9;

	public teste() {
		setLayout(null);

		lbl1 = new JLabel("");
		lbl1.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
		lbl1.setBounds(20, 11, 30, 35);
		add(lbl1);

		lbl2 = new JLabel("");
		lbl2.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
		lbl2.setBounds(78, 11, 30, 35);
		add(lbl2);

		lbl3 = new JLabel("");
		lbl3.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
		lbl3.setBounds(130, 11, 30, 35);
		add(lbl3);
		lbl4 = new JLabel("");
		lbl4.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
		lbl4.setBounds(20, 57, 30, 35);
		add(lbl4);

		lbl5 = new JLabel("");
		lbl5.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
		lbl5.setBounds(78, 57, 30, 35);
		add(lbl5);

		lbl6 = new JLabel("");
		lbl6.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
		lbl6.setBounds(130, 57, 30, 35);
		add(lbl6);

		lbl7 = new JLabel("");
		lbl7.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
		lbl7.setBounds(20, 103, 30, 35);
		add(lbl7);

		lbl8 = new JLabel("");
		lbl8.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
		lbl8.setBounds(78, 103, 30, 35);
		add(lbl8);

		lbl9 = new JLabel("");
		lbl9.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
		lbl9.setBounds(130, 101, 30, 35);
		add(lbl9);

	}
}
