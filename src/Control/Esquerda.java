package Control;

import Model.Sprite;

public class Esquerda implements Runnable{
	
	Sprite personagem;
	int left;
	boolean ativo = false;
	int contador =0;
	
	public Esquerda(Sprite player1) {
		this.personagem = player1;
	}

	@Override
	public void run() {
		ativo = true;
		while(ativo) {
			
			try {

				esquerda();
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println("parou esquerda");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void esquerda() {

		personagem.setX(personagem.getX() - 4);
		contador+=4;

		switch (left) {
		case 0:
			personagem.aparencia = 2;
			break;
		case 1:
			personagem.aparencia = 6;
			break;
		case 2:
			personagem.aparencia = 10;
			break;
		case 3:
			personagem.aparencia = 14;
			break;

		}
		if (left == 3)
			left=0;
		else
			left++;
		
		if(contador==40) {
			ativo=false;
			contador=0;
			personagem.aparencia = 2;
		}
	}

	public boolean isAtivo() {
		return ativo;
	}


}
