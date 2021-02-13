package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Componente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painelFase, painelArea, painelComandos, fundocomando;
	private JLabel lblComandos;
	private JLabel labelMain;
	private JButton btnRestart, btnApagarSequencia, menu;
	private JButton btnLeft, btnUp, btnRight, btn180, btnPlay, btnChutar;
	private int[] posXLabel = { 20, 52, 84, 118, 150, 182, 214, 246, 278, 310, 342, 374, 406, 438, 470, 502, 534, 566,
			598, 630, 662, 692, 722 };
	private int[] posYLabel = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
			181 };
	private int indice = 0;
	private ImageIcon iconBaixo, iconCima, iconDireita, iconEsquerda;

	private int[] valorMainList = { 7 };

	public Componente(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));

		setBackground(new Color(42, 65, 27));

		setLayout(null);

		iconBaixo = new ImageIcon(getClass().getResource("/BA.png"));
		iconCima = new ImageIcon(getClass().getResource("/up.png"));
		iconDireita = new ImageIcon(getClass().getResource("/DE.png"));
		iconEsquerda = new ImageIcon(getClass().getResource("/LE.png"));

		lblComandos = new JLabel("COMANDOS");
		lblComandos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComandos.setForeground(new Color(239, 213, 103));
		lblComandos.setBounds(785, 40, 119, 22);
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
		painelFase.setBounds(30, 110, 896, 1040);
		painelFase.setOpaque(false);
		add(painelFase);

		painelArea = new JPanel();
		painelArea.setBackground(new Color(102, 205, 170));
		painelArea.setOpaque(false);
		painelArea.setBounds(28, 501, 760, 88);

		fundocomando = new JPanel();
		fundocomando.setOpaque(false);
		fundocomando.setBounds(22, 515, 744, 88);

		labelMain = new JLabel("");
		labelMain.setIcon(new ImageIcon(getClass().getResource("/main.png")));
		labelMain.setBounds(0, 0, 744, 325);
		fundocomando.add(labelMain);

		add(painelArea);
		add(fundocomando);

		btnApagarSequencia = new JButton("APAGAR ULTIMO");
		btnApagarSequencia.setIcon(new ImageIcon(getClass().getResource("/lixo.png")));
		btnApagarSequencia.setBounds(785, 215, 180, 43);
		btnApagarSequencia.setForeground(Color.WHITE);
		btnApagarSequencia.setContentAreaFilled(false);
		add(btnApagarSequencia);

		painelComandos = new JPanel();
		painelComandos.setPreferredSize(new Dimension(largura, altura));
		painelComandos.setLayout(null);
		painelComandos.setBackground(new Color(197, 219, 222));
		painelComandos.setOpaque(false);
		painelComandos.setBounds(785, 55, 200, 455);

		btnLeft = new JButton("");
		btnLeft.setBounds(0, 11, 57, 69);
		btnLeft.setIcon(new ImageIcon(getClass().getResource("/left.png")));
		btnLeft.setContentAreaFilled(false);
		painelComandos.add(btnLeft);

		btnUp = new JButton("");
		btnUp.setIcon(iconCima);
		btnUp.setBounds(62, 85, 57, 69);
		btnUp.setContentAreaFilled(false);
		painelComandos.add(btnUp);

		btnRight = new JButton("");
		btnRight.setIcon(new ImageIcon(getClass().getResource("/right.png")));
		btnRight.setBounds(62, 11, 57, 69);
		btnRight.setContentAreaFilled(false);
		painelComandos.add(btnRight);

		btn180 = new JButton("");
		btn180.setIcon(new ImageIcon(getClass().getResource("/giro.png")));
		btn180.setBounds(124, 11, 57, 69);
		btn180.setContentAreaFilled(false);
		painelComandos.add(btn180);

		btnChutar = new JButton("");
		btnChutar.setIcon(new ImageIcon(getClass().getResource("/chutar1x.png")));
		btnChutar.setBounds(0, 85, 57, 69);
		btnChutar.setContentAreaFilled(false);
		painelComandos.add(btnChutar);

		btnPlay = new JButton("");
		btnPlay.setIcon(new ImageIcon(getClass().getResource("/play.png")));
		btnPlay.setBounds(124, 85, 57, 69);
		btnPlay.setContentAreaFilled(false);
		painelComandos.add(btnPlay);
//
		add(painelComandos);

		repaint();

	}

	public void setarIconeCima() {
		btnUp.setIcon(iconCima);
	}

	public void setarIconeBaixo() {
		btnUp.setIcon(iconBaixo);
	}

	public void setarIconeDireita() {
		btnUp.setIcon(iconDireita);
	}

	public void setarIconeEsquerda() {
		btnUp.setIcon(iconEsquerda);
	}

	public void addComando(String direcao) {
		if (painelArea.getComponents().length < 23) {
			JLabel label = new JLabel();

			label.setIcon(new ImageIcon(getClass().getResource("/" + direcao + ".png")));
			label.setBounds(posXLabel[indice], posYLabel[indice], 30, 30);
			painelArea.add(label);

			indice++;
			painelArea.repaint();

		}

	}

	public boolean removerComando() {
		int tamanho = painelArea.getComponents().length;

		if (tamanho > 0) {

			Component label = painelArea.getComponent(tamanho - 1);

			painelArea.remove(label);

			indice--;
			painelArea.repaint();
			
			return true;
		}
		return false;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
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

}
