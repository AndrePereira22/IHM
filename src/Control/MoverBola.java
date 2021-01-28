package Control;

import java.awt.Rectangle;

import Model.Alvo;
import Model.Audio;
import Model.Bola;
import Model.Sprite;
import Model.Trave;
import View.Fase;

public class MoverBola implements Runnable {

	private Bola bola;
	private Sprite personagem;
	private boolean ativo = true;
	private Audio audio;
	private Fase fase;
	private String direcao = "";
	private int indice = 0;
	private boolean complete = false;

	public MoverBola(Bola bola, Sprite player, Audio audio, Fase fase) {
		this.bola = bola;
		this.personagem = player;
		this.audio = audio;
		this.fase = fase;
	}

	@Override
	public void run() {
		ativo = true;
		while (ativo) {
			try {
				mover();
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void mover() {

		if (direcao.equals("right")) {

			bola.setX(bola.getX() + 2);
			colisao(0, 0);
			colisaoAlvo(0, 0);
			// erro();

		} else if (direcao.equals("left")) {

			bola.setX(bola.getX() - 2);
			// colisao(0, 0);
			colisaoAlvo(0, 0);
			erro();

		} else if (direcao.equals("up")) {

			bola.setY(bola.getY() - 2);
			colisao(0, 0);
			erro();

		} else if (direcao.equals("down")) {

			bola.setY(bola.getY() + 2);
			colisao(0, 0);
			colisaoAlvo(0, 0);
			erro();

		}

	}

	public void colisao(int x, int y) {

		Trave tempTrave = fase.getTrave();
		Bola tempBola = fase.getBola();

		Rectangle trave = new Rectangle(tempTrave.getX() + x, tempTrave.getY() + y, tempTrave.getLargura(),
				tempTrave.getAltura());
		Rectangle ball = new Rectangle(tempBola.getX() + x, tempBola.getY() + y, tempBola.getLargura(),
				tempBola.getAltura());

		if (trave.intersects(ball)) {
			audio.getGol().start();
			mudarAparencia();

			if (direcao.equals("right")) {
				for (int i = 0; i < 6; i++) {
					try {
						bola.setX(bola.getX() + 2);
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			} else if (direcao.equals("left")) {
				for (int i = 0; i < 6; i++) {
					try {
						bola.setX(bola.getX() - 2);
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

			ativo = false;
		}
	}

	public void colisaoAlvo(int x, int y) {

		Alvo tempAlvo;
		Bola tempBola = fase.getBola();

		Rectangle ball = new Rectangle(tempBola.getX() + x, tempBola.getY() + y, tempBola.getLargura(),
				tempBola.getAltura());

		for (int i = 0; i < Alvo.getAlvos().size(); i++) {

			tempAlvo = Alvo.getAlvos().get(i);

			Rectangle alvo = new Rectangle(tempAlvo.getX() + x, tempAlvo.getY() + y, tempAlvo.getLargura(),
					tempAlvo.getAltura());

			if (ball.intersects(alvo)) {
				indice++;
				mudarAparencia();

				if (direcao.equals("right")) {
					for (int j = 0; j < 9; j++) {
						try {
							bola.setX(bola.getX() + 2);
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else if (direcao.equals("down")) {
					for (int j = 0; j < 10; j++) {
						try {
							bola.setY(bola.getY() + 2);
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

				Alvo.getAlvos().clear();

				addPosicoes();
				ativo = false;
			}

		}

	}

	public void erro() {

		if (bola.getX() < 10 || bola.getX() > 424 || bola.getY() < 10 || bola.getY() > 325) {

			ativo = false;
		}

	}

	public void mudarAparencia() {
		if (personagem.aparencia == 3) {

			personagem.aparencia = 7;

		} else if (personagem.aparencia == 4) {
			personagem.aparencia = 0;

		} else if (personagem.aparencia == 5) {
			personagem.aparencia = 1;

		} else if (personagem.aparencia == 6) {
			personagem.aparencia = 2;

		}
	}

	public void addPosicoes() {

		if (indice != 3) {
			Alvo.getAlvos().add(new Alvo(Alvo.getPosX()[indice], Alvo.getPosY()[indice]));
		} else {

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
