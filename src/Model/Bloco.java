
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

	private static int[][] coordenadas2 = {{ 90,176},{ 54,176},{ 54,208},{ 54,240},{ 94,240},{ 134,240},{ 174,240}};
	
	private static int[][] coordenadas1 = {{ 80,80},{ 80,121},{ 80,162},{ 80,203},{ 121,80},{ 162,80}};

	private static ArrayList<Bloco> barreiras = new ArrayList<Bloco>();
	

	public Bloco(int x, int y) {

		this.x = x;
		this.y = y;

		referencia = new ImageIcon(getClass().getResource("/bloco.png"));

		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
		
		isVisivel = true;
	}
	public static void inicializaBarreiras(int[][] coordenadas) {
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

	public static  int[][] getCoordenadas1() {
		return coordenadas1;
	}
	public static int[][] getCoordenadas2() {
		return coordenadas2;
	}
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	

}
