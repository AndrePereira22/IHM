package View;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ajuda extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JButton btnAvancar, btnVoltar;
	private JLabel fundo;

	public Ajuda(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);

		btnAvancar = new JButton("");
		btnAvancar.setIcon(new ImageIcon(getClass().getResource("/avancar.png")));
		btnAvancar.setRolloverIcon(new ImageIcon(getClass().getResource("/avancarRoller.png")));
		btnAvancar.setContentAreaFilled(false);
		btnAvancar.setBorder(null);
		btnAvancar.setBounds(600, 400, 62, 69);
		add(btnAvancar);

		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(getClass().getResource("/voltar.png")));
		btnVoltar.setRolloverIcon(new ImageIcon(getClass().getResource("/voltarRoller.png")));
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(140, 400, 62, 69);
		add(btnVoltar);

		fundo = new JLabel(new ImageIcon(getClass().getResource("/help.png")));
		fundo.setBounds(0, 0, 800, 600);
		add(fundo);

		setVisible(false);

	}

	public JButton getBtnAvancar() {
		return btnAvancar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

}