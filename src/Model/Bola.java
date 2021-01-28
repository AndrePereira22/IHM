
package Model;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bola extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image imagem;
	private int x, y;
	private int largura, altura;
	private ImageIcon referencia;
	private boolean isVisivel;
	private int[] posX = { 172 };
	private int[] posY = { 76 };

	private static ArrayList<Point> pontos = new ArrayList<Point>();

	public Bola(int x, int y) {

		this.x = x;
		this.y = y;

		referencia = new ImageIcon(getClass().getResource("/bola.png"));

		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);

		isVisivel = true;
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

	public void setX(int posX) {

		this.x = posX;

	}

	public void setY(int posY) {

		this.y = posY;

	}

	public int[] getPosX() {
		return posX;
	}

	public int[] getPosY() {
		return posY;
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

	public ArrayList<Point> getPontos() {
		return pontos;
	}

}
