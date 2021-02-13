package Control;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Audio;
import Model.Bola;
import Model.Sprite;
import Model.Trave;
import View.Componente;
import View.Entrada;
import View.Fase;
import View.Janela;
import View.Menu;
import View.Opcao;
import View.PraFora;
import View.Stage;

public class Controle implements Runnable, ActionListener {

	private Janela janela;
	private Componente componentes;
	private Fase fase;
	private Opcao opcao;
	private Audio audio;
	private Menu menu;
	private Entrada entrada;
	private Stage stage;
	private Sprite personagem;
	private Movimento movimento;
	private boolean brasil = false;
	private PraFora fora;
	private int aparencia = 1;
	private int controlador;

	public Controle(Janela janela) {

		this.janela = janela;
		this.componentes = janela.getComponentes();
		this.menu = janela.getMenu();
		this.audio = new Audio();
		this.opcao = janela.getOpcao();
		this.entrada = janela.getEntrada();
		this.stage = janela.getStage();
		this.fora = new PraFora(janela, true);
		audio.getMusica().loop(100);
		controleEventos();

		janela.setVisible(true);
	}

	public void controleEventos() {

		menu.getJogar().addActionListener(this);
		menu.getSair().addActionListener(this);
		menu.getAjuda().addActionListener(this);

		opcao.getBtnIniciar().addActionListener(this);
		opcao.getBtnBrasil().addActionListener(this);
		opcao.getBtnPortugal().addActionListener(this);

		componentes.getBtnRight().addActionListener(this);
		componentes.getBtnLeft().addActionListener(this);
		componentes.getBtnUp().addActionListener(this);
		componentes.getBtn180().addActionListener(this);
		componentes.getBtnChutar().addActionListener(this);
		componentes.getBtnPlay().addActionListener(this);
		componentes.getMenu().addActionListener(this);
		componentes.getBtnApagarSequencia().addActionListener(this);

		stage.getBtnFase1().addActionListener(this);
		stage.getBtnFase2().addActionListener(this);
		stage.getBtnFase3().addActionListener(this);
		stage.getBtnFase4().addActionListener(this);
		stage.getBtnFase5().addActionListener(this);
		stage.getBtnFase6().addActionListener(this);
		opcao.getBtnVoltar().addActionListener(this);

		stage.getBtnVoltar().addActionListener(this);

		fora.getBtnOk().addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == fora.getBtnOk()) {
			fora.setVisible(false);
			componentes.requestFocus();

		}

		if (e.getSource() == opcao.getBtnVoltar()) {
			MudarTela(menu, opcao);

		}
		if (e.getSource() == componentes.getMenu()) {
			MudarTela(stage, componentes);
			menu();
		}

		if (e.getSource() == stage.getBtnVoltar()) {
			MudarTela(opcao, stage);

		}
		if (e.getSource() == menu.getJogar()) {
			MudarTela(entrada, menu);

		}
		if (e.getSource() == menu.getSair()) {
			System.exit(0);

		}
		if (e.getSource() == stage.getBtnFase6()) {

			iniciar(6);

		}
		if (e.getSource() == stage.getBtnFase5()) {

			iniciar(5);

		}
		if (e.getSource() == stage.getBtnFase4()) {

			iniciar(4);

		}
		if (e.getSource() == stage.getBtnFase3()) {

			iniciar(3);

		}

		if (e.getSource() == stage.getBtnFase2()) {

			iniciar(2);

		}

		if (e.getSource() == stage.getBtnFase1()) {

			iniciar(1);

		}
		if (e.getSource() == opcao.getBtnIniciar()) {

			MudarTela(stage, opcao);
		}
		if (e.getSource() == opcao.getBtnBrasil()) {

			brasil = true;
		}
		if (e.getSource() == opcao.getBtnPortugal()) {
			brasil = false;

		}

		if (e.getSource() == componentes.getBtnRight()) {

			movimento.addMovimento("right");
			mudarSeta("right");

		}
		if (e.getSource() == componentes.getBtnLeft()) {

			movimento.addMovimento("left");
			mudarSeta("left");

		}

		if (e.getSource() == componentes.getBtnUp()) {

			movimento.addMovimento("up");
			mudarSeta("up");
		}
		if (e.getSource() == componentes.getBtn180()) {

			movimento.addMovimento("giro");

			mudarSeta("180");

		}
		if (e.getSource() == componentes.getBtnChutar()) {

			movimento.addMovimento("chutar");
			componentes.addComando("chute");

		}

