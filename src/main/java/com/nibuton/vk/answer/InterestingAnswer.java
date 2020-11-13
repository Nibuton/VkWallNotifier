package com.nibuton.vk.answer;

import java.util.ArrayList;
import java.util.List;

public class InterestingAnswer {
	
	private boolean isInteresting;
	private List<String> names = new ArrayList<>();
	
	public void setInteresting(boolean isInteresting) {
		this.isInteresting = isInteresting;
	}
	public void addGameName(String name) {
		names.add(name);
	}
	public boolean isInteresting() {
		return isInteresting;
	}
	public List<String> getNames() {
		return names;
	}

}
