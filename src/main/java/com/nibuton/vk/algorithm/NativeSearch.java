package com.nibuton.vk.algorithm;

public class NativeSearch implements EditingDistanceAlgorithm {

	public NativeSearch() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getEditingDistance(String original, String target) {
		return 0;
	}

	@Override
	public int getPartialEditingDistance(String text, String target) {
		int a = 0;
		if (text.contains(target)) {
			a = 100;
		}
		return a;
	}

}
