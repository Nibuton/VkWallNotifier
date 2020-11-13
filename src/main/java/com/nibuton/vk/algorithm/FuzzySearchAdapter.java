package com.nibuton.vk.algorithm;

import me.xdrop.fuzzywuzzy.FuzzySearch;

public class FuzzySearchAdapter implements EditingDistanceAlgorithm {

	@Override
	public int getEditingDistance(String original, String target) {
		return FuzzySearch.ratio(original, target);
	}
	
	@Override
	public int getPartialEditingDistance(String text, String target) {
		return FuzzySearch.partialRatio(text, target);
	}

}
