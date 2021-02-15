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
import View.Ajuda;
import View.AjudaFase;
import View.Componente;
import View.Creditos;
import View.Entrada;
import View.Fase;
import View.Janela;
import View.Menu;
import View.Opcao;
import View.Stage;

public class Controle implements Runnable, ActionListener {

	private Janela janela;
	private Componente componentes;
	private Fase fase;
	private Opcao opcao;
	private Audio audio;
	private Menu menu;
	private Entrada entrada;
	private Creditos creditos;
	private Ajuda ajuda;
	private AjudaFase ajudaFase;
	private Stage stage;
	private Sprite personagem;
	private Movimento movimento;
	private boolean brasil = false;

	private int aparencia = 1;
	private int controlador;

	public Controle(Janela janela) {

		this.janela = janela;
		this.componentes = janela.getComponentes();
		this.menu = janela.getMenu();
		this.audio = new Audio();
		this.opcao = janela.getOpcao();
		this.entrada = janela.getEntrada();
		this.creditos = janela.getCreditos();
		this.ajuda = janela.getAjuda();
		this.ajudaFase = janela.getAjudaFase();
		this.stage = janela.getStage();

		audio.getMusica().loop(100);
		controleEventos();

		janela.setVisible(true);
	}

	public void controleEventos() {

		menu.getJogar().addActionListener(this);
		menu.getSair().addActionListener(this);
		menu.getAjuda().addActionListener(this);
		menu.getCreditos().addActionListener(this);

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
		ajuda.getBtnVoltar().addActionListener(this);
		ajuda.getBtnAvancar().addActionListener(this);
		ajudaFase.getBtnVoltar().addActionListener(this);
		stage.getBtnVoltar().addActionListener(this);
		creditos.getBtnVoltar().addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ajuda.getBtnVoltar()) {
			MudarTela(menu, ajuda);

		}
		if (e.getSource() == ajuda.getBtnAvancar()) {
			MudarTela(ajudaFase, ajuda);

		}
		if (e.getSource() == ajudaFase.getBtnVoltar()) {
			MudarTela(ajuda, ajudaFase);

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
		if (e.getSource() == creditos.getBtnVoltar()) {
			MudarTela(menu, creditos);

		}
		if (e.getSource() == menu.getJogar()) {
			MudarTela(entrada, menu);

		}
		if (e.getSource() == menu.getCreditos()) {
			MudarTela(creditos, menu);
		}
		if (e.getSource() == menu.getAjuda()) {
			MudarTela(ajuda, menu);
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
			if (movimento.getLista().size() < 25) {
				movimento.addMovimento("right");
				mudarSeta("right");
			}

		}
		if (e.getSource() == componentes.getBtnLeft()) {
			if (movimento.getLista().size() < 25) {
				movimento.addMovimento("left");
				mudarSeta("left");
			}

		}

		if (e.getSource() == componentes.getBtnUp()) {
			if (movimento.getLista().size() < 25) {
				movimento.addMovimento("up");
				mudarSeta("up");
			}

		}
		if (e.getSource() == componentes.getBtn180()) {

			if (movimento.getLista().size() < 25) {
				movimento.addMovimento("giro");
				mudarSeta("180");
			}

		}
		if (e.getSource() == componentes.getBtnChutar()) {
			if (movimento.getLista().size() < 25) {
				movimento.addMovimento("chutar");
				componentes.addComando("chute");
			}

		}

		if (e.getSource() == componentes.getBtnPlay()) {

			if ((movimento.getLista().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Voce nao adicionou comandos");
			} else {
				if (movimento.getLista().get(movimento.getLista().size() - 1).getDirecao().equals("chutar")) {
					try {
						movimento.Play();
					} catch (java.util.ConcurrentModificationException e2) {
						System.out.println("erro de concorrencia");
					}

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

				posicionarA();

			}
			if (movimento != null) {
				if (movimento.isForaAlvo()) {
					System.out.println("vc não ésta no alvo");
					reiniciar();
					posicionarA();
					movimento.setForaAlvo(false);
				}
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

		componentes.getPainelFase().setBounds(20, 95, 750, 512);

		if (componentes.getPainelFase().getComponents().length == 0) {

			componentes.getPainelFase().add(fase);
			this.personagem = fase.getPersonagem();
			this.movimento = new Movimento(personagem, fase, audio, componentes);
		}
		componentes.getPainelFase().setVisible(false);
		componentes.getPainelFase().setVisible(true);
		reiniciar();
		janela.TamanhoFase();
		audio.getMusica().stop();
		MudarTela(componentes, stage);

		switch (estado) {
		case 1: {
			fase.setarColisao(fase.getColisao1());
			fase.setarMapa(fase.getCaminho1());
			controlador = 1;
			fase.getTrave().mudarIcone(1);
			posicionarA();
			fase.getAlvo().mudarA();

			break;
		}
		case 2: {

			fase.setarColisao(fase.getColisao2());
			fase.setarMapa(fase.getCaminho2());
			controlador = 2;
			fase.getTrave().mudarIcone(1);
			posicionarA();
			fase.getAlvo().mudarA();
			break;
		}
		case 3: {

			fase.setarColisao(fase.getColisao3());
			fase.setarMapa(fase.getCaminho3());
			controlador = 3;
			fase.getTrave().mudarIcone(1);
			posicionarA();
			fase.getAlvo().mudarA();
			break;
		}
		case 4: {

			fase.setarColisao(fase.getColisao4());
			fase.setarMapa(fase.getCaminho4());
			controlador = 4;
			fase.getTrave().mudarIcone(2);
			posicionarA();
			fase.getAlvo().mudarB();

			break;
		}
		case 5: {

			fase.setarColisao(fase.getColisao5());
			fase.setarMapa(fase.getCaminho5());
			controlador = 5;
			fase.getTrave().mudarIcone(2);
			posicionarA();
			fase.getAlvo().mudarB();

			break;
		}
		case 6: {

			fase.setarColisao(fase.getColisao6());
			fase.setarMapa(fase.getCaminho6());
			controlador = 5;
			fase.getTrave().mudarIcone(2);
			posicionarA();
			fase.getAlvo().mudarB();
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
		Bola.getBolas().clear();
		componentes.setarIconeCima();
		componentes.getPainelArea().removeAll();
		componentes.setIndice(0);

		posicionarA();

		movimento.getLista().clear();
	}

	public void menu() {
		componentes.getPainelFase().setBounds(1000, 0, 708, 448);
		componentes.getPainelArea().removeAll();
		janela.TamanhoMenu();
	}

	private void mudarSeta(String direcao) {

		if (direcao.equals("180")) {

			if (aparencia == 8) {
				aparencia = 2;
				componentes.setarIconeEsquerda();

			} else if (aparencia == 2) {
				aparencia = 8;
				componentes.setarIconeDireita();

			} else if (aparencia == 1) {
				aparencia = 0;
				componentes.setarIconeBaixo();
				System.out.println("mudou a seta");

			} else if (aparencia == 0) {
				aparencia = 1;
				componentes.setarIconeCima();
			}
			componentes.addComando("180");
			componentes.repaint();

		} else if (direcao.equals("right")) {

			if (aparencia == 0) {
				aparencia = 2;
				componentes.setarIconeEsquerda();

			} else if (aparencia == 2) {
				aparencia = 1;
				componentes.setarIconeCima();

			} else if (aparencia == 1) {
				aparencia = 8;
				componentes.setarIconeDireita();

			} else if (aparencia == 8) {
				aparencia = 0;
				componentes.setarIconeBaixo();
			}
			componentes.addComando("direita");

		} else if (direcao.equals("left")) {

			if (aparencia == 0) {
				aparencia = 8;
				componentes.setarIconeDireita();

			} else if (aparencia == 8) {
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
			} else if (aparencia == 8) {

				componentes.addComando("Di");
			} else if (aparencia == 1) {

				componentes.addComando("cima");
			} else if (aparencia == 2) {
				componentes.addComando("Es");
			}

		}

	}

	private void apagarComando() {

		int tamanho = movimento.getLista().size() - 1;

		if (movimento.getLista().get(tamanho).getDirecao().equals("giro")) {

			if (aparencia == 0) {
				aparencia = 1;
				componentes.setarIconeCima();

			} else if (aparencia == 1) {
				aparencia = 0;
				componentes.setarIconeBaixo();

			} else if (aparencia == 2) {
				aparencia = 8;
				componentes.setarIconeDireita();

			} else if (aparencia == 8) {
				aparencia = 2;
				componentes.setarIconeEsquerda();
			}

			componentes.repaint();

		} else if (movimento.getLista().get(tamanho).getDirecao().equals("right")) {

			if (aparencia == 0) {
				aparencia = 8;
				componentes.setarIconeDireita();

			} else if (aparencia == 8) {
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
				aparencia = 8;
				componentes.setarIconeDireita();

			} else if (aparencia == 8) {
				aparencia = 0;
				componentes.setarIconeBaixo();
			}

		}
		movimento.getLista().remove(tamanho);
	}

	public void posicionarA() {
		personagem.setX(128);
		personagem.setY(320);
		personagem.aparencia = 1;
		aparencia = 1;
	}

}
