package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Janela extends JFrame {

	private Menu menu;
	private Componente componentes;
	private Opcao opcao;
	private Entrada entrada;
	private Fase fase;
	

		public Janela(int largura,int altura) {
			
			setPreferredSize(new Dimension(largura, altura));
			setLayout(new FlowLayout());
			
			setSize(largura, altura);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			//setUndecorated(true);
			
			
			menu =  new Menu(800,600);
			componentes = new Componente(700,650);
			opcao = new Opcao(800, 600);
			//comandos = new Comandos(615,100);
			entrada = new Entrada(800, 600);
			fase = new Fase();
			opcao.setVisible(false);
		//	comandos.setVisible(false);
			componentes.setVisible(false);
			componentes.getPainelFase().add(fase);
			
			add(entrada);
			add(menu);
			add(opcao);
			add(componentes);
		
			
			  
			Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("baseDados\\caverna.png");
			this.setIconImage(iconeTitulo);
		
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
		setSize(700,650);
	}
	public void TamanhoMenu() {
		setSize(800,600);
	}


	public Fase getFase() {
		return fase;
	}


	public Entrada getEntrada() {
		return entrada;
	}
	
	
}
