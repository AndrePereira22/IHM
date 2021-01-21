package Model;

import javax.swing.JLabel;

public class MainList extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String direcao;
	
	public MainList(String direcao) {
		
		this.direcao=direcao;	
		
	}

	public String getDirecao() {
		return direcao;
	}

	
	
}
