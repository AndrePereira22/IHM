package View;

import java.io.IOException;

import Model.Alvo;
import Model.Bola;
import Model.Jogo;
import Model.Mapa;
import Model.Sprite;
import Model.Trave;


public class Fase extends Jogo {

	private static final long serialVersionUID = 1L;
	private Mapa mapa1;
	private Sprite personagem;
	private Bola bola;
	private Trave trave;

	public Fase(String img) {
		super(img);
		Load(img);

	}

	public void Load(String img) {
		mapa1 = new Mapa("campo.png", "camada.txt");

		mapa1.montarMapa();

		bola = new Bola(168, 70);
		trave = new Trave(430, 161);

		try {
			personagem = new Sprite(img, 1, 4, 4, 92, 206);

		} catch (IOException e) {

		}

	}

	public void Update() {
		mapa1.montarMapa();
	}

	public void Render() {

		g.drawImage(mapa1.getMapa(), 0, 0, null);

	    g.drawImage(trave.getImagem(), trave.getX(), trave.getY(), null);
		g.drawImage(bola.getImagem(), bola.getX(), bola.getY(), null);
		g.drawImage(personagem.sprites[personagem.aparencia], personagem.getX(), personagem.getY(), null);

		for (int i = 0; i < Alvo.getAlvos().size(); i++) {

			Alvo b = Alvo.getAlvos().get(i);

			if (b.isVisivel()) {
				g.drawImage(b.getImagem(), b.getX(), b.getY(), null);
			}
		}

	}

	public Sprite getPersonagem() {
		return personagem;
	}

	public Bola getBola() {
		return bola;
	}

	public Trave getTrave() {
		return trave;
	}

}
