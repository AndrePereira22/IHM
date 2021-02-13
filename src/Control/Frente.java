package Control;

import java.util.ArrayList;
import java.util.List;

import Model.Alvo;
import Model.Sprite;
import View.Fase;
import View.PraFora;

public class Frente implements Runnable {

	Sprite personagem;
	int up, down, left, right = 0;
	boolean ativo = true;
	int contador = 0;
	private PraFora fora;
	Fase fase;

	public Frente(Sprite player1, PraFora fora, Fase fase) {
		this.personagem = player1;
		this.fora = fora;
		this.fase = fase;

	}

	@Override
	public void run() {
		ativo = true;
		while (ativo) {
			try {
				cima();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void cima() {
		if (!personagem.colisao(Fase.getRetangulosColisao(), 0, 0)) {
			personagem.setY(personagem.getY() - 4);
			contador += 4;

			switch (up) {
			case 0:
				personagem.aparencia = 1;
				break;
			case 1:
				personagem.aparencia = 6;
				break;
			case 2:
				personagem.aparencia = 11;
				break;
			case 3:
				personagem.aparencia = 16;
				break;

			}
			if (up == 3)
				up = 0;
			else
				up++;

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
		personagem.aparencia = 1;

	
	}

	public void pararPelaColisao() {
		reiniciar();
		ativo = false;
		contador = 0;
		personagem.aparencia = 1;
		personagem.setY(personagem.getY() + 2);

	}



	public void reiniciar() {
		personagem.setX(personagem.getPonto().x);
		personagem.setY(personagem.getPonto().y);


	}

	public boolean isAtivo() {
		return ativo;
	}

}
