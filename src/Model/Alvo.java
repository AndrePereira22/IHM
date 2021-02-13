
package Model;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Alvo {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private ImageIcon referencia;
	private boolean isVisivel;
	private static int[] posX = { 576 };
	private static int[] posY = { 192 };

	private Point pontoA;
	private Point pontoB;

	public Alvo() {

		pontoA = new Point(576, 192);
		pontoB = new Point(64, 192);

		this.x = pontoA.x;
		this.y = pontoA.y;

		referencia = new ImageIcon(getClass().getResource("/alvo.png"));

		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);

		isVisivel = true;
	}

	public void mudarA() {
		this.x = pontoA.x;
		this.y = pontoA.y;

	}

	public void mudarB() {
		this.x = pontoB.x;
		this.y = pontoB.y;

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

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int[] getPosX() {
		return posX;
	}

	public static int[] getPosY() {
		return posY;
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

}
