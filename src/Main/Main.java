package Main;

import Control.Controle;
import View.Janela;

public class Main {

	public static void main(String[] args) {

		Janela janela = new Janela(800, 590);
		Controle controle = new Controle(janela);
		controle.run();

	}

}
