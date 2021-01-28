
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
	
	private int[] posX = { 430,8};
	private int[] posY = { 161,162};

	private static ArrayList<Point> pontos = new ArrayList<Point>();

	public Trave(int x, int y) {

		this.x = x;
		this.y = y;

		referencia = new ImageIcon(getClass().getResource("/trave1.png"));

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
	public Rectangle getBounds(){
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
