package Model;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

	private Clip musica, chute, gol;

	public Audio() {
		try {
			AudioInputStream audioMusica = AudioSystem.getAudioInputStream(new File("resource/musica.wav").getAbsoluteFile());
			AudioInputStream audioChute = AudioSystem.getAudioInputStream(new File("resource/chute.wav").getAbsoluteFile());
			AudioInputStream audioGol = AudioSystem.getAudioInputStream(new File("resource/gol.wav").getAbsoluteFile());

			musica = AudioSystem.getClip();
			musica.open(audioMusica);

			chute = AudioSystem.getClip();
			chute.open(audioChute);

			gol = AudioSystem.getClip();
			gol.open(audioGol);

		} catch (Exception ex) {
			System.out.println("Erro ao executar SOM!");
			ex.printStackTrace();
		}

	}

	public Clip getMusica() {
		return musica;
	}

	public Clip getChute() {
		return chute;
	}

	public Clip getGol() {
		return gol;
	}

}