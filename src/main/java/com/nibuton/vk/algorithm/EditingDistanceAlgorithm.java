package com.nibuton.vk.algorithm;

public interface EditingDistanceAlgorithm {
	
	int getEditingDistance(String original, String target);
	int getPartialEditingDistance(String text, String target);

}
