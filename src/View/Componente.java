package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Componente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painelFase, painelArea, painelComandos,fundocomando;
	private JLabel lblComandos;
	private JLabel labelMain;
	private JButton btnRestart, btnApagarSequencia, menu;
	private JButton btnLeft, btnUp, btnRight, btn180, btnPlay,btnChutar,btnRepetir;

	
	private int[] valorMainList = {7 };

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
		menu.setBorder(null);
		menu.setContentAreaFilled(false);
		add(menu);

		btnRestart = new JButton("");
		btnRestart.setIcon(new ImageIcon(getClass().getResource("/reiniciar.png")));
		btnRestart.setBounds(49, 3, 69, 69);
		btnRestart.setBorder(null);
		btnRestart.setContentAreaFilled(false);
		add(btnRestart);


		painelFase = new JPanel();
		painelFase.setBackground(Color.BLACK);
		painelFase.setBounds(30, 110, 448, 352);
		painelFase .setOpaque(false);
		add(painelFase);

		painelArea = new JPanel();
		painelArea.setBackground(new Color(102, 205, 170));
		painelArea .setOpaque(false);
		painelArea.setBounds(509, 144, 167, 455);
		
		
		
		fundocomando = new JPanel();
		fundocomando.setOpaque(false);
		fundocomando.setBounds(509, 105, 167, 300);
			
		labelMain = new JLabel("");
		labelMain.setIcon(new ImageIcon(getClass().getResource("/main.png")));
		labelMain.setBounds(0, 0, 205, 345);
		fundocomando.add(labelMain);
		
		
		add(painelArea);
		add(fundocomando);


		btnApagarSequencia = new JButton("APAGAR ULTIMO");
		btnApagarSequencia.setIcon(new ImageIcon(getClass().getResource("/lixo.png")));
		btnApagarSequencia.setBounds(510, 415, 166, 43);
		btnApagarSequencia.setContentAreaFilled(false);
		add(btnApagarSequencia);

		painelComandos = new JPanel();
		painelComandos.setPreferredSize(new Dimension(largura, altura));
		painelComandos.setLayout(null);
		painelComandos.setBackground(new Color(46, 179, 87));
		painelComandos.setBounds(28, 501, 646, 88);

		btnLeft = new JButton("");
		btnLeft.setBounds(10, 11, 67, 69);
		btnLeft.setIcon(new ImageIcon(getClass().getResource("/left.png")));
		btnLeft.setContentAreaFilled(false);
		painelComandos.add(btnLeft);

		btnUp = new JButton("");
		btnUp.setIcon(new ImageIcon(getClass().getResource("/up.png")));
		btnUp.setBounds(82, 11, 67, 69);
		btnUp.setContentAreaFilled(false);
		painelComandos.add(btnUp);

		btnRight = new JButton("");
		btnRight.setIcon(new ImageIcon(getClass().getResource("/right.png")));
		btnRight.setBounds(154, 11, 67, 69);
		btnRight.setContentAreaFilled(false);
		painelComandos.add(btnRight);

		btn180 = new JButton("");
		btn180.setIcon(new ImageIcon(getClass().getResource("/giro.png")));
		btn180.setBounds(226, 11, 67, 69);
		btn180.setContentAreaFilled(false);
		painelComandos.add(btn180);
		
		btnChutar = new JButton("");
		btnChutar.setIcon(new ImageIcon(getClass().getResource("/chutar.png")));
		btnChutar.setBounds(384, 11, 67, 69);
		btnChutar.setContentAreaFilled(false);
		painelComandos.add(btnChutar);

		btnPlay = new JButton("");
		btnPlay.setIcon(new ImageIcon(getClass().getResource("/play.png")));
		btnPlay.setBounds(462, 11, 62, 69);
		btnPlay.setContentAreaFilled(false);
		painelComandos.add(btnPlay);
		

		btnRepetir = new JButton("");
		btnRepetir.setIcon(new ImageIcon(getClass().getResource("/repetir.png")));
		btnRepetir.setBounds(300, 11, 70, 69);
		btnRepetir.setContentAreaFilled(false);
		painelComandos.add(btnRepetir);

		add(painelComandos);
		

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

	public int[] getValorMainList() {
		return valorMainList;
	}


	public JButton getBtnRepetir() {
		return btnRepetir;
	}

}
