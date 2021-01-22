package Control;

import Model.Bola;
import Model.Sprite;

public class MoverBola implements Runnable {

	private Bola bola;

	private boolean ativo = true;

	private String direcao = "";

	public MoverBola(Bola bola) {
		this.bola = bola;
	}

	@Override
	public void run() {
		ativo = true;
		while (ativo) {
			try {

				mover();
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void mover() {

		if (direcao.equals("right")) {

			bola.setX(bola.getX() + 2);
			
			if (bola.getX() > 400) ativo = false;

		} else if (direcao.equals("left")) {

			bola.setX(bola.getX() - 2);
			if (bola.getX() < 10) ativo = false;
		
		} else if (direcao.equals("up")) {

			bola.setY(bola.getY() - 2);
			if (bola.getY() < 10) ativo = false;
	

		} else if (direcao.equals("down")) {

			bola.setY(bola.getY() + 2);
			if (bola.getY() > 600) ativo = false;
			
		}

	}

	public boolean isAtivo() {
		return ativo;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

}
