
package Model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Alvo {

	private Image imagem;
	private int x, y;
	private   int largura, altura;
	private ImageIcon referencia;
	private boolean isVisivel;
	private static  int[] posX = { 324,324,386 };
	private static int[] posY = { 70,164,166 };

	static ArrayList<Alvo> alvos = new ArrayList<Alvo>();
	

	public Alvo(int x, int y) {

		this.x = x;
		this.y = y;

		referencia = new ImageIcon(getClass().getResource("/alvo.png"));

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


	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static ArrayList<Alvo> getAlvos() {
		return alvos;
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

	public  int getAltura() {
		return altura;
	}
	

}
