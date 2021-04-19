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
	private JLabel lblComandos, lblFase, lblJogador, lblSize, lblDefault, lblErrouPosicao, lblErrouAcao;
	private JLabel labelMain, lblGol, lblErrouChutar;
	private JButton btnApagarSequencia, menu,btnRestart,btnSair;
	private JButton btnLeft, btnUp, btnRight, btn180, btnPlay, btnChutar;
	private int[] posXLabel = { 20, 52, 84, 118, 150, 182, 214, 246, 278, 310, 342, 374, 406, 438, 470, 502, 534, 566,
			598, 630, 662, 692, 722, 754, 786, 818 };

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

		lblJogador = new JLabel("JOGADOR:");
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJogador.setForeground(new Color(239, 213, 103));
		lblJogador.setBounds(490, 52, 319, 22);
		add(lblJogador);

		lblSize = new JLabel("0 / 25");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSize.setForeground(new Color(239, 213, 103));
		lblSize.setBounds(885, 600, 319, 22);
		add(lblSize);

		lblFase = new JLabel("FASE 1");
		lblFase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFase.setForeground(new Color(239, 213, 103));
		lblFase.setBounds(410, 52, 119, 22);
		add(lblFase);

		lblComandos = new JLabel("COMANDOS");
		lblComandos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComandos.setForeground(new Color(239, 213, 103));
		lblComandos.setBounds(785, 70, 119, 22);
		add(lblComandos);

		menu = new JButton("");
		menu.setIcon(new ImageIcon(getClass().getResource("/men.png")));
		menu.setBounds(80, 20, 100, 72);
		menu.setBorder(null);
		menu.setContentAreaFilled(false);
		add(menu);

		btnRestart = new JButton("");
		btnRestart.setIcon(new ImageIcon(getClass().getResource("/reset.png")));
		btnRestart.setBounds(190, 20, 100, 69);
		btnRestart.setBorder(null);
		btnRestart.setContentAreaFilled(false);
		add(btnRestart);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(getClass().getResource("/desligar.png")));
		btnSair.setBounds(300, 20, 100, 69);
		btnSair.setBorder(null);
		btnSair.setContentAreaFilled(false);
		add(btnSair);

		painelFase = new JPanel();
		painelFase.setBackground(Color.BLACK);
		painelFase.setBounds(0, 112, 896, 1040);
		painelFase.setOpaque(false);
		add(painelFase);

		painelArea = new JPanel();
		painelArea.setBackground(new Color(102, 205, 170));
		painelArea.setOpaque(false);
		painelArea.setLayout(null);
		painelArea.setBounds(34, 581, 890, 58);

		fundocomando = new JPanel();
		fundocomando.setOpaque(false);
		fundocomando.setBounds(22, 555, 845, 88);

		labelMain = new JLabel("");
		labelMain.setIcon(new ImageIcon(getClass().getResource("/main.png")));
		labelMain.setBounds(-10, 0, 845, 325);
		fundocomando.add(labelMain);

		add(painelArea);
		add(fundocomando);

		btnApagarSequencia = new JButton("APAGAR ULTIMO");
		btnApagarSequencia.setIcon(new ImageIcon(getClass().getResource("/lixo.png")));
		btnApagarSequencia.setBounds(775, 265, 180, 43);
		btnApagarSequencia.setForeground(Color.WHITE);
		btnApagarSequencia.setContentAreaFilled(false);
		add(btnApagarSequencia);

		lblDefault = new JLabel("");
		lblDefault.setIcon(new ImageIcon(getClass().getResource("/default.png")));
		lblDefault.setBounds(775, 330, 180, 180);
		lblDefault.setVisible(true);
		add(lblDefault);

		lblErrouPosicao = new JLabel("");
		lblErrouPosicao.setIcon(new ImageIcon(getClass().getResource("/posicaoInvalida.png")));
		lblErrouPosicao.setBounds(775, 330, 180, 180);
		lblErrouPosicao.setVisible(false);
		add(lblErrouPosicao);

		lblErrouAcao = new JLabel("");
		lblErrouAcao.setIcon(new ImageIcon(getClass().getResource("/errouAcao.png")));
		lblErrouAcao.setBounds(775, 330, 180, 180);
		lblErrouAcao.setVisible(false);
		add(lblErrouAcao);

		lblGol = new JLabel("");
		lblGol.setIcon(new ImageIcon(getClass().getResource("/errouGol.png")));
		lblGol.setBounds(775, 330, 180, 180);
		lblGol.setVisible(false);

		add(lblGol);

		lblErrouChutar = new JLabel("");
		lblErrouChutar.setIcon(new ImageIcon(getClass().getResource("/errouChutar.png")));
		lblErrouChutar.setBounds(775, 330, 180, 180);
		lblErrouPosicao.setVisible(false);
		add(lblErrouChutar);

		painelComandos = new JPanel();
		painelComandos.setPreferredSize(new Dimension(largura, altura));
		painelComandos.setLayout(null);
		painelComandos.setBackground(new Color(197, 219, 222));
		painelComandos.setOpaque(false);
		painelComandos.setBounds(775, 90, 200, 455);

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

		add(painelComandos);

		repaint();

	}

	public void ErrouPosicao() {
		lblDefault.setVisible(false);
		lblErrouPosicao.setVisible(true);
		setVisible(false);
		setVisible(true);
		repaint();
	}

	public void ErrouAcao() {
		lblDefault.setVisible(false);
		lblErrouAcao.setVisible(true);
		setVisible(false);
		setVisible(true);
		repaint();

	}

	public void ErrouChutar() {
		lblDefault.setVisible(false);
		lblErrouChutar.setVisible(true);
		setVisible(false);
		setVisible(true);
		repaint();
	}

	public void gol() {
		lblDefault.setVisible(false);
		lblGol.setVisible(true);
		setVisible(false);
		setVisible(true);
		repaint();
	}

	public void ErrouDefault() {
		lblErrouAcao.setVisible(false);
		lblErrouChutar.setVisible(false);
		lblGol.setVisible(false);
		lblErrouPosicao.setVisible(false);
		lblDefault.setVisible(true);
		setVisible(false);
		setVisible(true);
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
		if (painelArea.getComponents().length < 25) {
			JLabel label = new JLabel();

			label.setIcon(new ImageIcon(getClass().getResource("/" + direcao + ".png")));
			label.setBounds(posXLabel[indice], 14, 30, 30);
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

	public void setarPainelFase() {

		painelFase = new JPanel();
		painelFase.setBackground(Color.BLACK);
		painelFase.setBounds(0, 112, 896, 1040);
		painelFase.setOpaque(false);
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

	public JLabel getLblFase() {
		return lblFase;
	}

	public JLabel getLblJogador() {
		return lblJogador;
	}

	public void mudarSize(int numero) {
		lblSize.setText(numero + " / 25");

		lblSize.repaint();
	}

	public JLabel getLblDefault() {
		return lblDefault;
	}

	public JLabel getLblGol() {
		return lblGol;
	}

	public JButton getBtnRestart() {
		return btnRestart;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

}
