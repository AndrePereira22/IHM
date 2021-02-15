package View;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Entrada extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JLabel fundo;

	public Entrada(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);
	
		
		fundo = new JLabel(new ImageIcon(getClass().getResource("/fundo.gif")));
		fundo.setBounds(0, 0, 800, 600);
		add(fundo);
		
		setVisible(false);
	

	}
	



}