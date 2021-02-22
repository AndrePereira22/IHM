package Control;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Model.Audio;
import Model.Bola;
import Model.Mapa;
import Model.Sprite;
import Model.Trave;
import View.Ajuda;
import View.AjudaFase;
import View.Componente;
import View.Creditos;
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
	// private Entrada entrada;
	private Creditos creditos;
	private Ajuda ajuda;
	private AjudaFase ajudaFase;
	private Stage stage;
	private Sprite personagem;
	private Movimento movimento;
	private boolean brasil = false;
	private boolean gol = false;
	public static int aparencia = 1;
	private int controlador;

	private Mapa caminho1, caminho2, caminho3, caminho4, caminho5, caminho6;
	private Mapa colisao1, colisao2, colisao3, colisao4, colisao5, colisao6;

	public Controle(Janela janela) {

		this.janela = janela;
		this.componentes = janela.getComponentes();
		this.menu = janela.getMenu();
		this.audio = new Audio();
		this.opcao = janela.getOpcao();
		// this.entrada = janela.getEntrada();
		this.creditos = janela.getCreditos();
		this.ajuda = janela.getAjuda();
		this.ajudaFase = janela.getAjudaFase();
		this.stage = janela.getStage();

		caminho1 = new Mapa("c.png", "caminho1.txt");
		caminho2 = new Mapa("c.png", "caminho2.txt");
		caminho3 = new Mapa("c.png", "caminho3.txt");
		caminho4 = new Mapa("c.png", "caminho4.txt");
		caminho5 = new Mapa("c.png", "caminho5.txt");
		caminho6 = new Mapa("c.png", "caminho6.txt");

		colisao1 = new Mapa("c.png", "colisao1.txt");
		colisao2 = new Mapa("c.png", "colisao2.txt");
		colisao3 = new Mapa("c.png", "colisao3.txt");
		colisao4 = new Mapa("c.png", "colisao4.txt");
		colisao5 = new Mapa("c.png", "colisao5.txt");
		colisao6 = new Mapa("c.png", "colisao6.txt");

		audio.getSndmusica().loop();
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
		componentes.getBtnRestart().addActionListener(this);

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
		if (e.getSource() == componentes.getBtnRestart()) {
			System.exit(0);

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
			MudarTela(opcao, menu);

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
			MudarTela(componentes, stage);
			iniciar(6);

		}
		if (e.getSource() == stage.getBtnFase5()) {
			MudarTela(componentes, stage);
			iniciar(5);

		}
		if (e.getSource() == stage.getBtnFase4()) {
			MudarTela(componentes, stage);
			iniciar(4);

		}
		if (e.getSource() == stage.getBtnFase3()) {
			MudarTela(componentes, stage);
			iniciar(3);

		}

		if (e.getSource() == stage.getBtnFase2()) {
			MudarTela(componentes, stage);
			iniciar(2);

		}

		if (e.getSource() == stage.getBtnFase1()) {
			MudarTela(componentes, stage);
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
				componentes.mudarSize(movimento.getLista().size());
			} else {
				componentes.ErrouAcao();
			}

		}
		if (e.getSource() == componentes.getBtnLeft()) {
			if (movimento.getLista().size() < 25) {
				movimento.addMovimento("left");
				mudarSeta("left");
				componentes.mudarSize(movimento.getLista().size());
			} else {
				componentes.ErrouAcao();
			}

		}

		if (e.getSource() == componentes.getBtnUp()) {
			if (movimento.getLista().size() < 25) {
				movimento.addMovimento("up");
				mudarSeta("up");
				componentes.mudarSize(movimento.getLista().size());
			} else {
				componentes.ErrouAcao();
			}

		}
		if (e.getSource() == componentes.getBtn180()) {

			if (movimento.getLista().size() < 25) {
				movimento.addMovimento("giro");
				mudarSeta("180");
				componentes.mudarSize(movimento.getLista().size());
			} else {
				componentes.ErrouAcao();
			}

		}
		if (e.getSource() == componentes.getBtnChutar()) {
			if (movimento.getLista().size() < 25) {
				movimento.addMovimento("chutar");
				componentes.addComando("chute");
				componentes.mudarSize(movimento.getLista().size());
			} else {
				componentes.ErrouAcao();
			}

		}

		if (e.getSource() == componentes.getBtnPlay()) {

			if ((movimento.getLista().isEmpty())) {
				componentes.ErrouAcao();

			} else {
				if (movimento.getLista().get(movimento.getLista().size() - 1).getDirecao().equals("chutar")) {
					try {
						movimento.Play();
					} catch (java.util.ConcurrentModificationException e2) {

					}

				} else {
					componentes.ErrouChutar();
				}
			}

		}
		if (e.getSource() == componentes.getBtnApagarSequencia()) {
			if (componentes.removerComando()) {
				apagarComando();
			} else {
				componentes.ErrouAcao();
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

//		if (entrada.isVisible()) {
//			try {
//				Thread.sleep(5000);
//				MudarTela(opcao, entrada);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

		if (fase != null && fase.isVisible()) {
			gol(0, 0);
			saidaDaBola();
		}

		if (fase != null) {

			if (personagem.colisao(Fase.getRetangulosColisao(), 0, 0)) {

				reiniciar();

			}

		}
		if (componentes.isVisible()) {
			if (!componentes.getLblDefault().isVisible()) {
				try {
					Thread.sleep(3000);

					componentes.ErrouDefault();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (gol) {
			componentes.gol();
			audio.getSndgol().play();
			try {
				Thread.sleep(13000);
				foiGol();
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

	public void iniciar(int estado) {
		janela.TamanhoFase();

		audio.getSndmusica().stop();
		MudarTela(componentes, stage);
		componentes.getLblJogador().setText("JOGADOR: " + opcao.getTxtJogador().getText());

		switch (estado) {
		case 1: {

			if (brasil) {
				this.fase = new Fase("sprite1.png", caminho1, colisao1);

			} else {
				this.fase = new Fase("sprite2.png", caminho1, colisao1);
			}
			componentes.getPainelFase().setBounds(20, 95, 750, 512);
			if (componentes.getPainelFase().getComponents().length == 0) {
				componentes.getPainelFase().add(fase);
				this.personagem = fase.getPersonagem();
				this.movimento = new Movimento(personagem, fase, audio, componentes);
			}
			controlador = 1;
			fase.getTrave().mudarIcone(1);

			fase.getAlvo().mudarA();
			componentes.getLblFase().setText("FASE 1");
			reiniciar();
			break;
		}
		case 2: {

			if (brasil) {
				this.fase = new Fase("sprite1.png", caminho2, colisao2);

			} else {
				this.fase = new Fase("sprite2.png", caminho2, colisao2);
			}
			componentes.getPainelFase().setBounds(20, 95, 750, 512);
			if (componentes.getPainelFase().getComponents().length == 0) {
				componentes.getPainelFase().add(fase);
				this.personagem = fase.getPersonagem();
				this.movimento = new Movimento(personagem, fase, audio, componentes);
			}
			controlador = 2;
			fase.getTrave().mudarIcone(1);

			fase.getAlvo().mudarA();
			componentes.getLblFase().setText("FASE 2");
			reiniciar();
			break;
		}
		case 3: {

			if (brasil) {
				this.fase = new Fase("sprite1.png", caminho3, colisao3);

			} else {
				this.fase = new Fase("sprite2.png", caminho3, colisao3);
			}
			componentes.getPainelFase().setBounds(20, 95, 750, 512);
			if (componentes.getPainelFase().getComponents().length == 0) {
				componentes.getPainelFase().add(fase);
				this.personagem = fase.getPersonagem();
				this.movimento = new Movimento(personagem, fase, audio, componentes);
			}
			controlador = 3;
			fase.getTrave().mudarIcone(1);
			fase.getAlvo().mudarA();
			componentes.getLblFase().setText("FASE 3");

			break;
		}
		case 4: {
			if (brasil) {
				this.fase = new Fase("sprite1.png", caminho4, colisao4);

			} else {
				this.fase = new Fase("sprite2.png", caminho4, colisao4);
			}
			componentes.getPainelFase().setBounds(20, 95, 750, 512);
			if (componentes.getPainelFase().getComponents().length == 0) {
				componentes.getPainelFase().add(fase);
				this.personagem = fase.getPersonagem();
				this.movimento = new Movimento(personagem, fase, audio, componentes);
			}
			controlador = 4;
			fase.getTrave().mudarIcone(2);

			fase.getAlvo().mudarB();
			componentes.getLblFase().setText("FASE 4");
			break;
		}
		case 5: {

			if (brasil) {
				this.fase = new Fase("sprite1.png", caminho5, colisao5);

			} else {
				this.fase = new Fase("sprite2.png", caminho5, colisao5);
			}
			componentes.getPainelFase().setBounds(20, 95, 750, 512);
			if (componentes.getPainelFase().getComponents().length == 0) {
				componentes.getPainelFase().add(fase);
				this.personagem = fase.getPersonagem();
				this.movimento = new Movimento(personagem, fase, audio, componentes);
			}
			controlador = 5;
			fase.getTrave().mudarIcone(2);
			fase.getAlvo().mudarB();
			componentes.getLblFase().setText("FASE 5");
			break;
		}
		case 6: {

			if (brasil) {
				this.fase = new Fase("sprite1.png", caminho6, colisao6);

			} else {
				this.fase = new Fase("sprite2.png", caminho6, colisao6);
			}
			componentes.getPainelFase().setBounds(20, 95, 750, 512);
			if (componentes.getPainelFase().getComponents().length == 0) {
				componentes.getPainelFase().add(fase);
				this.personagem = fase.getPersonagem();
				this.movimento = new Movimento(personagem, fase, audio, componentes);
			}
			controlador = 5;
			fase.getTrave().mudarIcone(2);

			fase.getAlvo().mudarB();
			componentes.getLblFase().setText("FASE 6");
			break;
		}
		}

		componentes.getPainelFase().setVisible(false);
		componentes.getPainelFase().setVisible(true);
		fase.setVisible(false);
		fase.setVisible(true);
	}

	public void saidaDaBola() {

		for (int i = 0; i < Bola.getBolas().size(); i++) {

			Bola bola = Bola.getBolas().get(i);

			if (bola.getX() < 10 || bola.getX() > 764 || bola.getY() < 10 || bola.getY() > 512) {
				bola.setVisivel(false);
				audio.getSndErro().play();
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
				b.setVisivel(false);
				gol = true;
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
		componentes.getPainelFase().setVisible(false);
		componentes.getPainelFase().setVisible(true);
		fase.setVisible(false);
		fase.setVisible(true);
	}

	public void reiniciar() {
		Bola.getBolas().clear();
		componentes.setarIconeCima();
		componentes.getPainelArea().removeAll();
		componentes.setIndice(0);
		movimento.getLista().clear();
		personagem.setX(128);
		personagem.setY(320);
		personagem.aparencia = 1;
		aparencia = 1;
		componentes.mudarSize(movimento.getLista().size());
		componentes.getPainelArea().repaint();
	}

	public void menu() {
		componentes.getPainelFase().setBounds(1000, 0, 708, 448);
		componentes.getPainelArea().removeAll();
		componentes.getPainelFase().remove(fase);
		componentes.getPainelFase().validate();
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
		componentes.mudarSize(movimento.getLista().size());

	}

	public void foiGol() {

		componentes.gol();
		menu();
		MudarTela(stage, componentes);
		liberarFase();
		reiniciar();
		audio.getSndgol().stop();
		gol = false;

		componentes.ErrouDefault();
	}
}
