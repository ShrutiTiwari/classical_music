package com.aqua.music.model.cyclicset;

import java.util.HashSet;

import open.music.api.AudioPlayerFacade;

import com.aqua.music.bo.audio.manager.CommonCode;

public class AscendDescendSequencePuzzles {
	public void playThaat() {
		initialize();
		CyclicFrequencySet playItem = CyclicFrequencySet.Type.SYMMETRICAL.forFrequencySet(SymmetricalSet.THAAT_BILAWAL);
		AudioPlayerFacade.SYNCHRONOUS_PLAYER.play(playItem.frequencies(), 1);
	}

	public void playMultipleThaats() {
		initialize();
		CyclicSequenceNonPermutating.MultipleSymmetricalFreqSets multipleSymmetricFreqSet = new CyclicSequenceNonPermutating.MultipleSymmetricalFreqSets(
				new SymmetricalSet[] { SymmetricalSet.THAAT_BILAWAL, SymmetricalSet.THAAT_ASAVARI });
		System.out.println(multipleSymmetricFreqSet.asString());
		
		AudioPlayerFacade.SYNCHRONOUS_PLAYER.play(multipleSymmetricFreqSet.allFrequenciesInCycle(), 1);
	}

	public void playAllThats() {
		int repeatCount = 2;
		System.out.println("Repeating each item[" + repeatCount + "] \n");
		for (int i = 0; i < 3; i++) {
			// puzzleBuilder.playArohiAvrohi(repeatCount,
			// SecondYearRaag.values());
			playAscendAndDescend(repeatCount, SymmetricalSet.values());
			System.out.println("round[" + i + "] done \n");
		}
	}

	private void playAscendAndDescend(int count, SymmetricalSet... raags) {
		AudioPlayerFacade.SYNCHRONOUS_PLAYER.play(CyclicFrequencySet.Type.SYMMETRICAL.forFrequencySet(SymmetricalSet.THAAT_BILAWAL).frequencies(), 1);
		System.out.println("\n Played [BILAWAL]");
		HashSet<SymmetricalSet> hasheddata = randomize(raags);
		for (SymmetricalSet each : hasheddata) {

			for (int i = 0; i < count; i++) {
				AudioPlayerFacade.SYNCHRONOUS_PLAYER.play(CyclicFrequencySet.Type.SYMMETRICAL.forFrequencySet(each).frequencies(), 1);
				System.out.println("\nPlayed [" + each.name() + "] ." + i);
				System.out.println("\n");
			}
		}
	}

	private HashSet<SymmetricalSet> randomize(SymmetricalSet... raag) {
		HashSet<SymmetricalSet> hasheddata = new HashSet<SymmetricalSet>();
		for (SymmetricalSet each : raag) {
			hasheddata.add(each);
		}
		return hasheddata;
	}
	
	private void initialize() {
		CommonCode.initialize();
	}
}
