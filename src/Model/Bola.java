package Model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Bola implements Runnable {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	private static final int VELOCIDADE = 4;
	private String direcao;
	private int limite;
	private int contador=0;

	static ArrayList<Bola> bolas = new ArrayList<Bola>();

	public Bola(int x, int y, String d, int limite,String img) {

		this.x = x;
		this.y = y;
		this.limite = limite;

		ImageIcon referencia = new ImageIcon(getClass().getResource(img));
		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);

		this.direcao = d;

		isVisivel = true;
	
	}

	public void run() {
	
		while (isVisivel) {
			mexer(direcao);
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public void mexer(String direcao) {

		if (direcao.equals("cima")) {
			y -= VELOCIDADE;
			contador += VELOCIDADE;
		}
		if (direcao.equals("baixo")) {
			y += VELOCIDADE;
			contador += VELOCIDADE;
		}
		if (direcao.equals("direita")) {
			x += VELOCIDADE;
			contador += VELOCIDADE;
		}
		if (direcao.equals("esquerda")) {
			x -= VELOCIDADE;
			contador += VELOCIDADE;

		}

		if (contador == limite) {
			isVisivel = false;
		}
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public boolean getVisivel() {
		return isVisivel;
	}

	public Image getImagem() {
		return imagem;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public static void add(Bola bola) {
		bolas.add(bola);

	}

	public static ArrayList<Bola> getBolas() {
		return bolas;
	}

}
