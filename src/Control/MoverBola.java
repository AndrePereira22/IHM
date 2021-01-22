package Control;

import Model.Bola;
import Model.Sprite;

public class MoverBola implements Runnable {

	Bola bola;

	boolean ativo = true;

	public MoverBola(Bola bola) {
		this.bola = bola;
	}

	@Override
	public void run() {
		ativo = true;
		while (ativo) {
			try {

				mover();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void mover() {


		bola.setX(bola.getX() + 2);
		if(bola.getX()>360) ativo=false;
		

	}

	public boolean isAtivo() {
		return ativo;
	}

}
