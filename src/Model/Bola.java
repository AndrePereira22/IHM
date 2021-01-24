
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
	private int[] posX = { 188, 185 };
	private int[] posY = { 85, 245 };

	private static ArrayList<Point> pontos = new ArrayList<Point>();

	public Bola(int x, int y) {

		this.x = x;
		this.y = y;

		referencia = new ImageIcon(getClass().getResource("/bola.png"));

		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);

		addPosicoes();

		isVisivel = true;
	}

	@SuppressWarnings("unused")
	private void addPosicoes() {

		for (int i = 0; i < posX.length; i++) {
			pontos.add(new Point(posX[i], posY[i]));

		}

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
