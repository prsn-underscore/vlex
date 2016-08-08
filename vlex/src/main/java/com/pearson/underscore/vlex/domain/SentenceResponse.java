package com.pearson.underscore.vlex.domain;

import com.pearson.underscore.vlex.domain.internal.Translation;

import java.util.ArrayList;
import java.util.List;


public class SentenceResponse {

	private String object;
	private String subject;
	private String verb;
	private String translatedLanguage;
	private List<Translation> sentences = new ArrayList<Translation>();

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getTranslatedLanguage() {
		return translatedLanguage;
	}

	public void setTranslatedLanguage(String translatedLanguage) {
		this.translatedLanguage = translatedLanguage;
	}

	public List<Translation> getTranslations() {
		return sentences;
	}

	public void setTranslations(List<Translation> translations) {
		this.sentences = translations;
	}

	public void addTranslation(Translation translation) {
		this.sentences.add(translation);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}
}
