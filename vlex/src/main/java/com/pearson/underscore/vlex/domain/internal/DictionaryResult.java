package com.pearson.underscore.vlex.domain.internal;

import java.util.List;


public class DictionaryResult {

	private String headword;
	private List<DictionarySense> senses;

	public String getHeadword() {
		return headword;
	}

	public void setHeadword(String headword) {
		this.headword = headword;
	}

	public List<DictionarySense> getSenses() {
		return senses;
	}

	public void setSenses(List<DictionarySense> senses) {
		this.senses = senses;
	}
}
