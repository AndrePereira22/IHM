package Control;

import java.awt.Rectangle;
import java.util.ArrayList;

import Model.Alvo;
import Model.Audio;
import Model.Bola;
import Model.MainList;
import Model.Sprite;
import Model.Trave;
import View.Componente;
import View.Fase;
import View.PraFora;

public class Movimento {

	private Sprite personagem;

	private Direita direita;
	private Esquerda esquerda;
	private Frente cima;
	private Baixo baixo;
	private static ArrayList<MainList> lista = new ArrayList<MainList>();
	private Audio audio;
	private Componente componentes;
	private Bola bola;
	int i = 0;
	private Fase fase;
	private boolean foraAlvo=false;

	public Movimento(Sprite player1, Fase fase, Audio audio, Componente componentes, PraFora fora) {

		this.personagem = player1;
		this.audio = audio;
		this.direita = new Direita(personagem, fora);
		this.esquerda = new Esquerda(personagem, fora);
		this.cima = new Frente(personagem, fora, fase);
		this.baixo = new Baixo(personagem, fora);
		this.componentes = componentes;
		this.fase=fase;

	}

	public void Play() {

		for (MainList main : lista) {
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

					if (personagem.colisaoAlvo(fase.getAlvo(), 0, 0)) {

						audio.getChute().start();

						try {

							if (personagem.aparencia == 8) {

								personagem.aparencia = 3;

								bola = new Bola(personagem.getX(), personagem.getY(), "direita", 640, "/bolaD.png");
								Model.Bola.add(bola);
								Thread.sleep(300);
								personagem.aparencia = 14;
								bola.run();

							} else if (personagem.aparencia == 0) {
								personagem.aparencia = 5;

								bola = new Bola(personagem.getX(), personagem.getY(), "baixo", 640, "/bolaB.png");
								Model.Bola.add(bola);
								Thread.sleep(400);
								personagem.aparencia = 19;
								bola.run();

							} else if (personagem.aparencia == 1) {
								personagem.aparencia = 6;

								bola = new Bola(personagem.getX(), personagem.getY(), "cima", 640, "/bolaC.png");
								Model.Bola.add(bola);
								Thread.sleep(300);
								personagem.aparencia = 4;
								bola.run();

							} else if (personagem.aparencia == 2) {
								personagem.aparencia = 7;

								bola = new Bola(personagem.getX(), personagem.getY(), "esquerda", 640, "/bolaE.png");
								Model.Bola.add(bola);
								Thread.sleep(300);
								personagem.aparencia = 9;
								bola.run();

							}

							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}else {
						foraAlvo=true;
					}
///////////////////////////////////////
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

		removerAll();

	}



	private void removerAll() {
		componentes.getPainelArea().removeAll();
		componentes.setIndice(0);
		componentes.getPainelArea().repaint();

	}

	public void addMovimento(String direcao) {

		lista.add(new MainList(direcao));

	}

	public static ArrayList<MainList> getLista() {
		return lista;
	}

	public boolean isForaAlvo() {
		return foraAlvo;
	}

	public void setForaAlvo(boolean foraAlvo) {
		this.foraAlvo = foraAlvo;
	}

}
