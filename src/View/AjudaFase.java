package View;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AjudaFase extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JButton  btnVoltar;
	private JLabel fundo;

	public AjudaFase(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);


		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(getClass().getResource("/voltar.png")));
		btnVoltar.setRolloverIcon(new ImageIcon(getClass().getResource("/voltarRoller.png")));
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(140, 400, 62, 69);
		add(btnVoltar);

		fundo = new JLabel(new ImageIcon(getClass().getResource("/helpFase.png")));
		fundo.setBounds(0, 0, 800, 600);
		add(fundo);

		setVisible(false);

	}


	public JButton getBtnVoltar() {
		return btnVoltar;
	}

}