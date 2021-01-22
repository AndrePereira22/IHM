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
	private Mapa mapa;
	private Sprite personagem;
	private Bola bola;
	private Trave trave;


	public Fase() {
		super();
		Load();
	
	}
	
	public void Load() {
		mapa= new Mapa("tileset.png","camada.txt");

		mapa.montarMapa();
		bola = new Bola(220,85);
		trave = new Trave(350, 85);
		Bloco.inicializaBarreiras();
		
		try {
		personagem = new Sprite("sprite.png",1,4,4,100,170);
			
	} catch (IOException e) {

	}
		
	}
	public void Update() {
		mapa.montarMapa();	
	}
	public void Render() {
		
		g.drawImage(mapa.getMapa(),0, 0, null);
		
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

