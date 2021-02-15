package Aplicacao;

import Control.Controle;
import View.Janela;

public class Aplicacao {

	public static void main(String[] args) {

		Janela janela = new Janela(800, 590);
		new Controle(janela).run();

	}

}
