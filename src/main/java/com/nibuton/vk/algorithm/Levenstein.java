package com.nibuton.vk.algorithm;

import java.util.Arrays;

public class Levenstein implements EditingDistanceAlgorithm{

	@Override
	public int getEditingDistance(String original, String target) {

	        int originalSize = original.length() + 1;
	        int targetSize = target.length() + 1;

	        int[] prev = new int[originalSize];
	        int[] curr = new int[originalSize];

	        for (int i = 0; i < originalSize; i++){
	            prev[i] = i;
	        }

	        for (int j = 1; j < targetSize; j++){
	            for (int i = 0; i < originalSize; i++){
	                if (i == 0){
	                    curr[i] = j;
	                }
	                else {
	                    int c = charsAreEqual(original.charAt(i-1), target.charAt(j-1));
	                    curr[i] = Math.min(Math.min(prev[i] + 1, curr[i - 1] + 1), prev[i - 1] + c);
	                }
	            }
	            prev = Arrays.copyOf(curr, curr.length);
	        }

	        return curr[originalSize - 1];
	    }
	
	@Override
	public int getPartialEditingDistance(String text, String target) {
		return 0;
	}
	
    private int charsAreEqual(char a, char b){
        return a == b ? 0 : 1;
    }

}
