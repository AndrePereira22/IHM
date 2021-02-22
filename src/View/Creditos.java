package View;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Creditos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnVoltar;


	public Creditos(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);

		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(getClass().getResource("/voltar.png")));
		btnVoltar.setRolloverIcon(new ImageIcon(getClass().getResource("/voltarRoller.png")));
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(86, 400,62, 69);
		
		add(btnVoltar);
		
		JLabel facul = new JLabel("UNIVERSIDADE FEDERAL RUAL DE PERNAMBUCO- UAST");
		facul.setBounds(201, 220, 418, 29);
		add(facul);
		
		JLabel lblNewLabel = new JLabel("DISCIPLINA:  INTERFACES HOMEM-MÁQUINA");
		lblNewLabel.setBounds(201, 250, 275, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ALUNO: ANDR\u00C9 PEREIRA DOS SANTOS");
		lblNewLabel_1.setBounds(201, 270, 239, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PROFESSOR: RICHARLYSON A. D’EMERY ");
		lblNewLabel_2.setBounds(201, 290, 275, 14);
		add(lblNewLabel_2);
	
		
		
		JLabel fundoBaixo = new JLabel("cREDITOS");
		fundoBaixo.setIcon(new ImageIcon(getClass().getResource("/cred.png")));
		fundoBaixo.setBounds(113, 150, 572, 221);
		
		add(fundoBaixo);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(getClass().getResource("/a.png")));
		lblFundo.setBounds(0, 0, 792, 609);
		add(lblFundo);
		
		setVisible(false);

	}


	public JButton getBtnVoltar() {
		return btnVoltar;
	}


}