		if (e.getSource() == componentes.getBtnPlay()) {

			if ((movimento.getLista().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Voce nao adicionou comandos");
			} else {
				if (movimento.getLista().get(movimento.getLista().size() - 1).getDirecao().equals("chutar")) {

					movimento.Play();
				} else {
					JOptionPane.showMessageDialog(null, "Adiciono o comando de chutar no final.");
				}
			}

		}
		if (e.getSource() == componentes.getBtnApagarSequencia()) {
			if (componentes.removerComando()) {
				apagarComando();
			}
			;

		}

	}

	public void run() {
		boolean ativo = true;
		while (ativo) {

			try {

				runControleDoJogo();

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

		if (fase != null && fase.isVisible()) {
			gol(0, 0);
			saidaDaBola();
		}

		if (fase != null) {
			
			if (personagem.colisao(Fase.getRetangulosColisao(), 0, 0)) {
				personagem.setX(personagem.getPonto().x);
				personagem.setY(personagem.getPonto().y);
				personagem.aparencia = 1;

			}
			if (movimento != null) {
				if (movimento.isForaAlvo()) {
					System.out.println("vc não ésta no alvo");
					reiniciar();
					movimento.getLista().clear();
					movimento.setForaAlvo(false);
				}
			}
		}
	}

	private void mudarSeta(String direcao) {

		if (direcao.equals("180")) {

			if (aparencia == 7) {
				aparencia = 2;
				componentes.setarIconeEsquerda();

			} else if (aparencia == 2) {
				aparencia = 7;
				componentes.setarIconeDireita();

			} else if (aparencia == 1) {
				aparencia = 0;
				componentes.setarIconeBaixo();

			} else if (aparencia == 0) {
				aparencia = 1;
				componentes.setarIconeCima();
			}

			componentes.repaint();
			componentes.addComando("180");

		} else if (direcao.equals("right")) {

			if (aparencia == 0) {
				aparencia = 2;
				componentes.setarIconeEsquerda();

			} else if (aparencia == 2) {
				aparencia = 1;
				componentes.setarIconeCima();

			} else if (aparencia == 1) {
				aparencia = 7;
				componentes.setarIconeDireita();

			} else if (aparencia == 7) {
				aparencia = 0;
				componentes.setarIconeBaixo();
			}
			componentes.addComando("direita");

		} else if (direcao.equals("left")) {

			if (aparencia == 0) {
				aparencia = 7;
				componentes.setarIconeDireita();

			} else if (aparencia == 7) {
				aparencia = 1;
				componentes.setarIconeCima();

			} else if (aparencia == 1) {
				aparencia = 2;
				componentes.setarIconeEsquerda();

			} else if (aparencia == 2) {
				aparencia = 0;
				componentes.setarIconeBaixo();
			}
			componentes.addComando("esquerda");

		} else if (direcao.equals("up")) {

			if (aparencia == 0) {
				componentes.addComando("baixo");
			} else if (aparencia == 7) {

				componentes.addComando("Di");
			} else if (aparencia == 1) {

				componentes.addComando("cima");
			} else if (aparencia == 2) {
				componentes.addComando("Es");
			}

		}

	}

	public void MudarTela(JPanel aparece, JPanel some) {
		aparece.setVisible(true);
		some.setVisible(false);

	}

	public void iniciar(int estado) {

		if (fase == null) {

			if (brasil) {
				this.fase = new Fase("sprite1.png");
			} else {
				this.fase = new Fase("sprite2.png");
			}
		}

		componentes.getPainelFase().setBounds(10, 60, 750, 512);

		if (componentes.getPainelFase().getComponents().length == 0) {

			componentes.getPainelFase().add(fase);
			this.personagem = fase.getPersonagem();
			this.movimento = new Movimento(personagem, fase, audio, componentes, fora);
		}

		reiniciar();
		janela.TamanhoFase();
		audio.getMusica().stop();
		MudarTela(componentes, stage);

		switch (estado) {
		case 1: {
			fase.setarColisao(fase.getColisao1());
			fase.setarMapa(fase.getCaminho1());
			fase.getTrave().posicaoDireita();
			controlador = 1;
			fase.getTrave().mudarIcone(1);

			break;
		}
		case 2: {

			fase.setarColisao(fase.getColisao2());
			fase.setarMapa(fase.getCaminho2());
			fase.getTrave().posicaoDireita();
			controlador = 2;
			fase.getTrave().mudarIcone(1);
			break;
		}
		case 3: {

			fase.setarColisao(fase.getColisao3());
			fase.setarMapa(fase.getCaminho3());
			fase.getTrave().posicaoDireita();
			controlador = 3;
			fase.getTrave().mudarIcone(1);
			break;
		}
		case 4: {

			fase.setarColisao(fase.getColisao4());
			fase.setarMapa(fase.getCaminho4());
			fase.getTrave().posicaoEsquerda();
			controlador = 4;
			fase.getTrave().mudarIcone(2);
			break;
		}
		case 5: {

			fase.setarColisao(fase.getColisao5());
			fase.setarMapa(fase.getCaminho5());
			fase.getTrave().posicaoEsquerda();
			controlador = 5;
			fase.getTrave().mudarIcone(2);
			break;
		}
		case 6: {

			fase.setarColisao(fase.getColisao6());
			fase.setarMapa(fase.getCaminho6());
			fase.getTrave().posicaoEsquerda();
			controlador = 5;
			fase.getTrave().mudarIcone(2);
			break;
		}
		}

	}

	public void saidaDaBola() {

		for (int i = 0; i < Bola.getBolas().size(); i++) {

			Bola bola = Bola.getBolas().get(i);

			if (bola.getX() < 10 || bola.getX() > 764 || bola.getY() < 10 || bola.getY() > 512) {
				bola.setVisivel(false);
				reiniciar();

			}

		}

	}

	public void gol(int x, int y) {

		Trave tempTrave = fase.getTrave();

		Rectangle trave = new Rectangle(tempTrave.getX() + x, tempTrave.getY() + y, tempTrave.getLargura(),
				tempTrave.getAltura());

		for (int i = 0; i < Bola.getBolas().size(); i++) {

			Bola b = Bola.getBolas().get(i);

			Rectangle ball = new Rectangle(b.getX() + x, b.getY() + y, b.getLargura(), b.getAltura());

			if (trave.intersects(ball)) {
				audio.getGol().start();
				b.setVisivel(false);

				menu();
				MudarTela(stage, componentes);
				// reiniciar();
				liberarFase();
			}

		}

	}

	public void liberarFase() {

		switch (controlador) {
		case 1: {

			stage.getBtnFase2().setEnabled(true);
			break;
		}
		case 2: {

			stage.getBtnFase3().setEnabled(true);
			break;
		}
		case 3: {

			stage.getBtnFase4().setEnabled(true);
			break;
		}
		case 4: {

			stage.getBtnFase5().setEnabled(true);
			break;
		}
		case 5: {

			stage.getBtnFase6().setEnabled(true);
			break;
		}

		}

	}

	public void reiniciar() {
		personagem.setX(personagem.getPonto().x);
		personagem.setY(personagem.getPonto().y);
		Bola.getBolas().clear();

		componentes.setarIconeCima();
		aparencia = 1;
		componentes.getPainelArea().removeAll();
		personagem.aparencia = 1;
		componentes.setIndice(0);

	}

	public void menu() {
		componentes.getPainelFase().setBounds(1000, 0, 708, 448);
		movimento.getLista().clear();
		componentes.getPainelArea().removeAll();
		janela.TamanhoMenu();
	}

	private void apagarComando() {

		int tamanho = movimento.getLista().size() - 1;

		if (movimento.getLista().get(tamanho).getDirecao().equals("180")) {

			if (aparencia == 7) {
				aparencia = 2;
				componentes.setarIconeEsquerda();

			} else if (aparencia == 2) {
				aparencia = 7;
				componentes.setarIconeDireita();

			} else if (aparencia == 1) {
				aparencia = 0;
				componentes.setarIconeBaixo();

			} else if (aparencia == 0) {
				aparencia = 1;
				componentes.setarIconeCima();
			}

			componentes.repaint();

		} else if (movimento.getLista().get(tamanho).getDirecao().equals("right")) {

			if (aparencia == 0) {
				aparencia = 7;
				componentes.setarIconeDireita();

			} else if (aparencia == 7) {
				aparencia = 1;
				componentes.setarIconeCima();

			} else if (aparencia == 1) {
				aparencia = 2;
				componentes.setarIconeEsquerda();

			} else if (aparencia == 2) {
				aparencia = 0;
				componentes.setarIconeBaixo();
			}

		} else if (movimento.getLista().get(tamanho).getDirecao().equals("left")) {

			if (aparencia == 0) {
				aparencia = 2;
				componentes.setarIconeEsquerda();

			} else if (aparencia == 2) {
				aparencia = 1;
				componentes.setarIconeCima();

			} else if (aparencia == 1) {
				aparencia = 7;
				componentes.setarIconeDireita();

			} else if (aparencia == 7) {
				aparencia = 0;
				componentes.setarIconeBaixo();
			}

		}
		movimento.getLista().remove(tamanho);
	}
}
