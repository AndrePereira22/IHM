package Control;

import Model.Sprite;

public class Baixo implements Runnable {

	Sprite personagem;
	int up, down, left, right = 0;
	boolean ativo = true;
	int contador = 0;

	public Baixo(Sprite player1) {
		this.personagem = player1;
	}

	@Override
	public void run() {
		ativo = true;
		while (ativo) {
			try {
				baixo();
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void baixo() {

		personagem.setY(personagem.getY() + 4);
		contador += 4;

		switch (down) {
		case 0:
			personagem.aparencia = 0;
			break;
		case 1:
			personagem.aparencia = 4;
			break;
		case 2:
			personagem.aparencia = 8;
			break;
		case 3:
			personagem.aparencia = 12;
			break;

		}
		if (down == 3)
			down = 0;
		else
			down++;

		if (contador == 36) {
			ativo = false;
			contador=0;
			personagem.aparencia = 0;
		}
	}

	public boolean isAtivo() {
		return ativo;
	}

}
