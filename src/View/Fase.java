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



	public Fase() {
		super();
		Load();
	
	}
	
	public void Load() {
		mapa1= new Mapa("tileset.png","camada.txt");
	
		
		

		mapa1.montarMapa();


		bola = new Bola(188,85);
		trave = new Trave(370, 50);
		Bloco.inicializaBarreiras();
		
		try {
		personagem = new Sprite("sprite.png",1,4,4,96,153);
			
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
	
		g.drawImage(bola.getImagem(), bola.getX(), bola.getY(), null);
	
		g.drawImage(personagem.sprites[personagem.aparencia], personagem.getX(), personagem.getY(), null);
	
		
		g.drawImage(trave.getImagem(), trave.getX(), trave.getY(), null);
			

	}

	public Sprite getPersonagem() {
		return personagem;
	}

	public Bola getBola() {
		return bola;
	}


	
}

