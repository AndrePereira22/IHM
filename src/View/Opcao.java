package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Opcao extends JPanel {
	private JTextField txtJogador, txtIdade;
	private JLabel lblJogador, lblIdade,fundo;
	private JButton btnIniciar,btnMenino,btnMenina;

	/**
	 * Create the panel.
	 */
	public Opcao(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);
		

		lblJogador = new JLabel("JOGADOR :");
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJogador.setForeground(Color.RED);
		lblJogador.setBounds(90, 195, 106, 22);
		add(lblJogador);

		lblIdade = new JLabel("IDADE :");
		lblIdade.setForeground(Color.RED);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdade.setBounds(90, 328, 87, 14);
		add(lblIdade);

		txtJogador = new JTextField();
		txtJogador.setBounds(185, 195, 178, 20);
		add(txtJogador);
		txtJogador.setColumns(10);

		txtIdade = new JTextField();
		txtIdade.setBounds(185, 324, 178, 20);
		add(txtIdade);
		txtIdade.setColumns(10);
		

		btnMenina = new JButton("");
		btnMenina .setIcon(new ImageIcon(getClass().getResource("/menina.png")));
		btnMenina .setContentAreaFilled(false);
		btnMenina .setBounds(270, 380, 62, 69);
		btnMenina.setBorder(null);
		add(btnMenina );
		

		btnMenino = new JButton("");
		btnMenino .setIcon(new ImageIcon(getClass().getResource("/menino.png")));
		btnMenino .setContentAreaFilled(false);
		btnMenino .setBounds(230, 380, 62, 69);
		btnMenino.setBorder(null);
		add(btnMenino );

		btnIniciar = new JButton("");
		btnIniciar.setIcon(new ImageIcon(getClass().getResource("/play.png")));
		btnIniciar.setContentAreaFilled(false);
		btnIniciar.setBounds(290, 470, 62, 69);
		add(btnIniciar);
		
		
		fundo = new JLabel(new ImageIcon(getClass().getResource("/opcao.png")));
		fundo.setBounds(0, 0, 800, 600);
		add(fundo);
		

	}

	public JTextField getTxtJogador() {
		return txtJogador;
	}

	public JTextField getTxtIdade() {
		return txtIdade;
	}

	public JButton getBtnIniciar() {
		return btnIniciar;
	}

	public JButton getBtnMenino() {
		return btnMenino;
	}

	public JButton getBtnMenina() {
		return btnMenina;
	}

}
