package View;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Stage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8516177550821869210L;
	private JButton btnFase1, btnFase2, btnFase3, btnFase4, btnFase5, btnFase6;

	public Stage(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);

	
		btnFase1 = new JButton("");
		btnFase1.setIcon(new ImageIcon(getClass().getResource("/aberto1.png")));
		btnFase1.setContentAreaFilled(false);
		btnFase1.setBounds(382, 162, 92, 94);
		
		add(btnFase1);

		btnFase2 = new JButton("");
		btnFase2.setIcon(new ImageIcon(getClass().getResource("/fechado2.png")));
		btnFase2.setContentAreaFilled(false);
		btnFase2.setBounds(491, 162, 92, 94);
		add(btnFase2);

		btnFase3 = new JButton("");
		btnFase3.setIcon(new ImageIcon(getClass().getResource("/fechado3.png")));
		btnFase3.setBounds(593, 162, 100, 94);
		btnFase3.setContentAreaFilled(false);
		add(btnFase3);

		btnFase4 = new JButton("");
		btnFase4.setIcon(new ImageIcon(getClass().getResource("/fechado4.png")));
		btnFase4.setBounds(382, 267, 92, 94);
		btnFase4.setContentAreaFilled(false);
		add(btnFase4);

		btnFase5 = new JButton("");
		btnFase5.setIcon(new ImageIcon(getClass().getResource("/fechado5.png")));
		btnFase5.setContentAreaFilled(false);
		btnFase5.setBounds(491, 267, 92, 94);
		add(btnFase5);

		btnFase6 = new JButton("");
		btnFase6.setIcon(new ImageIcon(getClass().getResource("/fechado6.png")));
		btnFase6.setBounds(603, 267, 92, 94);
		btnFase6.setContentAreaFilled(false);
		add(btnFase6);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(getClass().getResource("/a.png")));
		lblFundo.setBounds(10, -60, 792, 609);
		add(lblFundo);

		setVisible(false);

	}

	public JButton getBtnFase1() {
		return btnFase1;
	}

	public JButton getBtnFase2() {
		return btnFase2;
	}

	public JButton getBtnFase3() {
		return btnFase3;
	}

	public JButton getBtnFase4() {
		return btnFase4;
	}

	public JButton getBtnFase5() {
		return btnFase5;
	}

	public JButton getBtnFase6() {
		return btnFase6;
	}
	
	
}
