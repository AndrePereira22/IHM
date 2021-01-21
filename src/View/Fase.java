package View;

import java.io.IOException;

import Model.Bloco;
import Model.Jogo;
import Model.Mapa;
import Model.Sprite;


public class Fase  extends Jogo  {

	private static final long serialVersionUID = 1L;
	private Mapa mapa;
	private Sprite personagem;


	public Fase() {
		super();
		Load();
	
	}
	
	public void Load() {
		mapa= new Mapa("tileset.png","camada.txt");

		mapa.montarMapa();
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
		
		

	}

	public Sprite getPersonagem() {
		return personagem;
	}


	
}

