package View;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton jogar, ajuda, sair,creditos;

	private JLabel fundo;

	public Menu(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);
		

		jogar = new JButton();
		jogar.setContentAreaFilled(false);
		jogar.setBorder(null);
		jogar.setBounds(160, 448, 125, 63);
		jogar.setIcon(new ImageIcon(getClass().getResource("/jogar.png")));
		add(jogar);
		
		creditos = new JButton();
		creditos.setContentAreaFilled(false);
		creditos.setBorder(null);
		creditos.setBounds(280, 448, 125, 63);
		creditos.setIcon(new ImageIcon(getClass().getResource("/creditos.png")));
		add(creditos);

		ajuda = new JButton();
		ajuda.setContentAreaFilled(false);
		ajuda.setBorder(null);
		ajuda.setIcon(new ImageIcon(getClass().getResource("/ajuda.png")));
		ajuda.setBounds(400, 448, 125, 63);
		add(ajuda);

		sair = new JButton();
		sair.setContentAreaFilled(false);
		sair.setIcon(new ImageIcon(getClass().getResource("/sair.png")));
		sair.setBounds(520, 448, 120, 63);
		sair.setBorder(null);
		add(sair);
		
		
		fundo = new JLabel(new ImageIcon(getClass().getResource("/img.gif")));
		fundo.setBounds(0, 0, 800, 600);
		add(fundo);
		
		setVisible(true);

	}

	public JButton getCreditos() {
		return creditos;
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