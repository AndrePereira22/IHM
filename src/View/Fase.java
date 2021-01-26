package View;

import java.io.IOException;

import Model.Bloco;
import Model.Bola;
import Model.Jogo;
import Model.Mapa;
import Model.Sprite;
import Model.Trave;


public class Fase  extends Jogo  {

	private static final long serialVersionUID = 1L;
	private Mapa mapa1;
	private Sprite personagem;
	private Bola bola;
	private Trave trave;

	public Fase(String img) {
		super(img);
		Load(img);
	
	}
	
	public void Load(String img) {
		mapa1= new Mapa("campo.png","camada.txt");

		mapa1.montarMapa();


		bola = new Bola(174,88);
		trave = new Trave(370, 70);
		Bloco.inicializaBarreiras(Bloco.getCoordenadas1());
		try {
		personagem = new Sprite(img,1,4,4,82,184);
			
	} catch (IOException e) {

	}
		
	}
	public void Update() {
		mapa1.montarMapa();	
	}
	public void Render() {
		
		g.drawImage(mapa1.getMapa(),0, 0, null);
		
		for (int i = 0; i < Bloco.getBarreiras().size(); i++) {
			Bloco b =  Bloco.getBarreiras().get(i);
				if(b.isVisivel()) {
					g.drawImage(b.getImagem(), b.getX(), b.getY(), null);
				}
		}
	
		
	
		g.drawImage(personagem.sprites[personagem.aparencia], personagem.getX(), personagem.getY(), null);
	
		
		g.drawImage(trave.getImagem(), trave.getX(), trave.getY(), null);
		g.drawImage(bola.getImagem(), bola.getX(), bola.getY(), null);
			

	}

	public Sprite getPersonagem() {
		return personagem;
	}

	public Bola getBola() {
		return bola;
	}


	
}

