package com.pearson.underscore.vlex.domain;

import java.util.ArrayList;
import java.util.List;


public class DefinitionResponse {

	private String originalWord;

	public List<String> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<String> definitions) {
		this.definitions = definitions;
	}

	private List<String> definitions = new ArrayList<String>();


	public String getOriginalWord() {
		return originalWord;
	}

	public void setOriginalWord(String originalWord) {
		this.originalWord = originalWord;
	}


}
