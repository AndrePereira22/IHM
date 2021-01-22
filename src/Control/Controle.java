package Control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.MainList;
import Model.Sprite;
import View.Componente;
import View.Entrada;
import View.Fase;
import View.Janela;
import View.Menu;
import View.Opcao;

public class Controle implements Runnable, ActionListener {

	private Janela janela;
	private Componente componentes;
	private Fase fase;
	private Opcao opcao;
	private Menu menu;
	private Entrada entrada;
	private Sprite personagem;
	private static HashMap<Integer, Boolean> keyPool;
	private Movimento movimento;
	private int indice = 0;

	public Controle(Janela janela) {

		this.janela = janela;
		this.componentes = janela.getComponentes();
		this.menu = janela.getMenu();
		this.fase = janela.getFase();
		this.opcao = janela.getOpcao();
		this.entrada = janela.getEntrada();
		this.personagem = fase.getPersonagem();

		keyPool = new HashMap<Integer, Boolean>();
		movimento = new Movimento(personagem, fase);

		controleEventos();

		janela.setVisible(true);
	}

	public void controleEventos() {

		menu.getJogar().addActionListener(this);
		menu.getSair().addActionListener(this);
		menu.getAjuda().addActionListener(this);
		opcao.getBtnIniciar().addActionListener(this);
		componentes.getBtnRight().addActionListener(this);
		componentes.getBtnLeft().addActionListener(this);
		componentes.getBtnUp().addActionListener(this);
		componentes.getBtn180().addActionListener(this);
		componentes.getBtnChutar().addActionListener(this);
		componentes.getBtnPlay().addActionListener(this);
		componentes.getBtnApagarSequencia().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == menu.getJogar()) {
			MudarTela(entrada, menu);

		}
		if (e.getSource() == opcao.getBtnIniciar()) {
			MudarTela(componentes, opcao);
			janela.TamanhoFase();

		}
		if (e.getSource() == componentes.getBtnRight()) {
			
			if(movimento.getLista().size()<16) {
			movimento.addMovimento("right");
			exibirComando("direita");
			}
		}
		if (e.getSource() == componentes.getBtnLeft()) {
			
			if(movimento.getLista().size()<16) {
			movimento.addMovimento("left");
			exibirComando("esquerda");
			}

		}

		if (e.getSource() == componentes.getBtnUp()) {
			
			if(movimento.getLista().size()<16) {
			movimento.addMovimento("up");
			exibirComando("cima");
			}

		}
		if (e.getSource() == componentes.getBtn180()) {
			
			if(movimento.getLista().size()<16) {

			movimento.addMovimento("giro");
			exibirComando("180");
			}

		}
	if (e.getSource() == componentes.getBtnChutar()) {
			
			if(movimento.getLista().size()<16) {

			movimento.addMovimento("chutar");
			exibirComando("chute");
			}

		}
		
		
		
		
		
		if (e.getSource() == componentes.getBtnPlay()) {
			movimento.Play();

		}
		if (e.getSource() == componentes.getBtnApagarSequencia()) {
			removerComando();

		}

	}

	public void run() {
		boolean ativo = true;
		while (ativo) {
			runControleDoJogo();

			try {
			
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void runControleDoJogo() {

		if (entrada.isVisible()) {
			try {
				Thread.sleep(5000);
				MudarTela(opcao, entrada);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void MudarTela(JPanel aparece, JPanel some) {
		aparece.setVisible(true);
		some.setVisible(false);

	}

	public void exibirComando(String direcao) {
		

		Component label = componentes.getPainelArea().getComponent(indice);

		JLabel img = (JLabel) label;
		img.setIcon(new ImageIcon(getClass().getResource("/" + direcao + ".png")));

		label.setVisible(true);
		indice++;
		

	}

	public void removerComando() {
		int tamanho = movimento.getLista().size();
		
		if(tamanho>0) {
		
		Component label = componentes.getPainelArea().getComponent(tamanho-1);

		JLabel img = (JLabel) label;

		img.setVisible(false);
		indice--;
	
		movimento.getLista().remove(tamanho-1);
		}
		

	}

	public void restar() {
		for(Component label: componentes.getPainelArea().getComponents()) {
			JLabel img = (JLabel) label;

			img.setVisible(false);
		}
		movimento.getLista().clear();
	}

}
