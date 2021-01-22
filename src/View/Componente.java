package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Componente extends JPanel {

	private JPanel painelFase, painelArea, painelComandos;
	private JLabel lblComandos, lblMainArea, lblTotal;
	private JLabel lbl1;
	private JButton btnRestart, btnApagarSequencia, menu;
	private JButton btnLeft, btnUp, btnRight, btn180, btnPlay,btnChutar;
	private int[] x = { 10, 42, 74,106,10, 42, 74,106, 10, 42, 74, 106,10, 42, 74, 106 };
	private int[] y = { 5, 5, 5,5, 46, 46, 46,46, 91, 91, 91, 91,136,136,136,136 };

	public Componente(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));

		setBackground(SystemColor.textHighlight);
		setLayout(null);

		lblComandos = new JLabel("COMANDOS");
		lblComandos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComandos.setForeground(SystemColor.text);
		lblComandos.setBounds(28, 468, 119, 22);
		add(lblComandos);

		menu = new JButton("");
		menu.setIcon(new ImageIcon(getClass().getResource("/men.png")));
		menu.setBounds(139, 0, 61, 72);
		add(menu);

		btnRestart = new JButton("");

		btnRestart.setIcon(new ImageIcon(getClass().getResource("/reiniciar.png")));
		btnRestart.setBounds(49, 3, 69, 69);
		btnRestart.setContentAreaFilled(false);
		add(btnRestart);

		lblMainArea = new JLabel("MAIN AREA");
		lblMainArea.setForeground(Color.WHITE);
		lblMainArea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMainArea.setBounds(510, 61, 120, 22);
		add(lblMainArea);

		lblTotal = new JLabel("1/1");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotal.setBounds(636, 61, 61, 22);
		add(lblTotal);

		painelFase = new JPanel();
		painelFase.setBackground(Color.BLACK);
		painelFase.setBounds(30, 105, 448, 352);
		add(painelFase);

		painelArea = new JPanel();
		painelArea.setBackground(new Color(102, 205, 170));
		painelArea.setBounds(509, 104, 167, 200);

		addLabel();

		btnApagarSequencia = new JButton("APAGAR ULTIMO");
		btnApagarSequencia.setIcon(new ImageIcon(getClass().getResource("/lixo.png")));
		btnApagarSequencia.setBounds(510, 305, 166, 43);
		btnApagarSequencia.setContentAreaFilled(false);
		add(btnApagarSequencia);

		painelComandos = new JPanel();
		painelComandos.setPreferredSize(new Dimension(largura, altura));
		painelComandos.setLayout(null);
		painelComandos.setBackground(new Color(46, 179, 87));
		painelComandos.setBounds(28, 501, 499, 88);

		btnLeft = new JButton("");
		btnLeft.setBounds(28, 11, 67, 69);
		btnLeft.setIcon(new ImageIcon(getClass().getResource("/left.png")));
		btnLeft.setContentAreaFilled(false);
		painelComandos.add(btnLeft);

		btnUp = new JButton("");
		btnUp.setIcon(new ImageIcon(getClass().getResource("/up.png")));
		btnUp.setBounds(100, 11, 67, 69);
		btnUp.setContentAreaFilled(false);
		painelComandos.add(btnUp);

		btnRight = new JButton("");
		btnRight.setIcon(new ImageIcon(getClass().getResource("/right.png")));
		btnRight.setBounds(172, 11, 67, 69);
		btnRight.setContentAreaFilled(false);
		painelComandos.add(btnRight);

		btn180 = new JButton("");
		btn180.setIcon(new ImageIcon(getClass().getResource("/giro.png")));
		btn180.setBounds(244, 11, 67, 69);
		btn180.setContentAreaFilled(false);
		painelComandos.add(btn180);
		
		btnChutar = new JButton("");
		btnChutar.setIcon(new ImageIcon(getClass().getResource("/chutar.png")));
		btnChutar.setBounds(316, 11, 67, 69);
		btnChutar.setContentAreaFilled(false);
		painelComandos.add(btnChutar);

		btnPlay = new JButton("");
		btnPlay.setIcon(new ImageIcon(getClass().getResource("/play.png")));
		btnPlay.setBounds(427, 11, 62, 69);
		btnPlay.setContentAreaFilled(false);
		painelComandos.add(btnPlay);

		add(painelComandos);

	}

	public void addLabel() {
		painelArea.setPreferredSize(new Dimension(167, 147));
		painelArea.setLayout(null);

		for (int i = 0; i < 16; i++) {

			lbl1 = new JLabel("");
			lbl1.setIcon(new ImageIcon(getClass().getResource("/cima.png")));
			lbl1.setBounds(x[i], y[i], 30, 35);
			lbl1.setVisible(false);
			painelArea.add(lbl1);

		}
		add(painelArea);
	}

	public JPanel getPainelFase() {
		return painelFase;
	}

	public JPanel getPainelArea() {
		return painelArea;
	}

	public JPanel getPainelComandos() {
		return painelComandos;
	}

	public void setPainelComandos(JPanel painelComandos) {
		this.painelComandos = painelComandos;
	}

	public JButton getMenu() {
		return menu;
	}

	public JButton getBtnRestart() {
		return btnRestart;
	}

	public JButton getBtnApagarSequencia() {
		return btnApagarSequencia;
	}

	public JButton getBtnLeft() {
		return btnLeft;
	}

	public JButton getBtnUp() {
		return btnUp;
	}

	public JButton getBtnRight() {
		return btnRight;
	}

	public JButton getBtn180() {
		return btn180;
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public JButton getBtnChutar() {
		return btnChutar;
	}

}
