package com.aqua.music.model.cyclicset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import open.music.api.PracticeCustomization;

import com.aqua.music.model.core.DynamicFrequency;
import com.aqua.music.model.core.Frequency;
import com.aqua.music.model.core.FrequencySet;
/**
 * @author "Shruti Tiwari"
 *
 */
class CyclicFrequencySetWithAsymmetry implements CyclicFrequencySet {
	private final Collection<Frequency> frequencies = new ArrayList<Frequency>();
	private final FrequencySet frequencySet;

	public CyclicFrequencySetWithAsymmetry(FrequencySet frequencySet, PermutationApplicator patternApplicator) {
		this.frequencySet = frequencySet;
		this.frequencies.addAll(Arrays.asList(frequencySet.ascendNotes()));
		this.frequencies.addAll(Arrays.asList(frequencySet.descendNotes()));
	}

	public Collection<Frequency> finalFrequencySequence() {
		return frequencies;
	}

	
	public Collection<Frequency> frequencies() {
		return frequencies;
	}

	@Override
	public String name() {
		return frequencySet.name();
	}

	@Override
	public String asText() {
		return "";
	}

	/* (non-Javadoc)
	 * @see open.music.api.Playable#frequencies(open.music.api.PracticeCustomization)
	 */
	@Override
	public Collection<? extends DynamicFrequency> frequencies(PracticeCustomization practiceCustomization) {
		// TODO Auto-generated method stub
		return null;
	}
}