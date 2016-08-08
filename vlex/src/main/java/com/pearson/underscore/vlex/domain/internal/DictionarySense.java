package com.pearson.underscore.vlex.domain.internal;

import java.util.List;


public class DictionarySense {

	private String[] definition;
	private List<DictionaryTranslation> translations;

	public String[] getDefinition() {
		return definition;
	}

	public void setDefinition(String[] definition) {
		this.definition = definition;
	}

	public List<DictionaryTranslation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<DictionaryTranslation> translations) {
		this.translations = translations;
	}
}
