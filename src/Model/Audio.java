package Model;

import java.applet.Applet;
import java.applet.AudioClip;

public class Audio {

	private AudioClip sndmusica, sndchute, sndgol, sndErro,sndApito;

	public Audio() {
		sndmusica = Applet.newAudioClip(getClass().getResource("/music.wav"));
		sndchute = Applet.newAudioClip(getClass().getResource("/chute.wav"));
		sndgol = Applet.newAudioClip(getClass().getResource("/gol.wav"));
		sndErro = Applet.newAudioClip(getClass().getResource("/erro.wav"));
		sndApito = Applet.newAudioClip(getClass().getResource("/apito.wav"));

	}

	public AudioClip getSndmusica() {
		return sndmusica;
	}

	public AudioClip getSndchute() {
		return sndchute;
	}

	public AudioClip getSndgol() {
		return sndgol;
	}

	public AudioClip getSndErro() {
		return sndErro;
	}

	public AudioClip getSndApito() {
		return sndApito;
	}
	

}