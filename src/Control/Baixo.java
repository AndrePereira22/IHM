package Control;

import Model.Sprite;
import View.Fase;
import View.PraFora;

public class Baixo implements Runnable {

	Sprite personagem;
	int up, down, left, right = 0;
	boolean ativo = true;
	int contador = 0;
	public Baixo(Sprite player1, PraFora fora) {
		this.personagem = player1;
	}

	@Override
	public void run() {
		ativo = true;
		while (ativo) {
			try {
				baixo();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void baixo() {

		if (!personagem.colisao(Fase.getRetangulosColisao(), 0, 0)) {

			personagem.setY(personagem.getY() + 4);
			contador += 4;

			switch (down) {
			case 0:
				personagem.aparencia = 0;
				break;
			case 1:
				personagem.aparencia = 5;
				break;
			case 2:
				personagem.aparencia = 10;
				break;
			case 3:
				personagem.aparencia = 15;
				break;

			}
			if (down == 3)
				down = 0;
			else
				down++;

			if (contador == 64) {
				pararMovimento();
			}
		} 
	}

	public void pararMovimento() {
		ativo = false;
		contador = 0;
		personagem.aparencia = 0;
	}



	public boolean isAtivo() {
		return ativo;
	}

	

}
