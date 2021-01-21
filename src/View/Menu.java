package View;

import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton jogar, ajuda, sair;

	private JLabel fundo;

	public Menu(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);
		

		jogar = new JButton("JOGAR");
		jogar.setBounds(170, 468, 120, 23);
		add(jogar);

		ajuda = new JButton("AJUDA");
		ajuda.setBounds(320, 468, 120, 23);
		add(ajuda);

		sair = new JButton("SAIR");
		sair.setBounds(470, 468, 120, 23);
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