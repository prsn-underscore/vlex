package com.pearson.underscore.vlex.domain.internal;

import java.util.ArrayList;
import java.util.List;

public class Definition {

	private String englishWord;

	//private List<String> nativeLanguageDefinitions = new ArrayList<String>();
	private String nativeLanguageDefinition;

	public String getEnglishWord() {
		return englishWord;
	}

	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}

	public String getNativeLanguageDefinition() {
		return nativeLanguageDefinition;
	}

	public void setNativeLanguageDefinition(String nativeLanguageDefinition) {
		this.nativeLanguageDefinition = nativeLanguageDefinition;
	}

	/*
	public List<String> getNativeLanguageDefinitions() {
		return nativeLanguageDefinitions;
	}

	public void setNativeLanguageDefinitions(List<String> nativeLanguageDefinitions) {
		this.nativeLanguageDefinitions = nativeLanguageDefinitions;
	}

	public void addNativeLanguageDefinition(String nativeLanguageDefinition) {
		this.nativeLanguageDefinitions.add(nativeLanguageDefinition);
	}
	*/
}
