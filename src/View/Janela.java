package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Janela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3338597443822445438L;
	private Menu menu;
	private Componente componentes;
	private Opcao opcao;
	private Entrada entrada;
	private Fase fase;
	private Stage stage;
	private Creditos creditos;
	private Ajuda ajuda;
	private AjudaFase ajudaFase;

	public Janela(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(new FlowLayout());

		setSize(largura, altura);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
	
		creditos = new Creditos(800, 600);
		menu = new Menu(800, 600);
		componentes = new Componente(1000, 700);
		ajuda = new Ajuda(800, 600);
		ajudaFase = new AjudaFase(800, 600);
		
		opcao = new Opcao(800, 600);
		this.stage = new Stage(800,600);

		entrada = new Entrada(800, 600);
		opcao.setVisible(false);
		componentes.setVisible(false);
		
		

		add(entrada);
		add(menu);
		add(creditos);
		add(ajuda);
		add(ajudaFase);
		add(opcao);
		add(stage);
		add(componentes);

		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("baseDados\\caverna.png");
		this.setIconImage(iconeTitulo);
		this.setVisible(true);

	}

	public Menu getMenu() {
		return menu;
	}

	public Componente getComponentes() {
		return componentes;
	}

	public Opcao getOpcao() {
		return opcao;
	}

	public void TamanhoFase() {
		setSize(1000, 700);
	}

	public void TamanhoMenu() {
		setSize(790, 600);
	}

	public Fase getFase() {
		return fase;
	}

	public Creditos getCreditos() {
		return creditos;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public Stage getStage() {
		return stage;
	}

	public Ajuda getAjuda() {
		return ajuda;
	}

	public AjudaFase getAjudaFase() {
		return ajudaFase;
	}

}
