package Control;

import Model.Sprite;

public class Esquerda implements Runnable{
	
	Sprite personagem;
	int up, down, left, right = 0;
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
				System.out.println("esquerda");
		esquerda();
				Thread.sleep(300);
			} catch (InterruptedException e) {
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
			ativo = false;
		else
			left++;
		
		if(contador==44) {
			ativo=false;
			contador=0;
			personagem.aparencia = 2;
		}
	}

	public boolean isAtivo() {
		return ativo;
	}


}