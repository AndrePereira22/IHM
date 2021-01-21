package Control;

import Model.Sprite;

public class Frente implements Runnable {

	Sprite personagem;
	int up, down, left, right = 0;
	boolean ativo = true;
	int contador = 0;

	public Frente(Sprite player1) {
		this.personagem = player1;
	
	}

	@Override
	public void run() {
		ativo = true;
		while (ativo) {
			try {
				cima();
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void cima() {

		personagem.setY(personagem.getY() - 4);
		contador += 4;

		switch (up) {
		case 0:
			personagem.aparencia = 1;
			break;
		case 1:
			personagem.aparencia = 5;
			break;
		case 2:
			personagem.aparencia = 9;
			break;
		case 3:
			personagem.aparencia = 13;
			break;

		}
		if (up == 3)
			up = 0;
		else
			up++;

		if (contador == 36) {
			ativo = false;
			contador=0;
			personagem.aparencia = 1;
		}
	}

	public boolean isAtivo() {
		return ativo;
	}

}
