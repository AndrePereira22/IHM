package Model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import View.Componente;

public class Sprite extends Thread {

	private int x, y;
	private int altura, largura;
	private int rows, columns;
	public int aparencia;
	public BufferedImage[] sprites;
	private BufferedImage spriteSheet;
	private  int[] posX = { 100, 200 };
	private int[] posY = { 170, 300 };
	private  ArrayList<Point> posicoes =new ArrayList<Point>();

	public Sprite(String url, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		spriteSheet = ImageIO.read(getClass().getClassLoader().getResource(url));
		this.aparencia = aparencia;

		this.largura = spriteSheet.getWidth() / columns;
		this.altura = spriteSheet.getHeight() / rows;

		this.rows = columns;
		this.columns = rows;
		this.x = posX;
		this.y = posY;
	
		addPosicoes();

		sprites = new BufferedImage[columns * rows];
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * largura, j * altura, largura, altura);
			}
		}
	}

	private void addPosicoes() {

		for (int i = 0; i < 2; i++) {
			posicoes.add(new Point(posX[i], posY[i]));

		}

	}

	public boolean colisao(ArrayList<Rectangle> tmp, int x, int y) {
		Rectangle personagem = new Rectangle(getX() + x, getY() + y, getLargura(), getAltura());
		for (Rectangle rectangle : tmp) {
			if (rectangle.intersects(personagem)) {
				return true;
			}
		}
		return false;

	}

	public void setX(int posX) {

		this.x = posX;

	}

	public void setY(int posY) {

		this.y = posY;

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

	public int getAltura() {
		return altura;
	}

	public int getLargura() {
		return largura;
	}

	public  ArrayList<Point> getPosicoes() {
		return posicoes;
	}

}
