package Control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Audio;
import Model.Bola;
import Model.Sprite;
import View.Componente;
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
	private Stage stage;
	private Bola bola;
	private Sprite personagem;
	private Movimento movimento;
	private int indice = 0, faseAtual = 0;
	private boolean menino = false;;
	private int[] posXLabel = { 10, 42, 74, 106, 10, 42, 74, 106, 10, 42, 74, 106, 10, 42, 74, 106, 10, 42, 74, 106 };
	private int[] posYLabel = { 5, 5, 5, 5, 46, 46, 46, 46, 91, 91, 91, 91, 136, 136, 136, 136, 181, 181, 181, 181 };

	public Controle(Janela janela) {

		this.janela = janela;
		this.componentes = janela.getComponentes();
		this.menu = janela.getMenu();
		this.audio = new Audio();
		this.opcao = janela.getOpcao();
		this.entrada = janela.getEntrada();
		this.stage=janela.getStage();
		audio.getMusica().loop(100);
		controleEventos();

		janela.setVisible(true);
	}

	public void controleEventos() {

		menu.getJogar().addActionListener(this);
		menu.getSair().addActionListener(this);
		menu.getAjuda().addActionListener(this);
		opcao.getBtnIniciar().addActionListener(this);
		opcao.getBtnMenina().addActionListener(this);
		opcao.getBtnMenino().addActionListener(this);
		componentes.getBtnRight().addActionListener(this);
		componentes.getBtnLeft().addActionListener(this);
		componentes.getBtnUp().addActionListener(this);
		componentes.getBtn180().addActionListener(this);
		componentes.getBtnChutar().addActionListener(this);
		componentes.getBtnPlay().addActionListener(this);
		componentes.getBtnRepetir().addActionListener(this);
		componentes.getBtnApagarSequencia().addActionListener(this);
		stage.getBtnFase1().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == menu.getJogar()) {
			MudarTela(entrada, menu);

		}
		
		if (e.getSource() == stage.getBtnFase1()) {
			
		iniciar();

		}
		if (e.getSource() == opcao.getBtnIniciar()) {


			MudarTela(stage, opcao);
		}
		if (e.getSource() == opcao.getBtnMenina()) {

			menino = false;
		}
		if (e.getSource() == opcao.getBtnMenino()) {
			menino = true;

		}
		if (e.getSource() == componentes.getBtnRepetir()) {

			if (movimento.getLista().size() > 0) {
				addUltimo();
				addComando("loop");
			}

		}
		if (e.getSource() == componentes.getBtnRight()) {

			movimento.addMovimento("right");
			addComando("direita");

		}
		if (e.getSource() == componentes.getBtnLeft()) {

			movimento.addMovimento("left");
			addComando("esquerda");

		}

		if (e.getSource() == componentes.getBtnUp()) {

			movimento.addMovimento("up");
			addComando("cima");

		}
		if (e.getSource() == componentes.getBtn180()) {

			movimento.addMovimento("giro");
			addComando("180");

		}
		if (e.getSource() == componentes.getBtnChutar()) {

			movimento.addMovimento("chutar");
			addComando("chute");

		}

		if (e.getSource() == componentes.getBtnPlay()) {

			if (movimento.getLista().get(movimento.getLista().size() - 1).getDirecao().equals("chutar")) {

				movimento.Play();
			} else {
				JOptionPane.showMessageDialog(null, "Adiciono o comando de chutar no final.");
			}

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

	public void addComando(String direcao) {
		if (movimento.getLista().size() < 21) {
			JLabel label = new JLabel();

			label.setIcon(new ImageIcon(getClass().getResource("/" + direcao + ".png")));
			label.setBounds(posXLabel[indice], posYLabel[indice], 30, 30);
			componentes.getPainelArea().add(label);

			indice++;
			setVisible();

		}

	}

	public void removerComando() {
		int tamanho = movimento.getLista().size();

		if (tamanho > 0) {

			Component label = componentes.getPainelArea().getComponent(tamanho - 1);

			componentes.getPainelArea().remove(label);

			indice--;

			movimento.getLista().remove(tamanho - 1);
			setVisible();

		}

	}

	public void restar() {
		for (Component label : componentes.getPainelArea().getComponents()) {
			JLabel img = (JLabel) label;

			img.setVisible(false);
		}
		movimento.getLista().clear();
	}

	public void mudarFase() {

		faseAtual++;


	}
	public void Iniciar() {
		
	}

	public void addUltimo() {

		int tamanho = movimento.getLista().size();
		String comando = movimento.getLista().get(tamanho - 1).getDirecao();
		movimento.addMovimento(comando);

	}
	public void iniciar() {
		if (menino) {
			this.fase = new Fase("sprite1.png");
		} else {
			this.fase = new Fase("sprite2.png");
		}

		componentes.getPainelFase().add(fase);
		this.bola = fase.getBola();
		this.personagem = fase.getPersonagem();
		this.movimento = new Movimento(personagem, fase,audio);
		
		janela.TamanhoFase();
		audio.getMusica().stop();
		MudarTela(componentes, stage);
	}

	public void setVisible() {
		componentes.getPainelArea().repaint();

	}

}
