package View;

import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Creditos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton jogar, ajuda, sair;

	private JLabel fundo;

	public Creditos(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);
		

		jogar = new JButton("JOGAR");
		jogar.setContentAreaFilled(false);
		jogar.setBounds(200, 448, 120, 63);
		jogar.setIcon(new ImageIcon(getClass().getResource("/jogar.png")));
		add(jogar);

		ajuda = new JButton("AJUDA");
		ajuda.setContentAreaFilled(false);
		ajuda.setIcon(new ImageIcon(getClass().getResource("/ajuda.png")));
		ajuda.setBounds(350, 448, 120, 63);
		add(ajuda);

		sair = new JButton("SAIR");
		sair.setContentAreaFilled(false);
		sair.setIcon(new ImageIcon(getClass().getResource("/sair.png")));
		sair.setBounds(500, 448, 120, 63);
		add(sair);
		
		
		fundo = new JLabel(new ImageIcon(getClass().getResource("/img.gif")));
		fundo.setBounds(0, 0, 800, 600);
		add(fundo);
		
		setVisible(true);

	}

	public JButton getJogar() {
		return jogar;
	}

	public JButton getAjuda() {
		return ajuda;
	}

	public JButton getSair() {
		return sair;
	}

}