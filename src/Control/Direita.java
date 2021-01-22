package Control;

import Model.Sprite;

public class Direita implements Runnable {

	Sprite personagem;
	int  right = 0;
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
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void direita() {

		personagem.setX(personagem.getX() + 4);
		contador += 4;

		switch (right) {
		case 0:
			personagem.aparencia = 3;
			break;
		case 1:
			personagem.aparencia = 7;
			break;
		case 2:
			personagem.aparencia = 11;
			break;
		case 3:
			personagem.aparencia = 15;
			break;

		}
		if (right == 3)
			right = 0;
		else
			right++;

		if (contador == 40) {
			ativo = false;
			contador=0;
			personagem.aparencia = 7;
		}
	}

	public boolean isAtivo() {
		return ativo;
	}

}
