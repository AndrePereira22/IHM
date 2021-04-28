package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import View.Ajuda;
import View.AjudaFase;
import View.Creditos;
import View.Janela;
import View.Menu;
import View.Opcao;
import View.Stage;

public class ControleMenu implements ActionListener {


	private Janela janela;

	private Opcao opcao;
	private Menu menu;
	private Creditos creditos;
	private Ajuda ajuda;
	private AjudaFase ajudaFase;
	private Stage stage;
	
	
	public ControleMenu(Janela janela) {
		this.janela = janela;
		this.menu = janela.getMenu();
		this.opcao = janela.getOpcao();

		this.creditos = janela.getCreditos();
		this.ajuda = janela.getAjuda();
		this.ajudaFase = janela.getAjudaFase();
		this.stage = janela.getStage();
		
		
		menu.getJogar().addActionListener(this);
		menu.getSair().addActionListener(this);
		menu.getAjuda().addActionListener(this);
		menu.getCreditos().addActionListener(this);
		opcao.getBtnIniciar().addActionListener(this);
		stage.getBtnVoltar().addActionListener(this);
		opcao.getBtnVoltar().addActionListener(this);
		ajuda.getBtnVoltar().addActionListener(this);
		ajuda.getBtnAvancar().addActionListener(this);
		ajudaFase.getBtnVoltar().addActionListener(this);
		creditos.getBtnVoltar().addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
	
		
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
		if (e.getSource() == opcao.getBtnIniciar()) {
			if(opcao.getTxtJogador().getText().isEmpty() || opcao.getTxtIdade().getText().isEmpty())
				opcao.getLblAviso().setVisible(true);
			else
				MudarTela(stage, opcao);
		}
		if (e.getSource() == ajuda.getBtnVoltar()) {
			MudarTela(menu, ajuda);

		}
		if (e.getSource() == ajuda.getBtnAvancar()) {
			MudarTela(ajudaFase, ajuda);

		}
		if (e.getSource() == ajudaFase.getBtnVoltar()) {
			MudarTela(ajuda, ajudaFase);

		}
		if (e.getSource() == stage.getBtnVoltar()) {
			MudarTela(opcao, stage);

		}
		if (e.getSource() == creditos.getBtnVoltar()) {
			MudarTela(menu, creditos);

		}

		if (e.getSource() == opcao.getBtnVoltar()) {
			MudarTela(menu, opcao);

		}
	}
	public void MudarTela(JPanel aparece, JPanel some) {
		aparece.setVisible(true);
		some.setVisible(false);

	}
}
