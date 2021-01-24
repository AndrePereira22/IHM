package Control;

import java.util.ArrayList;

import Model.Bola;
import Model.MainList;
import Model.Sprite;
import View.Fase;

public class Movimento {

	private Sprite personagem;

	private Direita direita;
	private Esquerda esquerda;
	private Frente cima;
	private MoverBola moverBola;
	private Baixo baixo;
	private Fase fase;
	private ArrayList<MainList> lista = new ArrayList<MainList>();
	private Bola bola;

	public Movimento(Sprite player1, Fase fase) {
		this.personagem = player1;
		this.direita = new Direita(personagem);
		this.esquerda = new Esquerda(personagem);
		this.cima = new Frente(personagem);
		this.baixo = new Baixo(personagem);
		this.fase = fase;
		this.bola = fase.getBola();
		this.moverBola = new MoverBola(bola,personagem);

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
							personagem.aparencia = 7;
						} else if (personagem.aparencia == 7) {
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
							personagem.aparencia = 7;
						} else if (personagem.aparencia == 7) {
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

					} else if (personagem.aparencia == 7) {

						direita.run();
					}

				} else if (main.getDirecao().equals("giro")) {

					try {
						if (personagem.aparencia == 0) {
							personagem.aparencia = 1;
						} else if (personagem.aparencia == 1) {
							personagem.aparencia = 0;
						} else if (personagem.aparencia == 2) {
							personagem.aparencia = 7;
						} else if (personagem.aparencia == 7) {
							personagem.aparencia = 2;
						}
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} else if (main.getDirecao().equals("chutar")) {

					try {

						if (personagem.aparencia == 7) {
							personagem.aparencia = 3;

							if (verificarRight()) {

								moverBola.setDirecao("right");

								moverBola.run();
							}
		

						} else if (personagem.aparencia == 0) {
							personagem.aparencia = 12;
							
							
						
							if (verificarDown()) {

								moverBola.setDirecao("down");

								moverBola.run();
							}
					
							

						} else if (personagem.aparencia == 1) {
							personagem.aparencia = 13;
							
							if (verificarUp()) {

								moverBola.setDirecao("up");

								moverBola.run();
							}
						

						} else if (personagem.aparencia == 2) {
							personagem.aparencia = 6;
							
							if (verificarLeft()) {

								moverBola.setDirecao("left");

								moverBola.run();
							}
			

						}

						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (java.lang.IllegalThreadStateException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}
		}

	}

	public boolean verificarRight() {

		int diferenca = bola.getX() - personagem.getX();

		if (diferenca < 0)
			diferenca = diferenca * -1;

		if (bola.getX() > personagem.getX()) {

			if (diferenca < 53) {
				return true;
			}

		}

		return false;
	}
	public boolean verificarLeft() {

		int diferenca = personagem.getX()- bola.getX();

		if (diferenca < 0)
			diferenca = diferenca * -1;

		if (bola.getX() < personagem.getX()) {

			if (diferenca < 30) {
				return true;
			}

		}

		return false;
	}
	public boolean verificarUp() {

		int diferenca = personagem.getY() - bola.getY();

		if (diferenca < 0)
			diferenca = diferenca * -1;

		if (bola.getY() < personagem.getY()) {

			if (diferenca < 6) {
				return true;
			}

		}

		return false;
	}
	
	
	public boolean verificarDown() {

		int diferenca = bola.getY() - personagem.getY();

		if (diferenca < 0) diferenca = diferenca * -1;

		if (bola.getY() > personagem.getY()) {

			if (diferenca < 61) {
				return true;
			}

		}
		return false;
	}
	
	

	public void addMovimento(String direcao) {

		lista.add(new MainList(direcao));

	}

	public ArrayList<MainList> getLista() {
		return lista;
	}

}
