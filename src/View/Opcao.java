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
	private JLabel lblJogador, lblIdade, lblIniciar;
	private JButton btnIniciar;

	/**
	 * Create the panel.
	 */
	public Opcao(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);
		setBackground(new Color(239, 213, 103));

		lblJogador = new JLabel("JOGADOR :");
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblJogador.setForeground(Color.RED);
		lblJogador.setBounds(74, 69, 106, 22);
		add(lblJogador);

		lblIdade = new JLabel("IDADE :");
		lblIdade.setForeground(Color.RED);
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdade.setBounds(74, 124, 87, 14);
		add(lblIdade);

		txtJogador = new JTextField();
		txtJogador.setBounds(178, 73, 178, 20);
		add(txtJogador);
		txtJogador.setColumns(10);

		txtIdade = new JTextField();
		txtIdade.setBounds(178, 118, 178, 20);
		add(txtIdade);
		txtIdade.setColumns(10);

		lblIniciar = new JLabel("INICIAR");
		lblIniciar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIniciar.setForeground(Color.RED);
		lblIniciar.setBounds(178, 250, 81, 14);
		add(lblIniciar);

		btnIniciar = new JButton("");
		btnIniciar.setIcon(new ImageIcon(getClass().getResource("/play.png")));
		btnIniciar.setContentAreaFilled(false);
		btnIniciar.setBounds(267, 231, 62, 69);
		add(btnIniciar);

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

}
