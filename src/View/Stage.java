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
	private JButton btnFase1, btnFase2, btnFase3, btnFase4, btnFase5, btnFase6,btnVoltar;
	private JPanel panelPlay;
	
	public Stage(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);

	
		btnFase1 = new JButton("");
		btnFase1.setIcon(new ImageIcon(getClass().getResource("/aberto1.png")));
		btnFase1.setContentAreaFilled(false);
		btnFase1.setBorder(null);
		btnFase1.setBounds(202, 210, 92, 94);
		
		add(btnFase1);

		btnFase2 = new JButton("");
		btnFase2.setIcon(new ImageIcon(getClass().getResource("/fechado2.png")));
		btnFase2.setContentAreaFilled(false);
		btnFase2.setBorder(null);
		btnFase2.setEnabled(false);
		btnFase2.setBounds(272,210, 92, 94);
		add(btnFase2);

		btnFase3 = new JButton("");
		btnFase3.setIcon(new ImageIcon(getClass().getResource("/fechado3.png")));
		btnFase3.setBounds(332, 210, 100, 94);
		btnFase3.setBorder(null);
		btnFase3.setEnabled(false);
		btnFase3.setContentAreaFilled(false);
		add(btnFase3);

		btnFase4 = new JButton("");
		btnFase4.setIcon(new ImageIcon(getClass().getResource("/fechado4.png")));
		btnFase4.setBounds(392,210, 92, 94);
		btnFase4.setEnabled(false);
		btnFase4.setBorder(null);
		btnFase4.setContentAreaFilled(false);
		add(btnFase4);

		btnFase5 = new JButton("");
		btnFase5.setIcon(new ImageIcon(getClass().getResource("/fechado5.png")));
		btnFase5.setContentAreaFilled(false);
		btnFase5.setBorder(null);
		btnFase5.setEnabled(false);
		btnFase5.setBounds(452, 210, 92, 94);
		add(btnFase5);

		btnFase6 = new JButton("");
		btnFase6.setIcon(new ImageIcon(getClass().getResource("/fechado6.png")));
		btnFase6.setBounds(512,  210, 92, 94);
		btnFase6.setEnabled(false);
		btnFase6.setBorder(null);
		btnFase6.setContentAreaFilled(false);
		add(btnFase6);
		
		
		panelPlay = new JPanel();
		panelPlay.setBounds(113, 409, 580, 93);
		panelPlay.setOpaque(false);
		panelPlay.setLayout(null);
		add(panelPlay);
		
		btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(getClass().getResource("/voltar.png")));
		btnVoltar.setRolloverIcon(new ImageIcon(getClass().getResource("/voltarRoller.png")));
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(null);
		btnVoltar.setBounds(40, 20, 62, 69);
		panelPlay.add(btnVoltar);
		
		
		JLabel fundoBaixo = new JLabel("SELECIONAR FASE");
		fundoBaixo.setIcon(new ImageIcon(getClass().getResource("/fases.png")));
		fundoBaixo.setBounds(113, 150, 572, 221);

	
		
		
		add(panelPlay);
		
		add(fundoBaixo);
		
		
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(getClass().getResource("/a.png")));
		lblFundo.setBounds(0, 0, 800, 600);
		add(lblFundo);

		setVisible(false);

	}

	public JButton getBtnVoltar() {
		return btnVoltar;
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
