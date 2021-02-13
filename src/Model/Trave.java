
package Model;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Trave {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private ImageIcon referencia;
	private boolean isVisivel;

	public Trave() {

		this.x = 688;
		this.y = 192;

		referencia = new ImageIcon(getClass().getResource("/trave1.png"));

		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);

		isVisivel = true;
	}

	public void posicaoDireita() {

		this.x = 688;
		this.y = 192;

	}

	public void posicaoEsquerda() {

		this.x = 0;
		this.y = 192;

	}

	public void mudarIcone(int n) {

		if (n == 1) {
			referencia = new ImageIcon(getClass().getResource("/trave1.png"));

			imagem = referencia.getImage();
		} else {
			referencia = new ImageIcon(getClass().getResource("/trave2.png"));

			imagem = referencia.getImage();
		}

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
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

	public boolean isVisivel() {
		return isVisivel;
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

}
