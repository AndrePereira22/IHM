
package Model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Trave {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private ImageIcon referencia;
	private boolean isVisivel;


	public Trave(int x, int y) {

		this.x = x;
		this.y = y;

		referencia = new ImageIcon(getClass().getResource("/trave.png"));

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
