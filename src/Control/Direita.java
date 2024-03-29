package Control;

import Model.Sprite;
import View.Fase;

public class Direita implements Runnable {

	Sprite personagem;
	int right = 0;
	boolean ativo = true;
	int contador = 0;
	public Direita(Sprite player1) {
		this.personagem = player1;
	}

	@Override
	public void run() {
		ativo = true;
		while (ativo) {
			try {

				direita();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void direita() {
		if (!personagem.colisao(Fase.getRetangulosColisao(), 0, 0) ) {
			personagem.setX(personagem.getX() + 4);
			contador += 4;

			switch (right) {
			case 0:
				personagem.aparencia = 3;
				break;
			case 1:
				personagem.aparencia = 8;
				break;
			case 2:
				personagem.aparencia = 13;
				break;
			case 3:
				personagem.aparencia = 18;
				break;

			}
			if (right == 3)
				right = 0;
			else
				right++;

			if (contador == 64) {
				pararMovimento();
			}
		} 
	}

	public void pararMovimento() {
		ativo = false;
		contador = 0;
		personagem.aparencia = 8;
	}

	public void reiniciar() {
		personagem.setX(personagem.getPonto().x);
		personagem.setY(personagem.getPonto().y);


	}

	public boolean isAtivo() {
		return ativo;
	}

}
