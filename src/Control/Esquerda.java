package Control;

import Model.Sprite;
import View.Fase;
import View.PraFora;

public class Esquerda implements Runnable {

	Sprite personagem;
	int left;
	boolean ativo = false;
	int contador = 0;
	private PraFora fora;

	public Esquerda(Sprite player1,PraFora fora) {
		this.personagem = player1;
		this.fora=fora;
	}

	@Override
	public void run() {
		ativo = true;
		while (ativo) {

			try {

				esquerda();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("parou esquerda");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void esquerda() {
		if (!personagem.colisao(Fase.getRetangulosColisao(), 0, 0)) {
			personagem.setX(personagem.getX() - 4);
			contador += 4;

			switch (left) {
			case 0:
				personagem.aparencia = 2;
				break;
			case 1:
				personagem.aparencia = 7;
				break;
			case 2:
				personagem.aparencia = 12;
				break;
			case 3:
				personagem.aparencia = 17;
				break;

			}
			if (left == 3)
				left = 0;
			else
				left++;

			if (contador == 64) {
				pararMovimento();
			}
		} else {
			pararPelaColisao();
		}
	}

	public void pararMovimento() {
		ativo = false;
		contador = 0;
		personagem.aparencia = 2;
	}

	public void pararPelaColisao() {
		reiniciar();
		ativo = false;
		contador = 0;
		personagem.aparencia = 2;
		personagem.setX(personagem.getX() + 2);

	}
	public void reiniciar() {
		personagem.setX(personagem.getPonto().x);
		personagem.setY(personagem.getPonto().y);


	}

	public boolean isAtivo() {
		return ativo;
	}

}
