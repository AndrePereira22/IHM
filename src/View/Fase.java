package View;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import Model.Alvo;
import Model.Bola;
import Model.Jogo;
import Model.Mapa;
import Model.Sprite;
import Model.Trave;

public class Fase extends Jogo {

	private static final long serialVersionUID = 1L;

	private Mapa fundo, caminho1;
	private Alvo alvo;
	private Sprite personagem;
	private static ArrayList<Rectangle> retangulosColisao;
	private Trave trave;

	public Fase(String img, Mapa caminho, Mapa colisao) {
		super(img, caminho, colisao);
		Load(img, caminho, colisao);

	}

	public void Load(String img, Mapa caminho, Mapa colisao) {
		fundo = new Mapa("c.png", "campo.txt");
		fundo.montarMapa();
		this.caminho1 = caminho;

		caminho1.montarMapa();

		retangulosColisao = colisao.montarColi();

		alvo = new Alvo();

		trave = new Trave();

		try {
			personagem = new Sprite(img, 1, 4, 5, 128, 320);

		} catch (IOException e) {

		}
		repaint();

	}

	public Mapa getCaminho1() {
		return caminho1;
	}

	public void Update() {
		fundo.montarMapa();
		caminho1.montarMapa();
	}

	public void Render() {

		g.drawImage(fundo.getMapa(), 0, 0, null);
		g.drawImage(caminho1.getMapa(), 0, 0, null);

		g.drawImage(trave.getImagem(), trave.getX(), trave.getY(), null);

		for (int i = 0; i < Bola.getBolas().size(); i++) {

			Bola bola = Bola.getBolas().get(i);
			if (bola.getVisivel()) {
				g.drawImage(bola.getImagem(), bola.getX(), bola.getY(), null);
			}

		}
		g.drawImage(alvo.getImagem(), alvo.getX(), alvo.getY(), null);

		g.drawImage(personagem.sprites[personagem.aparencia], personagem.getX(), personagem.getY(), null);

	}

	public Alvo getAlvo() {
		return alvo;
	}

	public void setarMapa(Mapa mapa) {
		this.caminho1 = mapa;
	}

	public Sprite getPersonagem() {
		return personagem;
	}

	public Trave getTrave() {
		return trave;
	}

	public static ArrayList<Rectangle> getRetangulosColisao() {
		return retangulosColisao;
	}

}
