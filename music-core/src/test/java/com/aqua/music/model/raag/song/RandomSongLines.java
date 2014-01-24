/**
 * 
 */
package com.aqua.music.model.raag.song;

import static com.aqua.music.model.core.ClassicalNote.D;
import static com.aqua.music.model.core.ClassicalNote.D1;
import static com.aqua.music.model.core.ClassicalNote.G;
import static com.aqua.music.model.core.ClassicalNote.M_;
import static com.aqua.music.model.core.ClassicalNote.N1;
import static com.aqua.music.model.core.ClassicalNote.R_;
import static com.aqua.music.model.core.ClassicalNote.S;
import open.music.api.AudioPlayerFacade;
import open.music.api.SingletonFactory;

import com.aqua.music.bo.audio.manager.CommonCode;
import com.aqua.music.model.raag.MusicalPhrase;

/**
 * @author "Shruti Tiwari"
 * 
 */
public class RandomSongLines {
	public static void main(String[] args) {
		// List<ClassicalNote> phrase = Arrays.asList(new ClassicalNote[]{M_, G,
		// R_, R_, S});
		MusicalPhrase m = new MusicalPhrase().n(M_, D, M_, G, G, R_, G, G, N1, R_, N1, D1).couple(N1, R_).n(G, R_, S);
		AudioPlayerFacade.increaseTempo();
		AudioPlayerFacade.increaseTempo();
		initialize();
		SingletonFactory.PLAY_API.playInLoop(m);
	}

	private static void initialize() {
		CommonCode.initialize();
	}

}
