package Control;

import java.util.ArrayList;

import Model.Audio;
import Model.Bola;
import Model.MainList;
import Model.Sprite;
import View.Componente;
import View.Fase;

public class Movimento {

	private Sprite personagem;

	private Direita direita;
	private Esquerda esquerda;
	private Frente cima;
	private Baixo baixo;
	private static ArrayList<MainList> list = new ArrayList<MainList>();
	private Audio audio;
	private Bola bola;
	int i = 0;
	private Fase fase;
	private Componente componentes;

	public Movimento(Sprite player1, Fase fase, Audio audio, Componente componentes) {

		this.personagem = player1;
		this.audio = audio;
		this.direita = new Direita(personagem);
		this.esquerda = new Esquerda(personagem);
		this.cima = new Frente(personagem, fase);
		this.baixo = new Baixo(personagem);
		this.fase = fase;
		this.componentes = componentes;

	}

	public void Play() {

		for (MainList main : list) {
			try {

				if (main.getDirecao().equals("right")) {

					try {
						if (personagem.aparencia == 0) {
							personagem.aparencia = 2;
						} else if (personagem.aparencia == 2) {
							personagem.aparencia = 1;
						} else if (personagem.aparencia == 1) {
							personagem.aparencia = 8;
						} else if (personagem.aparencia == 8) {
							personagem.aparencia = 0;
						}

						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} else if (main.getDirecao().equals("left")) {
					try {
						if (personagem.aparencia == 1) {
							personagem.aparencia = 2;
						} else if (personagem.aparencia == 2) {
							personagem.aparencia = 0;
						} else if (personagem.aparencia == 0) {
							personagem.aparencia = 8;
						} else if (personagem.aparencia == 8) {
							personagem.aparencia = 1;
						}
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (main.getDirecao().equals("up")) {

					if (personagem.aparencia == 0) {
						baixo.run();

					} else if (personagem.aparencia == 1) {

						cima.run();

					} else if (personagem.aparencia == 2) {

						esquerda.run();

					} else if (personagem.aparencia == 8) {

						direita.run();
					}

				} else if (main.getDirecao().equals("giro")) {

					try {
						if (personagem.aparencia == 0) {
							personagem.aparencia = 1;
						} else if (personagem.aparencia == 1) {
							personagem.aparencia = 0;
						} else if (personagem.aparencia == 2) {
							personagem.aparencia = 8;
						} else if (personagem.aparencia == 8) {
							personagem.aparencia = 2;
						}
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} else if (main.getDirecao().equals("chutar")) {
					
					audio.getSndApito().play();
					Thread.sleep(2300);
					

					if (personagem.colisaoAlvo(fase.getAlvo(), 0, 0)) {

						audio.getSndchute().play();
						Thread.sleep(500);

						try {

							if (personagem.aparencia == 8) {

								personagem.aparencia = 3;

								bola = new Bola(personagem.getX(), personagem.getY(), "direita", 192, "/bolaD.png");
								Model.Bola.add(bola);
								Thread.sleep(300);
								personagem.aparencia = 14;
								bola.run();

							} else if (personagem.aparencia == 0) {
								personagem.aparencia = 5;

								bola = new Bola(personagem.getX(), personagem.getY(), "baixo", 192, "/bolaB.png");
								Model.Bola.add(bola);
								Thread.sleep(400);
								personagem.aparencia = 19;
								bola.run();

							} else if (personagem.aparencia == 1) {
								personagem.aparencia = 6;

								bola = new Bola(personagem.getX(), personagem.getY(), "cima", 192, "/bolaC.png");
								Model.Bola.add(bola);
								Thread.sleep(300);
								personagem.aparencia = 4;
								bola.run();

							} else if (personagem.aparencia == 2) {
								personagem.aparencia = 7;

								bola = new Bola(personagem.getX(), personagem.getY(), "esquerda", 192, "/bolaE.png");
								Model.Bola.add(bola);
								Thread.sleep(300);
								personagem.aparencia = 9;
								bola.run();

							}

							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					} else {

						componentes.ErrouPosicao();
						reiniciar();
					}

				}
				Thread.sleep(240);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (java.lang.IllegalThreadStateException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}

		}

	}

	public void reiniciar() {
		Bola.getBolas().clear();
		componentes.setarIconeCima();
		componentes.getPainelArea().removeAll();
		componentes.setIndice(0);
		posicionarA();
		getLista().clear();
		
	
	}

	public void posicionarA() {
		personagem.setX(128);
		personagem.setY(320);
		personagem.aparencia = 1;
		Controle.aparencia = 1;
	}

	public void addMovimento(String direcao) {

		list.add(new MainList(direcao));

	}

	public ArrayList<MainList> getLista() {
		return list;
	}

}
