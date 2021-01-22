
package Model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Bloco {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private ImageIcon referencia;
	private boolean isVisivel;

	private static int[][] coordenadas = {{ 94,80},{ 94,112},{ 94,144},{ 94,176},{ 134,80},{ 174,80},{ 214,80}};
	//,{ 94,143},{ 94,173},{ 127,80},{ 157,80}

	static ArrayList<Bloco> barreiras = new ArrayList<Bloco>();
	

	public Bloco(int x, int y) {

		this.x = x;
		this.y = y;

		referencia = new ImageIcon(getClass().getResource("/bloco.png"));

		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
		
		isVisivel = true;
	}
	public static void inicializaBarreiras() {
		for (int i = 0; i < coordenadas.length; i++) {
			barreiras.add(new Bloco(coordenadas[i][0], coordenadas[i][1]));
			
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

	public boolean isVisivel() {
		return isVisivel;
	}

	public static ArrayList<Bloco> getBarreiras() {
		return barreiras;
	}
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}

	public int[][] getCoordenadas() {
		return coordenadas;
	}
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	

}
