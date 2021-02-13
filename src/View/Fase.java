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

	private Mapa fundo, caminho1, caminho2, caminho3, caminho4, caminho5, caminho6;
	private Mapa colisao1, colisao2, colisao3, colisao4, colisao5, colisao6;
	private Alvo alvo;
	private Sprite personagem;
	private static ArrayList<Rectangle> retangulosColisao;
	private Trave trave;

	public Fase(String img) {
		super(img);
		Load(img);

	}

	public void Load(String img) {
		fundo = new Mapa("c.png", "campo.txt");

		caminho1 = new Mapa("c.png", "caminho1.txt");
		caminho2 = new Mapa("c.png", "caminho2.txt");
		caminho3 = new Mapa("c.png", "caminho3.txt");
		caminho4 = new Mapa("c.png", "caminho4.txt");
		caminho5 = new Mapa("c.png", "caminho5.txt");
		caminho6 = new Mapa("c.png", "caminho6.txt");

		colisao1 = new Mapa("c.png", "colisao1.txt");
		colisao2 = new Mapa("c.png", "colisao2.txt");
		colisao3 = new Mapa("c.png", "colisao3.txt");
		colisao4 = new Mapa("c.png", "colisao4.txt");
		colisao5 = new Mapa("c.png", "colisao5.txt");
		colisao6 = new Mapa("c.png", "colisao6.txt");

		fundo.montarMapa();
		caminho1.montarMapa();
		alvo = new Alvo();
		
		setRetangulosColisao(colisao1.montarColi());

		trave = new Trave();

		try {
			personagem = new Sprite(img, 1, 4, 5, 128, 320);

		} catch (IOException e) {

		}

	}

	public Mapa getCaminho1() {
		return caminho1;
	}

	public Mapa getCaminho2() {
		return caminho2;
	}

	public Mapa getCaminho3() {
		return caminho3;
	}

	public Mapa getCaminho4() {
		return caminho4;
	}

	public Mapa getCaminho5() {
		return caminho5;
	}

	public Mapa getCaminho6() {
		return caminho6;
	}

	public Mapa getColisao1() {
		return colisao1;
	}

	public Mapa getColisao2() {
		return colisao2;
	}

	public Mapa getColisao3() {
		return colisao3;
	}

	public Mapa getColisao4() {
		return colisao4;
	}

	public Mapa getColisao5() {
		return colisao5;
	}

	public Mapa getColisao6() {
		return colisao6;
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

		g.drawImage(personagem.sprites[personagem.aparencia], personagem.getX(), personagem.getY(), null);

	}

	public Alvo getAlvo() {
		return alvo;
	}

	public void setarMapa(Mapa mapa) {
		this.caminho1 = mapa;
	}

	public void setarColisao(Mapa colisao) {
		this.setRetangulosColisao(colisao.montarColi());
	}

	public static ArrayList<Rectangle> getRetangulosColisao() {
		return retangulosColisao;
	}

	public Sprite getPersonagem() {
		return personagem;
	}

	public Trave getTrave() {
		return trave;
	}

	public static void setRetangulosColisao(ArrayList<Rectangle> retangulosColisao) {
		Fase.retangulosColisao = retangulosColisao;
	}

}
